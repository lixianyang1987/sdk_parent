package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.AppMapperEx;
import com.hytx.dao.baseConf.ori.AppMapper;
import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dto.baseConf.AppDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppExample;
import com.hytx.model.baseConf.OperateExample;
import com.hytx.util.Page;

@Service("appServiceImpl")
public class AppServiceImpl implements IAppService {
	@Autowired
	private AppMapper appMapper;
	@Autowired
	private AppMapperEx appMapperEx;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IPayPointService payPointService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private OperateMapper operateMapper;	
	@Autowired
	private ISettlementAppService settlementAppService;

	@Override
	@Transactional(readOnly = true)
	public List<AppDto> selectAppsByPage(App findApp, Page<AppDto> page) {
		List<AppDto> resultList = appMapperEx
				.selectAppListByPage(findApp, page);
		page.setResultList(resultList);
		page.setTotalCount(appMapperEx.countApp(findApp));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(App app) {
		return appMapper.insert(app);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(App app) {
		if (app.getAppDescribe() == null) {
			app.setAppDescribe("");
		}
		if (app.getAppName() == null) {
			app.setAppName("");
		}
		if (app.getAppSn() == null) {
			app.setAppSn("");
		}
		if (app.getAppKey() == null) {
			app.setAppKey("");
		}
		return appMapper.updateByPrimaryKeySelective(app);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteAppByIds(List<Integer> idList) {
		AppExample example = new AppExample();
		example.createCriteria().andIdIn(idList);
		int rows = appMapper.deleteByExample(example);
		// 删除对应的渠道包
		channelAppService.deleteChannelAppByAppIds(idList);
		// 删除对应的计费点
		payPointService.deletePayPointByAppIds(idList);
		//删除关联结算方式
		settlementAppService.delsSmApp(idList);
		// 删除省份关联数据
		provinceService.deleteProvinceRefByRecordIdsAndType(idList,
				BaseContance.PROVINCE_REF_TYPE_APP);
		// 删除对应指令
		OperateExample opExample = new OperateExample();
		opExample.createCriteria().andAppIdIn(idList);
		operateMapper.deleteByExample(opExample);
		return rows;
	}

	@Override
	public App selectByPrimaryKey(Integer id) {
		return appMapper.selectByPrimaryKey(id);
	}

	public List<App> selectAllActiveApp() {
		AppExample example = new AppExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return appMapper.selectByExample(example);
	}

	@Override
	public List<App> selectAppsOfChannel(Integer channelId) {
		return appMapperEx.selectAppsOfChannel(channelId);
	}

	public int countByCpIds(List<Integer> cpIds) {
		AppExample example = new AppExample();
		example.createCriteria().andCpIdIn(cpIds);
		return appMapper.countByExample(example);
	}

	public List<App> selectAppsByChannelAndCp(Integer channelId, Integer cpId) {
		return appMapperEx.selectAppsByChannelAndCp(channelId, cpId);
	}

	@Override
	public List<App> selectAppsByIdList(List<Integer> idList) {
		AppExample example = new AppExample();
		example.createCriteria().andIdIn(idList);
		return appMapper.selectByExample(example);
	}



}
