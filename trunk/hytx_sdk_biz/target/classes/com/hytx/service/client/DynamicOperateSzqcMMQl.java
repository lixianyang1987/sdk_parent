package com.hytx.service.client;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncProvinceZjhyExample;
import com.hytx.model.sync.SyncSzqcReq;
import com.hytx.model.sync.SyncSzqcSms;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.sync.ISyncSzqcReqService;

@Service("dynamicOperateSzqcMMQl")
public class DynamicOperateSzqcMMQl implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private ISyncSzqcReqService syncSzqcReqService;
	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;

	/**
	 * 获取上海力耀动态指令
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		// TODO Auto-generated method stub
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		SyncSzqcReq syscSzqcReq = new SyncSzqcReq();
		int serialNum = reqSmsService.getNextSerialNum();
		syscSzqcReq.setExt("CFF803");
		syscSzqcReq.setCpid("4094dbac");
		syscSzqcReq.setFee(feeValue.toString());
		syscSzqcReq.setImsi(smsReq.getImsi());
		syscSzqcReq.setImei(baseReqDto.getImei());
		Province p = provinceService.selectByPrimaryKey(baseReqDto
				.getProvinceId());
		String province = p.getProvinceName();
		SyncProvinceZjhyExample example = new SyncProvinceZjhyExample();
		example.createCriteria().andProvincenameEqualTo(province);
		syscSzqcReq.setProvince(provincezjhy.selectByExample(example).get(0)
				.getProvinceid().toString());
		syscSzqcReq.setIp(smsReq.getIp());
		syscSzqcReq.setBsccid("40021");
		syscSzqcReq.setBsclac("37143");
		syscSzqcReq.setGpslat(baseReqDto.getLatitude());
		syscSzqcReq.setGpslng(baseReqDto.getLongitude());
		SyncSzqcSms syncSzqcSms = syncSzqcReqService.syncZjhyReq(syscSzqcReq);
		if (syncSzqcSms == null
				|| StringUtils.isBlank(syncSzqcSms.getContent())) {
			return null;
		}
		ReqSmsCommand command = new ReqSmsCommand();
		command.setAppId(dynaOperate.getAppId());
		command.setFeeValue(feeValue);
		command.setOperateId(dynaOperate.getId());
		command.setOrderId(smsReq.getOrderId());
		command.setPayPointId(smsReq.getPayPointId());
		command.setMoContent(syncSzqcSms.getContent());
		command.setUpdateDt(new Date());
		command.setSendStatus(BaseContance.INIT_STATUS);
		command.setMoNum(dynaOperate.getFeeCode());
		command.setSerialNum(serialNum);
		command.setProvinceId(baseReqDto.getProvinceId());
		return command;
	}

}
