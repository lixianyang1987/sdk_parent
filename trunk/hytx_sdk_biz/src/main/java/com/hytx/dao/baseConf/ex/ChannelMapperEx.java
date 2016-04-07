package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.Channel;
import com.hytx.util.Page;

public interface ChannelMapperEx {

	public List<Channel> selectChannelListByPage(
			@Param("findChannel") Channel findChannel,
			@Param("page") Page<Channel> page);

	public int countChannel(@Param("findChannel") Channel findChannel);

	public List<Channel> selectByCpId(@Param("cpId") Integer cpId);
	
	public List<Channel> selectByAppId(@Param("appId") Integer appId);
}