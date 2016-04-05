package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.MessageMapperEx;
import com.hytx.dto.count.DayLimitDto;

@Service("messageServiceImpl")
public class MessageServiceImpl implements IMessageService {
	@Autowired
	private MessageMapperEx messageMapperEx;

	@Override
	public List<DayLimitDto> selectChannelAppMessage() {
		return messageMapperEx.selectChannelAppMessage();
	}

	@Override
	public List<DayLimitDto> selectAppMessage() {
		return messageMapperEx.selectAppMessage();
	}

}
