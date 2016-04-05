package com.hytx.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.system.ex.RoleMapperEx;
import com.hytx.dao.system.ori.RoleMapper;
import com.hytx.dto.system.UserRoleDto;
import com.hytx.model.system.Role;
import com.hytx.model.system.RoleExample;
import com.hytx.util.Page;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleMapperEx roleMapperEx;

	public int getTotalCount() {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIsNotNull()
				.andStatusEqualTo(EnumStatus.ok.getValue());
		return roleMapper.countByExample(example);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public int updateByPrimaryKeySelective(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public int updateByPrimaryKey(Role role) {
		return roleMapper.updateByPrimaryKey(role);
	}

	public Role selectByPrimaryKey(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	public List<Role> selectRolesByPage(Role findRole, Page<Role> page) {
		List<Role> roles = roleMapperEx.selectRoleListByPage(findRole, page);
		page.setTotalCount(roleMapperEx.countRole(findRole));
		page.setResultList(roles);
		return roles;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	synchronized public int insertSelective(Role role) {
		return roleMapper.insertSelective(role);
	}

	public List<UserRoleDto> selectUserRoleDtoList(Integer userId) {
		return roleMapperEx.selectUserRoleDtoList(userId);
	}

}
