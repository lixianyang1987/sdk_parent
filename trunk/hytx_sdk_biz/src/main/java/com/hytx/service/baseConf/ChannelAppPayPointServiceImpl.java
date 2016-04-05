package com.hytx.service.baseConf;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ex.ChannelAppPayPointMapperEx;
import com.hytx.dao.baseConf.ori.ChannelAppPayPointMapper;
import com.hytx.model.baseConf.ChannelAppPayPoint;
import com.hytx.model.baseConf.ChannelAppPayPointExample;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.util.Page;

@Service("channelAppPayPointServiceImpl")
public class ChannelAppPayPointServiceImpl implements
		IChannelAppPayPointService {

	@Autowired
	private ChannelAppPayPointMapper channelAppPayPointMapper;
	@Autowired
	private ChannelAppPayPointMapperEx channelAppPayPointMapperEx;

	@Override
	public List<PayPoint> selectPayPointesByPage(
			ChannelAppPayPoint channelAppPayPoint, Page<PayPoint> page) {
		// TODO Auto-generated method stub
		List<PayPoint> resultList = channelAppPayPointMapperEx
				.selectPayPointListByPage(channelAppPayPoint, page);
		page.setResultList(resultList);
		page.setTotalCount(channelAppPayPointMapperEx
				.countPayPoint(channelAppPayPoint));
		return resultList;
	}

	@Override
	public List<PayPoint> selectNotAddedPayPointesByPage(
			ChannelAppPayPoint channelAppPayPoint, Page<PayPoint> page) {
		// TODO Auto-generated method stub

		List<PayPoint> resultList = channelAppPayPointMapperEx
				.selectNotAddedPayPointList(channelAppPayPoint, page);
		page.setResultList(resultList);
		page.setTotalCount(channelAppPayPointMapperEx
				.countNotAddedPayPoint(channelAppPayPoint));
		return resultList;
	}

	@Override
	public int addChannelAppPayPoint(ChannelAppPayPoint channelAppPayPoint) {

		return channelAppPayPointMapper.insertSelective(channelAppPayPoint);
	}

	@Override
	public int deleteChannelAppPayPointByIds(List<Integer> idList,
			Integer channelAppId) {
		ChannelAppPayPointExample example = new ChannelAppPayPointExample();
		example.createCriteria().andPayPointIdIn(idList)
				.andChannelAppIdEqualTo(channelAppId);
		return channelAppPayPointMapper.deleteByExample(example);
	}

	/****
	 * 根据渠道包id查询此渠道包配置的计费点id
	 * 
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	@Cacheable(value = "selectChannelAppPayPointIds", key = "'selectChannelAppPayPointIds'+#channelAppId")
	public Set<Integer> selectChannelAppPayPointIds(Integer channelAppId) {
		ChannelAppPayPointExample example = new ChannelAppPayPointExample();
		example.createCriteria().andChannelAppIdEqualTo(channelAppId);
		List<ChannelAppPayPoint> list = channelAppPayPointMapper
				.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return new HashSet<Integer>(0);
		}
		Set<Integer> idsList = new HashSet<Integer>(list.size());
		for (ChannelAppPayPoint cap : list) {
			idsList.add(Integer.parseInt(cap.getPayPointId()));
		}
		return idsList;
	}

}
