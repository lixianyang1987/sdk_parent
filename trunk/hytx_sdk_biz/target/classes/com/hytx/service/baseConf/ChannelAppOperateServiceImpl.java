package com.hytx.service.baseConf;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.baseConf.ex.ChannelAppOperateMapperEx;
import com.hytx.dao.baseConf.ori.ChannelAppOperateMapper;
import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.ChannelAppOperateExample;
import com.hytx.model.baseConf.Operate;
import com.hytx.util.Page;

@Service("channelAppOperateServiceImpl")
public class ChannelAppOperateServiceImpl implements IChannelAppOperateService {
	@Autowired
	private ChannelAppOperateMapper channelAppOperateMapper;
	@Autowired
	private ChannelAppOperateMapperEx channelAppOperateMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<Operate> selectOperatesByPage(
			ChannelAppOperate channelAppOperate, Page<Operate> page) {
		List<Operate> resultList = channelAppOperateMapperEx
				.selectOperateListByPage(channelAppOperate, page);
		page.setResultList(resultList);
		page.setTotalCount(channelAppOperateMapperEx
				.countOperate(channelAppOperate));
		return resultList;
	}

	@Transactional(readOnly = true)
	public List<Operate> selectNotAddedOperatesByPage(
			ChannelAppOperate channelAppOperate, Page<Operate> page) {

		List<Operate> resultList = channelAppOperateMapperEx
				.selectNotAddedOperateList(channelAppOperate, page);
		page.setResultList(resultList);
		page.setTotalCount(channelAppOperateMapperEx
				.countNotAddedOperate(channelAppOperate));
		return resultList;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int addChannelAppOperate(ChannelAppOperate record) {
		record.setPropId(0);
		return channelAppOperateMapper.insertSelective(record);
	}

	@Override
	public int deleteChannelAppOperateByIds(List<Integer> idList,
			Integer channelAppId) {
		ChannelAppOperateExample example = new ChannelAppOperateExample();
		example.createCriteria().andOperateIdIn(idList)
				.andChannelAppIdEqualTo(channelAppId);
		return channelAppOperateMapper.deleteByExample(example);
	}

	/****
	 * 根据渠道包id查询此渠道包配置的指令id
	 * 
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	@Cacheable(value = "selectChannelAppOperateIds", key = "'selectChannelAppOperateIds_'+#channelAppId")
	public Set<Integer> selectChannelAppOperateIds(Integer channelAppId) {
		ChannelAppOperateExample example = new ChannelAppOperateExample();
		example.createCriteria().andChannelAppIdEqualTo(channelAppId);
		List<ChannelAppOperate> list = channelAppOperateMapper
				.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return new HashSet<Integer>(0);
		}
		Set<Integer> idsSet = new HashSet<Integer>(list.size());
		for (ChannelAppOperate cao : list) {
			idsSet.add(cao.getOperateId());
		}
		return idsSet;
	}

}
