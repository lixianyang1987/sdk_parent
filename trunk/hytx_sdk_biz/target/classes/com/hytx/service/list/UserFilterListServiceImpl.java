package com.hytx.service.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.list.ex.UserFilterListMapperEx;
import com.hytx.dao.list.ori.UserFilterListMapper;
import com.hytx.model.list.UserFilterList;
import com.hytx.model.list.UserFilterListExample;
import com.hytx.util.Page;

@Service("userFilterListServiceImpl")
public class UserFilterListServiceImpl implements IUserFilterListService {
	@Autowired
	private UserFilterListMapper userFilterListMapper;
	@Autowired
	private UserFilterListMapperEx userFilterListMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<UserFilterList> selectUserFilterListsByPage(
			UserFilterList findUserFilterList, Page<UserFilterList> page) {
		List<UserFilterList> resultList = userFilterListMapperEx
				.selectUserFilterListListByPage(findUserFilterList, page);
		page.setResultList(resultList);
		page.setTotalCount(userFilterListMapperEx
				.countUserFilterList(findUserFilterList));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(UserFilterList userFilterList) {
		return userFilterListMapper.insert(userFilterList);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(UserFilterList userFilterList) {
		if (userFilterList.getImsi() == null) {
			userFilterList.setImsi("");
		}
		return userFilterListMapper.updateByPrimaryKeySelective(userFilterList);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUserFilterListByIds(List<Integer> idList) {
		UserFilterListExample example = new UserFilterListExample();
		example.createCriteria().andIdIn(idList);
		return userFilterListMapper.deleteByExample(example);
	}

	@Override
	public UserFilterList selectByPrimaryKey(Integer id) {
		return userFilterListMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "selectAllUserFilterList", key = "selectAllUserFilterList")
	public Map<String, UserFilterList> selectAllUserFilterList() {
		Map<String, UserFilterList> map = new HashMap<String, UserFilterList>();
		UserFilterListExample example = new UserFilterListExample();
		example.setOrderByClause(" id asc");
		List<UserFilterList> list = userFilterListMapper
				.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (UserFilterList ufl : list) {
				map.put(ufl.getImsi(), ufl);
			}
		}
		return map;
	}

	public Integer checkUserFilterType(String imsi) {
		Map<String, UserFilterList> map = selectAllUserFilterList();
		UserFilterList ufl = map.get(imsi);
		if (ufl != null) {
			return ufl.getListType();
		}
		return null;
	}

}
