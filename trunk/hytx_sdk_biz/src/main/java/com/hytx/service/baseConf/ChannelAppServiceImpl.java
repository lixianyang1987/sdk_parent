package com.hytx.service.baseConf;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.baseConf.ex.ChannelAppMapperEx;
import com.hytx.dao.baseConf.ori.ChannelAppMapper;
import com.hytx.dao.baseConf.ori.ProvinceRefMapper;
import com.hytx.dto.baseConf.ChannelAppDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.model.baseConf.ProvinceRefExample;
import com.hytx.util.Page;

@Service("channelAppServiceImpl")
public class ChannelAppServiceImpl implements IChannelAppService {
	@Autowired
	private ChannelAppMapper channelAppMapper;
	@Autowired
	private ChannelAppMapperEx channelAppMapperEx;
	@Autowired
	private ProvinceRefMapper provinceRefMapper;
	@Autowired
	private ISettlementChannelAppService settlementChannelAppService;

	@Override
	@Transactional(readOnly = true)
	public List<ChannelAppDto> selectChannelAppsByPage(
			ChannelApp findChannelApp, Page<ChannelAppDto> page) {
		List<ChannelAppDto> resultList = channelAppMapperEx
				.selectChannelAppListByPage(findChannelApp, page);
		page.setResultList(resultList);
		page.setTotalCount(channelAppMapperEx.countChannelApp(findChannelApp));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(ChannelApp channelApp) {
		return channelAppMapper.insert(channelApp);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(ChannelApp channelApp) {
		ChannelApp record = channelAppMapper.selectByPrimaryKey(channelApp
				.getId());
		channelApp.setCreateBy(record.getCreateBy());
		channelApp.setCreateDt(record.getCreateDt());
		channelApp.setSignKey(record.getSignKey());
		if (record.getSignKey() == null) {
			channelApp.setSignKey(UUID.randomUUID().toString());
		}
		return channelAppMapper.updateByPrimaryKeySelective(channelApp);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteChannelAppByIds(List<Integer> idList) {
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andIdIn(idList);
		int rows = channelAppMapper.deleteByExample(example);
		ProvinceRefExample refExample = new ProvinceRefExample();
		// 删除关联的渠道包省份
		refExample.createCriteria().andRecordIdIn(idList)
				.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_CHANNEL_APP);
		settlementChannelAppService.delsSmApp(idList);
		provinceRefMapper.deleteByExample(refExample);
		return rows;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteChannelAppByAppIds(List<Integer> idList) {
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andAppIdIn(idList);
		List<ChannelApp> list = channelAppMapper.selectByExample(example);
		settlementChannelAppService.delsSmApp(idList);
		return deleteChannelAppByList(list);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteChannelAppByChannelIds(List<Integer> idList) {
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andChannelIdIn(idList);
		List<ChannelApp> list = channelAppMapper.selectByExample(example);
		return deleteChannelAppByList(list);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteChannelAppByList(List<ChannelApp> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		List<Integer> idList = new ArrayList<Integer>();
		for (ChannelApp ca : list) {
			idList.add(ca.getId());
		}
		return deleteChannelAppByIds(idList);
	}

	@Override
	public ChannelApp selectByPrimaryKey(Integer id) {
		return channelAppMapper.selectByPrimaryKey(id);
	}

	public ChannelAppDto selectChannelAppDtoById(Integer id) {
		return channelAppMapperEx.selectChannelAppDtoById(id);
	}
	@Override
	public ChannelApp selectChannelAppId(ChannelAppExample example) {
		ChannelApp ca = new ChannelApp();
		List<ChannelApp> list=channelAppMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			ca=list.get(0);
		}else{
			ca=null;
		}
		
		return ca;
	}

	@Override
	public List<ChannelApp> selectChannelAppIdlist(ChannelAppExample example) {
		// TODO Auto-generated method stub
		return channelAppMapper.selectByExample(example);
	}
	
	

}
