package com.hytx.service.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.system.ex.UserMapperEx;
import com.hytx.dao.system.ori.UserMapper;
import com.hytx.dao.system.ori.UserRoleMapper;
import com.hytx.model.system.User;
import com.hytx.model.system.UserExample;
import com.hytx.model.system.UserRole;
import com.hytx.model.system.UserRoleExample;
import com.hytx.util.MD5;
import com.hytx.util.Page;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userDao;
	@Autowired
	private UserMapperEx userDaoEx;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Transactional(readOnly = true)
	public List<User> selectUserListByPage(User findUser, Page<User> page) {
		List<User> list = userDaoEx.selectUserListByPage(findUser, page);
		page.setTotalCount(userDaoEx.countUser(findUser));
		page.setResultList(list);
		return list;
	}

	@Transactional(readOnly = true)
	public User selectUserById(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertUser(User user) {
		return userDao.insert(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(User user) {
		User userPerm = userDao.selectByPrimaryKey(user.getId());
		if (userPerm == null) {
			return 0;
		}
		userPerm.setUpdateBy(user.getUpdateBy());
		userPerm.setUpdateDt(new Date());
		userPerm.setLoginName(user.getLoginName());
		userPerm.setUserName(user.getUserName());
		userPerm.setMemo(user.getMemo());
		userPerm.setLinkEmail(user.getLinkEmail());
		userPerm.setLinkMan(user.getLinkMan());
		userPerm.setLinkMobile(user.getLinkMobile());
		userPerm.setLinkQq(user.getLinkQq());
		return userDao.updateByPrimaryKey(userPerm);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int delUserByIds(List ids) {
		UserExample example = new UserExample();
		example.createCriteria().andIdIn(ids);
		User record = new User();
		record.setStatus(-1);
		userDao.updateByExampleSelective(record, example);
		return 0;
	}

	@Transactional(readOnly = true)
	public List<User> selectByUserName(String userName) {
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<User> list = userDao.selectByExample(example);
		return list;
	}

	@Transactional(readOnly = true)
	public List<User> selectByLoginName(String loginName) {
		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<User> list = userDao.selectByExample(example);
		return list;
	}

	public User selectByLoginNameAndPassword(String loginName, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName)
				.andLoginPwdEqualTo(password)
				.andStatusEqualTo(EnumStatus.ok.getValue());
		List<User> userList = userDao.selectByExample(example);
		if (userList == null || userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int modifyUserPwd(User user) {
		User userPerm = userDao.selectByPrimaryKey(user.getId());
		if (userPerm == null) {
			return 0;
		}
		userPerm.setLoginPwd(MD5.getMD5(user.getLoginPwd()));
		return userDao.updateByPrimaryKey(userPerm);
	}

	public List<User> selectUserListByType(Integer userType) {
		UserExample example = new UserExample();
		example.createCriteria().andUserTypeEqualTo(userType)
				.andStatusEqualTo(EnumStatus.ok.getValue());
		example.setOrderByClause(" id desc");
		return userDao.selectByExample(example);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUserRoles(Integer userId, List<Integer> roleIds, User user) {
		if (userId == null || roleIds == null) {
			return 0;
		}
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		userRoleMapper.deleteByExample(example);
		for (Integer rid : roleIds) {
			UserRole userRole = new UserRole();
			userRole.setRoleId(rid);
			userRole.setUserId(userId);
			userRole.setCreateBy(user.getUserName());
			userRole.setCreateDt(new Date());
			userRoleMapper.insert(userRole);
		}
		return roleIds.size();
	}
}
