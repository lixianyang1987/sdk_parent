package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.DictMapperEx;
import com.hytx.dao.baseConf.ori.DictMapper;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.baseConf.DictExample;
import com.hytx.util.Page;

@Service("dictServiceImpl")
public class DictServiceImpl implements IDictService {
	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private DictMapperEx dictMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<Dict> selectDictsByPage(Dict findDict, Page<Dict> page) {
		List<Dict> resultList = dictMapperEx.selectDictListByPage(findDict,
				page);
		page.setResultList(resultList);
		page.setTotalCount(dictMapperEx.countDict(findDict));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Dict dict) {
		return dictMapper.insert(dict);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(Dict dict) {
		return dictMapper.updateByPrimaryKeySelective(dict);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteDictByIds(List<Integer> idList) {
		DictExample example = new DictExample();
		example.createCriteria().andIdIn(idList);
		return dictMapper.deleteByExample(example);
	}

	@Override
	public Dict selectByPrimaryKey(Integer id) {
		return dictMapper.selectByPrimaryKey(id);
	}

	public List<Dict> selectAllActiveDict() {
		DictExample example = new DictExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return dictMapper.selectByExample(example);
	}

	public Dict selectDictByKey(String key) {
		DictExample example = new DictExample();
		example.createCriteria().andKeyEqualTo(key);
		List<Dict> list = dictMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Cacheable(value = "selectActiviteDictByKey", key = "'selectActiviteDictByKey_'+#key")
	public Dict selectActiviteDictByKey(String key) {
		DictExample example = new DictExample();
		example.createCriteria().andKeyEqualTo(key)
				.andStatusEqualTo(BaseContance.ACTIVICE_STATUS);
		List<Dict> list = dictMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean isInXzfWhiteList(String mobile) {
		Dict dict = selectActiviteDictByKey("xzf_white_list");
		if (dict == null) {
			return false;
		}
		String content = dict.getVal();
		if (content == null || content.trim().length() == 0) {
			return false;
		}
		return content.indexOf(mobile) > -1;
	}

}
