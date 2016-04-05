package com.hytx.service.baseConf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.AppServerMapperEx;
import com.hytx.dao.baseConf.ori.AppServerMapper;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.AppServerExample;
import com.hytx.util.Page;

@Service("appServerServiceImpl")
public class AppServerServiceImpl implements IAppServerService {
	@Autowired
	private AppServerMapper appServerMapper;
	@Autowired
	private AppServerMapperEx appServerMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<AppServer> selectAppServersByPage(AppServer findAppServer,
			Page<AppServer> page) {
		List<AppServer> resultList = appServerMapperEx
				.selectAppServerListByPage(findAppServer, page);
		page.setResultList(resultList);
		page.setTotalCount(appServerMapperEx.countAppServer(findAppServer));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(AppServer appServer) {
		return appServerMapper.insert(appServer);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(AppServer appServer) {
		return appServerMapper.updateByPrimaryKeySelective(appServer);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteAppServerByIds(List<Integer> idList) {
		AppServerExample example = new AppServerExample();
		example.createCriteria().andIdIn(idList);
		return appServerMapper.deleteByExample(example);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByAppIds(List<Integer> idList) {
		AppServerExample example = new AppServerExample();
		example.createCriteria().andAppIdIn(idList);
		List<AppServer> appServerList = appServerMapper
				.selectByExample(example);
		if (appServerList == null || appServerList.isEmpty()) {
			return 0;
		}
		List<Integer> appServerIds = new ArrayList<Integer>();
		for (AppServer as : appServerList) {
			appServerIds.add(as.getId());
		}
		return deleteAppServerByIds(appServerIds);
	}

	@Override
	public AppServer selectByPrimaryKey(Integer id) {
		return appServerMapper.selectByPrimaryKey(id);
	}

	public List<AppServer> selectAllActiveAppServer() {
		AppServerExample example = new AppServerExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return appServerMapper.selectByExample(example);
	}

	@Override
	public List<AppServer> selectAppServersByAppIds(List<Integer> appIds) {
		AppServerExample example = new AppServerExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue())
				.andAppIdIn(appIds);
		return appServerMapper.selectByExample(example);
	}

}
