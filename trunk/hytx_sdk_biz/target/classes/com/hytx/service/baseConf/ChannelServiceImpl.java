package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.ChannelMapperEx;
import com.hytx.dao.baseConf.ori.ChannelMapper;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.ChannelExample;
import com.hytx.util.Page;

@Service("channelServiceImpl")
public class ChannelServiceImpl implements IChannelService {
	@Autowired
	private ChannelMapper channelMapper;
	@Autowired
	private ChannelMapperEx channelMapperEx;
	@Autowired
	private IChannelAppService channelAppService;

	@Override
	@Transactional(readOnly = true)
	public List<Channel> selectChannelsByPage(Channel findChannel,
			Page<Channel> page) {
		List<Channel> resultList = channelMapperEx.selectChannelListByPage(
				findChannel, page);
		page.setResultList(resultList);
		page.setTotalCount(channelMapperEx.countChannel(findChannel));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Channel channel) {
		return channelMapper.insert(channel);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(Channel channel) {
		if (channel.getChannelName() == null) {
			channel.setChannelName("");
		}
		return channelMapper.updateByPrimaryKeySelective(channel);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteChannelByIds(List<Integer> idList) {
		ChannelExample example = new ChannelExample();
		example.createCriteria().andIdIn(idList);
		int rows = channelMapper.deleteByExample(example);
		channelAppService.deleteChannelAppByChannelIds(idList);
		return rows;
	}

	@Override
	public Channel selectByPrimaryKey(Integer id) {
		return channelMapper.selectByPrimaryKey(id);
	}

	public List<Channel> selectAllActiveChannel() {
		ChannelExample example = new ChannelExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return channelMapper.selectByExample(example);
	}

	public List<Channel> selectByCpId(Integer cpId) {
		return channelMapperEx.selectByCpId(cpId);
	}
	public List<Channel> selectByAppId(Integer appId) {
		return channelMapperEx.selectByAppId(appId);
	}
}
