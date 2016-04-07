package com.hytx.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.system.ex.AuthMapperEx;
import com.hytx.dao.system.ori.AuthMapper;
import com.hytx.dao.system.ori.MenuAuthMapper;
import com.hytx.dao.system.ori.RoleMenuAuthMapper;
import com.hytx.model.system.Auth;
import com.hytx.model.system.AuthExample;
import com.hytx.model.system.MenuAuth;
import com.hytx.model.system.MenuAuthExample;
import com.hytx.model.system.RoleMenuAuthExample;
import com.hytx.util.Page;

@Service("authServiceImpl")
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private AuthMapper authMapper;
	@Autowired
	private AuthMapperEx authMapperEx;
	@Autowired
	private MenuAuthMapper menuAuthMapper;
	@Autowired
	private RoleMenuAuthMapper roleMenuAuthMapper;

	@Override
	@Transactional(readOnly = true)
	public List<Auth> selectAuthsByPage(Auth findAuth, Page<Auth> page) {
		List<Auth> resultList = authMapperEx.selectAuthListByPage(findAuth,
				page);
		page.setResultList(resultList);
		page.setTotalCount(authMapperEx.countAuth(findAuth));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Auth auth) {
		return authMapper.insert(auth);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(Auth auth) {
		if (auth.getAuthName() == null) {
			auth.setAuthName("");
		}
		return authMapper.updateByPrimaryKeySelective(auth);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteAuthByIds(List<Integer> idList) {
		AuthExample example = new AuthExample();
		example.createCriteria().andIdIn(idList);
		int rows = authMapper.deleteByExample(example);
		MenuAuthExample menuAuthExample = new MenuAuthExample();
		menuAuthExample.createCriteria().andAuthIdIn(idList);
		List<MenuAuth> maList = menuAuthMapper.selectByExample(menuAuthExample);
		if (maList == null || maList.isEmpty()) {
			return rows;
		}
		// 删除设置的菜单权限
		menuAuthMapper.deleteByExample(menuAuthExample);
		List<Integer> maIds = new ArrayList<Integer>();
		for (MenuAuth ma : maList) {
			maIds.add(ma.getId());
		}
		// 删除设置的角色菜单权限
		RoleMenuAuthExample rmaExample = new RoleMenuAuthExample();
		rmaExample.createCriteria().andMenuAuthIdIn(maIds);
		roleMenuAuthMapper.deleteByExample(rmaExample);
		return rows;
	}

	@Override
	public Auth selectByPrimaryKey(Integer id) {
		return authMapper.selectByPrimaryKey(id);
	}

	public List<Auth> selectAllActiveAuth() {
		AuthExample example = new AuthExample();
		return authMapper.selectByExample(example);
	}
}
