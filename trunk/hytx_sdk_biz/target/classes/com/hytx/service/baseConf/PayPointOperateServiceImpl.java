package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.baseConf.ex.PayPointOperateMapperEx;
import com.hytx.dao.baseConf.ori.PayPointOperateMapper;
import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.PayPointOperate;
import com.hytx.model.baseConf.PayPointOperateExample;

@Service("payPointOperateServiceImpl")
public class PayPointOperateServiceImpl implements IPayPointOperateService {
	@Autowired
	private PayPointOperateMapper payPointOperateMapper;
	@Autowired
	private PayPointOperateMapperEx payPointOperateMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<OperateDto> selectPayPointOperates(
			PayPointOperate payPointOperate) {
		return payPointOperateMapperEx
				.selectPayPointOperateList(payPointOperate);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertPayPointOperate(PayPointOperate record) {
		return payPointOperateMapper.insert(record);
	}

	@Override
	public int deletePayPointOperateByIds(List<Integer> idList,
			Integer payPointId) {
		PayPointOperateExample example = new PayPointOperateExample();
		example.createCriteria().andIdIn(idList);
		return payPointOperateMapper.deleteByExample(example);
	}

}
