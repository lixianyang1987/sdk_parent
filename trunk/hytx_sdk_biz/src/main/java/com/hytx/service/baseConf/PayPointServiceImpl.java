package com.hytx.service.baseConf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.cache.MyClearCache;
import com.hytx.constance.BaseContance;
import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.PayPointMapperEx;
import com.hytx.dao.baseConf.ori.PayPointMapper;
import com.hytx.dao.baseConf.ori.PayPointOperateMapper;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.baseConf.PayPointExample;
import com.hytx.model.baseConf.PayPointOperate;
import com.hytx.model.baseConf.PayPointOperateExample;
import com.hytx.util.Page;

@Service("payPointServiceImpl")
@MyClearCache(value = { "selectAllActivityStaticPayPoint",
		"selectAllActivityDynaPayPoint" })
public class PayPointServiceImpl implements IPayPointService {
	@Autowired
	private PayPointMapper payPointMapper;
	@Autowired
	private PayPointMapperEx payPointMapperEx;
	@Autowired
	private PayPointOperateMapper payPointOperateMapper;
	@Autowired
	private IOperateService operateService;
	@Autowired
	private IAppServerService appServerService;
	@Autowired
	private IAppService appService;

	@Override
	@Transactional(readOnly = true)
	public List<PayPoint> selectPayPointsByPage(PayPoint findPayPoint,
			Page<PayPoint> page) {
		List<PayPoint> resultList = payPointMapperEx.selectPayPointListByPage(
				findPayPoint, page);
		page.setResultList(resultList);
		page.setTotalCount(payPointMapperEx.countPayPoint(findPayPoint));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(PayPoint payPoint) {
		return payPointMapper.insert(payPoint);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(PayPoint payPoint) {
		return payPointMapper.updateByPrimaryKeySelective(payPoint);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deletePayPointByIds(List<Integer> idList) {
		PayPointExample example = new PayPointExample();
		example.createCriteria().andIdIn(idList);
		int rows = payPointMapper.deleteByExample(example);
		// 删除关联的计费点指令
		PayPointOperateExample caoExample = new PayPointOperateExample();
		caoExample.createCriteria().andPaypointIdIn(idList);
		payPointOperateMapper.deleteByExample(caoExample);
		return rows;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deletePayPointByAppIds(List<Integer> idList) {
		PayPointExample example = new PayPointExample();
		example.createCriteria().andAppIdIn(idList);
		List<PayPoint> payPointList = payPointMapper.selectByExample(example);
		if (payPointList == null || payPointList.isEmpty()) {
			return 0;
		}
		List<Integer> payPointIds = new ArrayList<Integer>();
		for (PayPoint p : payPointList) {
			payPointIds.add(p.getId());
		}
		return deletePayPointByAppIds(payPointIds);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deletePayPointByOpIds(List<Integer> idList) {
		PayPointOperateExample ppoExample = new PayPointOperateExample();
		ppoExample.createCriteria().andOperateIdIn(idList);
		List<PayPointOperate> ppoList = payPointOperateMapper
				.selectByExample(ppoExample);
		if (ppoList == null || ppoList.isEmpty()) {
			return 0;
		}
		List<Integer> payPointIds = new ArrayList<Integer>();
		for (PayPointOperate p : ppoList) {
			payPointIds.add(p.getPaypointId());
		}
		PayPointExample example = new PayPointExample();
		example.createCriteria().andIdIn(payPointIds);
		// 删除计费点
		int rows = payPointMapper.deleteByExample(example);
		// 删除计费点指令
		payPointOperateMapper.deleteByExample(ppoExample);
		return rows;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updatePayPointStatusByOpIds(List<Integer> idList, Integer status) {
		PayPointOperateExample ppoExample = new PayPointOperateExample();
		ppoExample.createCriteria().andOperateIdIn(idList);
		List<PayPointOperate> ppoList = payPointOperateMapper
				.selectByExample(ppoExample);
		if (ppoList == null || ppoList.isEmpty()) {
			return 0;
		}
		List<Integer> payPointIds = new ArrayList<Integer>();
		for (PayPointOperate p : ppoList) {
			payPointIds.add(p.getPaypointId());
		}
		PayPointExample example = new PayPointExample();
		example.createCriteria().andIdIn(payPointIds);
		PayPoint record = new PayPoint();
		record.setStatus(status);
		int rows = payPointMapper.updateByExampleSelective(record, example);
		return rows;
	}

	@Override
	public PayPoint selectByPrimaryKey(Integer id) {
		return payPointMapper.selectByPrimaryKey(id);
	}

	public List<PayPoint> selectAllActivePayPoint() {
		PayPointExample example = new PayPointExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return payPointMapper.selectByExample(example);
	}

	@Override
	public List<PayPoint> selectIllegePayPoints(Integer appId,
			Integer serverType) {
		return payPointMapperEx.selectIllegePayPoints(appId, serverType);
	}

	@Override
	public String checkOpenConditionError(Integer id) {
		PayPoint payPoint = payPointMapper.selectByPrimaryKey(id);
		if (payPoint == null) {
			return "不存在要修改的计费点";
		}
		List<Operate> opList = operateService.selectOperateByPayPointIds(id);
		if (opList == null || opList.isEmpty()) {
			return "此计费点没有指令，不能启用";
		}
		List<Integer> opAppIdList = new ArrayList<Integer>();
		for (Operate op : opList) {
			if (!op.getStatus().equals(BaseContance.ACTIVICE_STATUS)) {
				return "添加的指令" + op.getOpName() + "已失效，不能启用";
			}
			if (!op.getAppId().equals(payPoint.getAppId())) {
				opAppIdList.add(op.getAppId());
			}
		}
		if (!opAppIdList.isEmpty()) {
			List<AppServer> appServerList = appServerService
					.selectAppServersByAppIds(opAppIdList);
			for (AppServer as : appServerList) {
				if (as.getOpRange().equals(BaseContance.OP_PRIVATE)
						&& as.getServerType().equals(payPoint.getServerType())) {
					App app = appService.selectByPrimaryKey(as.getAppId());
					return "应用" + app.getAppName()
							+ "已将运营商配置的指令范围指定为私有，此计费点不能包括其指令，不能启用";
				}
			}
		}
		return null;
	}

}
