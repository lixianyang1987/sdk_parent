package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.ReqSmsLogMapperEx;
import com.hytx.dto.client.ReqSmsCommandDto;
import com.hytx.dto.client.ReqSmsLogDto;
import com.hytx.util.Page;

@Service("reqSmsCountServiceImpl")
public class ReqSmsCountServiceImpl implements IReqSmsCountService {
	@Autowired
	private ReqSmsLogMapperEx reqSmsLogMapperEx;

	@Override
	public List<ReqSmsLogDto> selectReqSmssByPage(ReqSmsLogDto findReqSms,
			Page<ReqSmsLogDto> page) {
		List<ReqSmsLogDto> resultList = reqSmsLogMapperEx
				.selectReqSmsListByPage(findReqSms, page);
		page.setResultList(resultList);
		page.setTotalCount(reqSmsLogMapperEx.countReqSms(findReqSms));
		return resultList;
	}

	public List<ReqSmsCommandDto> findReqSmsCommands(String orderId) {
		return reqSmsLogMapperEx.findReqSmsCommands(orderId);
	}
}
