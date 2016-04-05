package com.hytx.service.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.constance.DictKeyInfo;
import com.hytx.constance.ReqSmsCodeConstance;
import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dao.client.ex.ReqSmsMapperEx;
import com.hytx.dao.client.ori.ReqSmsCommandMapper;
import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.client.ReqSmsCommandExample;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.baseConf.IOperateService;
import com.hytx.util.StringUtil;

@Service("reqSmsServiceImpl")
public class ReqSmsServiceImpl implements IReqSmsService {
	private static Logger logger = LoggerFactory
			.getLogger(ReqSmsServiceImpl.class);
	@Autowired
	private ReqSmsMapper reqSmsMapper;
	@Autowired
	private ReqSmsMapperEx reqSmsMapperEx;
	@Autowired
	private ReqSmsCommandMapper reqSmsCommandMapper;
	@Autowired
	private ReqSmsCommandMapperEx reqSmsCommandMapperEx;
	@Autowired
	private IOperateService operateService;
	@Autowired
	private IBaseReqService baseReqService;
	@Autowired
	private IDictService dictService;

	@Autowired
	private IDynamicOperateService dynaMicOperateService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(ReqSms reqSms) {
		return reqSmsMapper.insert(reqSms);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(ReqSms reqSms) {
		return reqSmsMapper.updateByPrimaryKeySelective(reqSms);
	}

	@Override
	public ReqSms selectByPrimaryKey(String id) {
		return reqSmsMapper.selectByPrimaryKey(id);
	}

	public List<ReqSmsCommand> selectReqSmsCommandByOrderId(String orderId) {
		ReqSmsCommandExample example = new ReqSmsCommandExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return reqSmsCommandMapper.selectByExample(example);
	}

	/****
	 * 获取计费指令，保存相关记录
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @param bestPayPoint
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReqSmsCommand> findCommandList(ReqSms smsReq,
			BaseReqDto baseReqDto) {
		ChannelApp channelApp = baseReqDto.getChannelApp();
		List<ReqSmsCommand> commandList = new ArrayList<ReqSmsCommand>();
		// 检查是否是重复请求
		ReqSms record = selectByPrimaryKey(smsReq.getOrderId());
		// 为避免sdk生成的uuid重复，做以下检测
		if (record != null) {
			if (!record.getChannelAppKey().equals(smsReq.getChannelAppKey())
					|| !record.getImsi().equals(smsReq.getImsi())
					|| !record.getFeeValue().equals(smsReq.getFeeValue())) {
				record = null;
				smsReq.setOrderId(UUID.randomUUID().toString());
			}
		}
		if (record == null
				|| !record.getStatus().equals(ReqSmsCodeConstance.SUCCESS)) {
			PayPoint bestPayPoint = findBestPayPoint(smsReq, baseReqDto);
			commandList = selectReqSmsCommandList(smsReq, baseReqDto,
					bestPayPoint);
			// 记录请求数据
			if (commandList == null || commandList.isEmpty()) {
				if (ThreadLocalCache.hasOrderdMark()) {
					smsReq.setStatus(ReqSmsCodeConstance.HAS_ORDERD);
				} else {
					smsReq.setStatus(ReqSmsCodeConstance.NO_COMMAND_ERROR);
				}
			} else {
				// 添加附加计费
				List<ReqSmsCommand> appendCommandList = selectAutoChargeCommandList(
						smsReq, baseReqDto);
				if (appendCommandList != null && !appendCommandList.isEmpty()) {
					commandList.addAll(appendCommandList);
				}
				for (ReqSmsCommand cmd : commandList) {
					App app = baseReqService.selectAppById(cmd.getAppId());
					AppServer appServer = baseReqService.getAppServer(
							app.getId(), baseReqDto.getServerType());
					cmd.setControlFlag(appServer.getControlFlag());
					cmd.setWaitSeconds(appServer.getWaitSeconds());
					cmd.setServerType(baseReqDto.getServerType());
					cmd.setProvinceId(baseReqDto.getProvinceId());
					cmd.setOrderId(smsReq.getOrderId());
					printConsumerLog(smsReq, cmd, baseReqDto);
					reqSmsCommandMapper.insert(cmd);
				}
				smsReq.setStatus(ReqSmsCodeConstance.SUCCESS);
				if (record != null) {
					record.setStatus(ReqSmsCodeConstance.SUCCESS);
					updateByPrimaryKeySelective(record);
				}
			}
			if (record == null) {
				smsReq.setChannelId(channelApp.getChannelId());
				smsReq.setAppId(channelApp.getAppId());
				smsReq.setUpdateDt(new Date());
				if (bestPayPoint != null) {
					smsReq.setPayPointId(bestPayPoint.getId());
				}
				insert(smsReq);
			}
		}
		commandList = selectReqSmsCommandByOrderId(smsReq.getOrderId());
		return commandList;
	}

	private void printConsumerLog(ReqSms smsReq, ReqSmsCommand cmd,
			BaseReqDto baseReqDto) {
		logger.info(
				"用户{}对应用{}当日消费：{}",
				smsReq.getImsi(),
				cmd.getAppId(),
				baseReqService.getDayUserAppConsumer(smsReq.getImsi(),
						cmd.getAppId())
						+ cmd.getFeeValue());
		logger.info(
				"用户{}对应用{}当月消费：{}",
				smsReq.getImsi(),
				cmd.getAppId(),
				baseReqService.getMonthUserAppConsumer(smsReq.getImsi(),
						cmd.getAppId())
						+ cmd.getFeeValue());
		ChannelApp channelApp = baseReqDto.getChannelApp();
		logger.info(
				"应用{}对省份{}今日消费：{}",
				cmd.getAppId(),
				baseReqDto.getProvinceId(),
				baseReqService.getAppDayLimit(cmd.getAppId(),
						baseReqDto.getProvinceId())
						+ cmd.getFeeValue());
		logger.info(
				"渠道包{}:{}对省份{}今日消费：{}",
				channelApp.getChannelId(),
				channelApp.getAppId(),
				baseReqDto.getProvinceId(),
				baseReqService.getChannelAppDayLimit(channelApp.getChannelId(),
						channelApp.getAppId(), baseReqDto.getProvinceId())
						+ cmd.getFeeValue());
	}

	/****
	 * 更新指令发送状态
	 * 
	 * @param commandIdList
	 * @param statusList
	 * @param orderDt
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public int updateReqSmsResult(List<Long> commandIdList,
			List<Integer> statusList, Date orderDt, BaseReqDto baseReqDto) {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		int i = 0;
		for (Long cid : commandIdList) {
			map.put(cid, statusList.get(i));
			i++;
		}
		ReqSmsCommandExample example = new ReqSmsCommandExample();
		example.createCriteria().andIdIn(commandIdList);
		List<ReqSmsCommand> list = reqSmsCommandMapper.selectByExample(example);
		ChannelApp channelApp = baseReqDto.getChannelApp();
		for (ReqSmsCommand rsc : list) {
			Integer status = map.get(rsc.getId());
			if (status != null) {
				if (rsc.getUpdateDt().getTime() != orderDt.getTime()) {
					rsc.setSendStatus(status);
				} else {
					rsc.setSendStatus(status & rsc.getSendStatus());
				}
				Integer sendTimes = rsc.getSendTimes();
				rsc.setSendTimes(sendTimes == null ? 1 : sendTimes + 1);
				rsc.setUpdateDt(orderDt);
				reqSmsCommandMapper.updateByPrimaryKey(rsc);
				// 增加消费缓存
				baseReqService.addDayUserAppConsumer(baseReqDto.getImsi(),
						rsc.getAppId(), rsc.getFeeValue());
				baseReqService.addMonthUserAppConsumer(baseReqDto.getImsi(),
						rsc.getAppId(), rsc.getFeeValue());
				baseReqService.appendAppDayLimit(rsc.getAppId(),
						baseReqDto.getProvinceId(), rsc.getFeeValue());
				baseReqService.appendChannelAppDayLimit(
						channelApp.getChannelId(), rsc.getAppId(),
						baseReqDto.getProvinceId(), rsc.getFeeValue());
			}
		}
		return i;
	}

	/****
	 * 根据计费点查找指令
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @param bestPayPoint
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public List<ReqSmsCommand> selectReqSmsCommandList(ReqSms smsReq,
			BaseReqDto baseReqDto, PayPoint bestPayPoint) {
		List<ReqSmsCommand> commandList = new ArrayList<ReqSmsCommand>();
		List<Operate> opList = null;
		if (bestPayPoint != null) {
			opList = operateService.selectOperateByPayPointIds(bestPayPoint
					.getId());
			if (opList != null && !opList.isEmpty()) {
				// 如果计费点下的指令存在超限的情况，则丢弃计费点的指令
				for (Operate op : opList) {
					App app = baseReqService.selectAppById(op.getAppId());
					if (!baseReqService.checkUserAppLimit(smsReq.getImsi(),
							baseReqDto.getServerType(), app,
							smsReq.getFeeValue())) {
						opList = null;
						break;
					}
				}
			}
		}
		if (opList == null || opList.isEmpty()) {
			// 如果没有计费点或计费点里指令为空，则查询指令自动找出最佳指令组合计费
			opList = findOperates(smsReq, baseReqDto);
		}
		if (opList == null || opList.isEmpty()) {
			return commandList;
		}
		for (Operate op : opList) {
			if (op.getOpType().equals(BaseContance.OPERATE_TYPE_STATIC)) {
				ReqSmsCommand cmd = new ReqSmsCommand();
				Integer serialNum = getNextSerialNum();
				String linkId = format(serialNum + "", 7);// 透传参数
				if (op.getAppId().equals(320)) {// 如果是浙江环宇的应用，做特殊处理，他们那边要求一个月不重复，可传13位，所在我们在前边加上年月日
					linkId = DateFormatUtils.format(new Date(), "yyMMdd")
							+ linkId;
				}
				cmd.setSerialNum(serialNum);
				cmd.setMoContent(StringUtil.formatContent(op.getOpCode(),
						linkId));// 指令内容
				cmd.setMoNum(op.getFeeCode());
				cmd.setOperateId(op.getId());
				cmd.setOrderId(smsReq.getOrderId());
				cmd.setSendStatus(BaseContance.INIT_STATUS);
				cmd.setUpdateDt(new Date());
				cmd.setFeeValue(op.getPrice());
				cmd.setAppId(op.getAppId());
				if (op.getEnsureNum() != null) {
					cmd.setEnsureNum(new BigDecimal(op.getEnsureNum()));
				}
				if (bestPayPoint != null) {
					cmd.setPayPointId(bestPayPoint.getId());
				}
				if (op.getEnsureType() != null && op.getEnsureType() > 0) {
					cmd.setTwoEnsure(op.getEnsureContent());
				}
				commandList.add(cmd);
			} else {
				// 动态指令处理
				ReqSmsCommand command = dynaMicOperateService
						.changeOperateToCommand(smsReq, baseReqDto, op);
				if (command != null) {
					if (op.getEnsureType() != null && op.getEnsureType() > 0) {
						command.setTwoEnsure(op.getEnsureContent());
					}
					commandList.add(command);
				}
			}
		}
		return commandList;
	}

	/*****
	 * 查找某资费的最佳计费点，优先顺序为1：同应用内相同paycode的静态计费点，2：同应用内的静态计费点，
	 * 3:同应用的动态计费点,4不同应用的静态计费点，5不同应用的态动计费点,暂时只找相同应用的计费点
	 * 
	 * @update:只找渠道包配置的计费点
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public PayPoint findBestPayPoint(ReqSms smsReq, BaseReqDto baseReqDto) {
		ChannelApp channelApp = baseReqDto.getChannelApp();
		/*List<PayPoint> staticPayPointList = baseReqService
				.selectAllActivityStaticPayPoint(baseReqDto.getServerType(),
						smsReq.getFeeValue());*/
		// 查询渠道包配置的静态计费点
		List<PayPoint> staticPayPointList = baseReqService
				.selectChannelAppStaticActivityPayPoint(channelApp.getId(),
						baseReqDto.getServerType(), smsReq.getFeeValue());
		PayPoint bestPayPoint = null;
		// 找相同应用下的计费点
		if (staticPayPointList != null && !staticPayPointList.isEmpty()) {
			for (PayPoint p : staticPayPointList) {
				if (p.getAppId().equals(baseReqDto.getApp().getId())) {
					if (baseReqDto.getProvinceId() == null
							|| baseReqService.checkAppProvinceLimit(
									p.getAppId(), baseReqDto.getProvinceId())) {
						bestPayPoint = p;
						if (StringUtils.isEmpty(smsReq.getPayCode())) {
							break;
						}
						if (p.getPayCode().equals(smsReq.getPayCode())) {
							break;
						}
					}
				}
			}
			if (bestPayPoint != null) {
				return bestPayPoint;
			}
		}
		// 找渠道包配置的相同应用下的动态计费点
		/*List<PayPoint> dynaPayPointList = baseReqService
				.selectAllActivityDynaPayPoint(baseReqDto.getServerType());*/
		List<PayPoint> dynaPayPointList = baseReqService
				.selectCaActivityDynaPayPoint(channelApp.getId(),
						baseReqDto.getServerType());
		if (dynaPayPointList != null && !dynaPayPointList.isEmpty()) {
			for (PayPoint p : dynaPayPointList) {
				if (p.getAppId().equals(baseReqDto.getApp().getId())) {
					if (baseReqDto.getProvinceId() == null
							|| baseReqService.checkAppProvinceLimit(
									p.getAppId(), baseReqDto.getProvinceId())) {
						bestPayPoint = p;
						if (StringUtils.isEmpty(smsReq.getPayCode())) {
							break;
						}
						if (p.getPayCode().equals(smsReq.getPayCode())) {
							break;
						}
					}
				}
			}
			if (bestPayPoint != null) {
				return bestPayPoint;
			}
		}

		// 找其它应用的计费点
		if (staticPayPointList != null && !staticPayPointList.isEmpty()) {
			for (PayPoint p : staticPayPointList) {
				if (!p.getAppId().equals(smsReq.getAppId())) {
					if (baseReqDto.getProvinceId() == null
							|| baseReqService.checkAppProvinceLimit(
									p.getAppId(), baseReqDto.getProvinceId())) {
						bestPayPoint = p;
						if (StringUtils.isEmpty(smsReq.getPayCode())) {
							break;
						}
						if (p.getPayCode().equals(smsReq.getPayCode())) {
							break;
						}
					}
				}
			}
			if (bestPayPoint != null) {
				return bestPayPoint;
			}
		}
		if (dynaPayPointList != null && !dynaPayPointList.isEmpty()) {
			for (PayPoint p : dynaPayPointList) {
				if (!p.getAppId().equals(smsReq.getAppId())) {
					if (baseReqDto.getProvinceId() == null
							|| baseReqService.checkAppProvinceLimit(
									p.getAppId(), baseReqDto.getProvinceId())) {
						bestPayPoint = p;
						if (StringUtils.isEmpty(smsReq.getPayCode())) {
							break;
						}
						if (p.getPayCode().equals(smsReq.getPayCode())) {
							break;
						}
					}
				}
			}
			if (bestPayPoint != null) {
				return bestPayPoint;
			}
		}
		return bestPayPoint;
	}

	/****
	 * 根据费用查找指令组合进行计费
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @return
	 * @author houzz
	 * @date 2015年6月1日
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Operate> findOperates(ReqSms smsReq, BaseReqDto baseReqDto) {
		ChannelApp channelApp = baseReqDto.getChannelApp();
		List<Operate> resultList = new ArrayList<Operate>();
		// 先找静态指令
		/*List<Operate> opList = baseReqService
				.selectServerStaticOperates(baseReqDto.getServerType());*/
		List<Operate> opList = baseReqService.selectCaServerStaticOperates(
				channelApp.getId(), baseReqDto.getServerType());
		List<Operate> appOpList = new ArrayList<Operate>();
		if (opList != null && !opList.isEmpty()) {
			for (Operate op : opList) {
				if (op.getPrice() > smsReq.getFeeValue()) {
					continue;
				}
				// 应用私有指令不能用
				AppServer as = baseReqService.getAppServer(op.getAppId(),
						baseReqDto.getServerType());
				if (as != null && as.getOpRange() != null
						&& as.getOpRange().equals(BaseContance.OP_PRIVATE)
						&& !op.getAppId().equals(baseReqDto.getApp().getId())) {
					continue;
				}
				// 省份限量检查
				if (baseReqDto.getProvinceId() == null
						|| baseReqService.checkAppProvinceLimit(op.getAppId(),
								baseReqDto.getProvinceId())) {
					appOpList.add(op);
				}
			}
		}
		if (!appOpList.isEmpty()) {
			Collections.sort(appOpList, new MyOperateComparator(baseReqDto
					.getApp().getId()));
			// 根据费用筛选指令组合
			Map<Operate, Integer> resultMap = caculateBestGroupOperate(
					smsReq.getFeeValue(), appOpList, smsReq.getImsi(),
					baseReqDto.getServerType());
			if (!resultMap.isEmpty()) {
				for (Entry<Operate, Integer> entry : resultMap.entrySet()) {
					if (entry.getValue() > 0) {
						for (int i = 0; i < entry.getValue(); i++) {
							resultList.add(entry.getKey());
						}
					}
				}
				return resultList;
			}
		}
		// 静态指令不满足再找动态指令
		/*	List<Operate> dynaOpList = baseReqService
					.selectServerDynaOperates(baseReqDto.getServerType());*/
		List<Operate> dynaOpList = baseReqService.selectCaServerDynaOperates(
				channelApp.getId(), baseReqDto.getServerType());
		if (dynaOpList == null || dynaOpList.isEmpty()) {
			Map<Operate, Integer> dataMap = caculateGoodGroupOperate(
					smsReq.getFeeValue(), appOpList, smsReq.getImsi(),
					baseReqDto.getServerType());
			if (!dataMap.isEmpty()) {
				for (Entry<Operate, Integer> entry : dataMap.entrySet()) {
					if (entry.getValue() > 0) {
						for (int i = 0; i < entry.getValue(); i++) {
							resultList.add(entry.getKey());
						}
					}
				}
			}
			return resultList;
		}
		for (Operate op : dynaOpList) {
			if (op.getAppId().equals(baseReqDto.getApp().getId())) {
				if (baseReqDto.getProvinceId() != null
						&& !baseReqService.checkAppProvinceLimit(op.getAppId(),
								baseReqDto.getProvinceId())) {
					continue;
				}
				App app = baseReqService.selectAppById(op.getAppId());
				boolean validResult = baseReqService.checkUserAppLimit(
						smsReq.getImsi(), baseReqDto.getServerType(), app,
						smsReq.getFeeValue());
				if (validResult) {
					if (op.getPrice() == null || op.getPrice().equals(0)) {
						resultList.clear();
						resultList.add(op);
						return resultList;
					} else {
						resultList.add(op);
					}
				}
			}
		}
		for (Operate op : dynaOpList) {
			if (!op.getAppId().equals(baseReqDto.getApp().getId())) {
				// 应用私有指令不能用
				AppServer as = baseReqService.getAppServer(op.getAppId(),
						baseReqDto.getServerType());
				if (as != null && as.getOpRange() != null
						&& as.getOpRange().equals(BaseContance.OP_PRIVATE)) {
					continue;
				}
				// 省份限量检查
				if (baseReqDto.getProvinceId() != null
						&& !baseReqService.checkAppProvinceLimit(op.getAppId(),
								baseReqDto.getProvinceId())) {
					continue;
				}
				// 应用用户限量检查
				App app = baseReqService.selectAppById(op.getAppId());
				boolean validResult = baseReqService.checkUserAppLimit(
						smsReq.getImsi(), baseReqDto.getServerType(), app,
						smsReq.getFeeValue());
				if (validResult) {
					if (op.getPrice() == null || op.getPrice().equals(0)) {
						resultList.clear();
						resultList.add(op);
						return resultList;
					} else {
						resultList.add(op);
					}
				}
			}
		}
		if (!resultList.isEmpty()) {
			appOpList.addAll(resultList);
			resultList.clear();
			Collections.sort(appOpList, new MyOperateComparator(baseReqDto
					.getApp().getId()));
			// 根据费用筛选指令组合
			Map<Operate, Integer> resultMap = caculateBestGroupOperate(
					smsReq.getFeeValue(), appOpList, smsReq.getImsi(),
					baseReqDto.getServerType());
			if (!resultMap.isEmpty()) {
				for (Entry<Operate, Integer> entry : resultMap.entrySet()) {
					if (entry.getValue() > 0) {
						for (int i = 0; i < entry.getValue(); i++) {
							resultList.add(entry.getKey());
						}
					}
				}
				return resultList;
			}
		}
		if (!appOpList.isEmpty()) {
			resultList.clear();
			Map<Operate, Integer> dataMap = caculateGoodGroupOperate(
					smsReq.getFeeValue(), appOpList, smsReq.getImsi(),
					baseReqDto.getServerType());
			if (!dataMap.isEmpty()) {
				for (Entry<Operate, Integer> entry : dataMap.entrySet()) {
					if (entry.getValue() > 0) {
						for (int i = 0; i < entry.getValue(); i++) {
							resultList.add(entry.getKey());
						}
					}
				}
				return resultList;
			}
		}
		return null;
	}

	/*****
	 * 指令比较类，用于自动选择最佳指令组合时排序，顺序决定着选择的优先性,在集合中的下标越大会优先被选择 按价格和权重升序排序
	 * 
	 * @author houzz
	 *
	 */
	private static class MyOperateComparator implements Comparator<Operate> {
		private Integer nowAppId;

		public MyOperateComparator(Integer nowAppId) {
			this.nowAppId = nowAppId;
		}

		@Override
		public int compare(Operate o1, Operate o2) {
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			int c1 = nowAppId.compareTo(o1.getAppId());
			int c2 = nowAppId.compareTo(o2.getAppId());
			if (c1 == 0 && c2 == 0) {
				int result = o1.getPrice().compareTo(o2.getPrice());
				if (result == 0) {
					return o1.getWeight().compareTo(o2.getWeight());
				} else {
					return result;
				}
			}
			if (c1 == 0) {
				return 1;
			}
			if (c2 == 0) {
				return -1;
			}
			int result = o1.getPrice().compareTo(o2.getPrice());
			if (result == 0) {
				return o1.getWeight().compareTo(o2.getWeight());
			} else {
				return result;
			}
		}

	}

	/****
	 * 根据计费金额和给定的一批指令，自动找出满足计费金额的最佳指令组合,且使用的指令不能超出应用对用户的日月限
	 * 
	 * @param num
	 *            计费金额
	 * @param list
	 * @param imsi
	 * @param serverType
	 * @param app
	 * @return 返回指令组和的map映射集，key为指令，value为指令的数量
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public Map<Operate, Integer> caculateBestGroupOperate(int num,
			List<Operate> list, String imsi, Integer serverType) {
		Map<Operate, Integer> map = new HashMap<Operate, Integer>();
		Map<Operate, Integer> resultMap = new HashMap<Operate, Integer>();
		if (list == null || list.isEmpty()) {
			return resultMap;
		}
		String s = "";
		for (Operate op : list) {
			int left = 0;
			int li = op.getPrice();
			if (li != 0) {
				left = num / li;
			}
			map.put(op, left);
			s = s + left;
		}
		logger.debug(s);
		int loopNum = Integer.parseInt(s);
		for (int i = 0; i <= loopNum; i++) {
			int total = 0;
			String str = format(i + "", s.length());
			String tem = str;
			for (int j = 0; j < list.size(); j++) {
				Operate op = list.get(j);
				int price = op.getPrice();
				int k = map.get(op);
				int n = Integer.parseInt(tem.substring(0, (k + "").length()));
				if (n > k) {
					break;
				}
				tem = tem.substring((k + "").length());
				if (n > 0) {
					total = total + price * n;
					resultMap.put(list.get(j), n);
				}
			}
			if (total == num) {
				boolean isOk = true;
				for (Entry<Operate, Integer> entry : resultMap.entrySet()) {
					App app = baseReqService.selectAppById(entry.getKey()
							.getAppId());
					long feeValue = entry.getKey().getPrice()
							* entry.getValue();
					if (!baseReqService.checkUserAppLimit(imsi, serverType,
							app, feeValue)) {
						isOk = false;
						break;
					}
				}
				if (isOk) {
					return resultMap;
				}
			}
			resultMap.clear();
		}
		return resultMap;
	}

	/****
	 * 根据计费金额和给定的一批指令，在没有满足计费金额的指令组合情况下，找出尽可能多的资费计费指令组合,且使用的指令不能超出应用对用户的日月限
	 * 
	 * @param num
	 *            计费金额
	 * @param list
	 * @param imsi
	 * @param serverType
	 * @param app
	 * @return 返回指令组和的map映射集，key为指令，value为指令的数量
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public Map<Operate, Integer> caculateGoodGroupOperate(int num,
			List<Operate> list, String imsi, Integer serverType) {
		Map<Operate, Integer> map = new HashMap<Operate, Integer>();
		Map<Operate, Integer> resultMap = new HashMap<Operate, Integer>();
		Map<Operate, Integer> dataMap = new HashMap<Operate, Integer>();
		if (list == null || list.isEmpty()) {
			return resultMap;
		}
		String s = "";
		for (Operate op : list) {
			int left = 0;
			int li = op.getPrice();
			if (li != 0) {
				left = num / li;
			}
			map.put(op, left);
			s = s + left;
		}
		logger.debug(s);
		int loopNum = Integer.parseInt(s);
		long max = 0;
		for (int i = 0; i <= loopNum; i++) {
			int total = 0;
			String str = format(i + "", s.length());
			String tem = str;
			for (int j = 0; j < list.size(); j++) {
				Operate op = list.get(j);
				int price = op.getPrice();
				int k = map.get(op);
				int n = Integer.parseInt(tem.substring(0, (k + "").length()));
				if (n > k) {
					break;
				}
				tem = tem.substring((k + "").length());
				if (n > 0) {
					total = total + price * n;
					resultMap.put(list.get(j), n);
				}
			}
			// 由于之前已经做过相等时的筛选，此处就不再考虑这种情况，调用此方法的前提是没有找到完全匹配的组合
			if (total > max && total < num) {
				long tempCount = 0;
				for (Entry<Operate, Integer> entry : resultMap.entrySet()) {
					App app = baseReqService.selectAppById(entry.getKey()
							.getAppId());
					long feeValue = entry.getKey().getPrice()
							* entry.getValue();
					if (baseReqService.checkUserAppLimit(imsi, serverType, app,
							feeValue)) {
						tempCount = tempCount + feeValue;
					}
				}
				if (tempCount > max) {
					max = tempCount;
					dataMap.clear();
					dataMap.putAll(resultMap);
				}
			}
			resultMap.clear();
		}
		return dataMap;
	}

	/****
	 * 根据计费点查找指令
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @param bestPayPoint
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public List<ReqSmsCommand> selectAutoChargeCommandList(ReqSms smsReq,
			BaseReqDto baseReqDto) {
		List<ReqSmsCommand> commandList = new ArrayList<ReqSmsCommand>();
		Dict dict = dictService
				.selectActiviteDictByKey(DictKeyInfo.AUTO_CHARGE_APP_ID_KEY);
		Integer appId = null;
		if (dict != null && dict.getVal() != null) {
			try {
				appId = Integer.parseInt(dict.getVal());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (appId == null) {
			return commandList;
		}
		List<Operate> opList = null;
		opList = operateService.selectActivityOperatesByAppId(appId,
				baseReqDto.getServerType());
		if (opList == null || opList.isEmpty()) {
			return commandList;
		}
		for (Operate op : opList) {
			if (baseReqDto.getProvinceId() != null
					&& !baseReqService.checkAppProvinceLimit(op.getAppId(),
							baseReqDto.getProvinceId())) {
				continue;
			}
			if (op.getOpType().equals(BaseContance.OPERATE_TYPE_STATIC)) {
				ReqSmsCommand cmd = new ReqSmsCommand();
				Integer serialNum = getNextSerialNum();
				String linkId = format(serialNum + "", 7);// 透传参数
				cmd.setSerialNum(serialNum);
				cmd.setMoContent(StringUtil.formatContent(op.getOpCode(),
						linkId));// 指令内容
				cmd.setMoNum(op.getFeeCode());
				cmd.setOperateId(op.getId());
				cmd.setOrderId(smsReq.getOrderId());
				cmd.setSendStatus(BaseContance.INIT_STATUS);
				cmd.setUpdateDt(new Date());
				cmd.setFeeValue(op.getPrice());
				cmd.setAppId(op.getAppId());
				if (op.getEnsureNum() != null) {
					cmd.setEnsureNum(new BigDecimal(op.getEnsureNum()));
				}
				if (op.getEnsureType() != null && op.getEnsureType() > 0) {
					cmd.setTwoEnsure(op.getEnsureContent());
				}
				commandList.add(cmd);
			} else {
				// 动态指令处理
				ReqSmsCommand command = dynaMicOperateService
						.changeOperateToCommand(smsReq, baseReqDto, op);
				if (command != null) {
					if (op.getEnsureType() != null && op.getEnsureType() > 0) {
						command.setTwoEnsure(op.getEnsureContent());
					}
					commandList.add(command);
				}
			}
		}
		return commandList;
	}

	/****
	 * 格式化字符串成某长度的字符串，长度不够时左边补0
	 * 
	 * @param s
	 * @param len
	 * @return
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public static String format(String s, int len) {
		if (s == null || s.length() >= len) {
			return s;
		}
		for (int i = 0, l = len - s.length(); i < l; i++) {
			s = "0" + s;
		}
		return s;
	}

	/***
	 * 查询从什么时候起用户计费失败的记录
	 * 
	 * @param imsi
	 * @param startDate
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年7月10日
	 */
	@Override
	public List<ReqSmsCommand> selectUserFailCommandList(String imsi,
			String startDate, Integer serverType) {
		return reqSmsCommandMapperEx.selectUserFailCommandList(imsi, startDate,
				serverType);
	}

	private static String nowDay = DateFormatUtils.format(new Date(),
			"yyyy-MM-dd");
	private static Integer nextSerialNum = null;

	/*****
	 * 获取下一个serialNum的值，一天内不能重复
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年7月31日
	 */
	synchronized public Integer getNextSerialNum() {
		String toDay = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		if (toDay.compareTo(nowDay) > 0) {
			nowDay = toDay;
			nextSerialNum = 1;
			return nextSerialNum;
		}
		if (nextSerialNum != null) {
			nextSerialNum++;
		} else {
			nextSerialNum = reqSmsCommandMapperEx.selectDayMaxSerialNum(toDay);
			if (nextSerialNum == null) {
				nextSerialNum = 1;
			} else {
				nextSerialNum++;
			}
		}
		return nextSerialNum;
	}

	public String getSevenFormatSerialNum() {
		return format("" + getNextSerialNum(), 7);
	}

	public static void main(String[] args) {
		System.out.println(DateFormatUtils.format(new Date(), "yyMMdd"));
	}

}
