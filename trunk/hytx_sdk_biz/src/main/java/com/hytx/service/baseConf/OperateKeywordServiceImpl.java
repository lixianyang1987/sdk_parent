package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ori.OperateKeywordMapper;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.baseConf.OperateKeywordExample;

@Service("operateKeywordServiceImpl")
public class OperateKeywordServiceImpl implements IOperateKeywordService {
	@Autowired
	private OperateKeywordMapper operateKeywordMapper;

	public List<OperateKeyword> selectOperateKeywordList(Integer operateId) {
		OperateKeywordExample example = new OperateKeywordExample();
		example.createCriteria().andOperateIdEqualTo(operateId);
		return operateKeywordMapper.selectByExample(example);
	}

	public OperateKeyword selectByPrimaryKey(Integer id) {
		return operateKeywordMapper.selectByPrimaryKey(id);
	}

	public int insertOperateKeyword(OperateKeyword operateKeyword) {
		return operateKeywordMapper.insert(operateKeyword);
	}

	public int updateOperateKeyword(OperateKeyword operateKeyword) {
		return operateKeywordMapper.updateByPrimaryKey(operateKeyword);
	}

	public int deleteOperateKeywordByIds(List<Integer> idList) {
		OperateKeywordExample example = new OperateKeywordExample();
		example.createCriteria().andIdIn(idList);
		return operateKeywordMapper.deleteByExample(example);
	}

}
