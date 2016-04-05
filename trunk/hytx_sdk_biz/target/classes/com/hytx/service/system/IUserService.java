package com.hytx.service.system;

import java.util.List;

import com.hytx.model.system.User;
import com.hytx.util.Page;

public interface IUserService {
	public List<User> selectUserListByPage(User findUser, Page<User> page);

	public User selectUserById(Integer id);

	public int insertUser(User user);

	public int updateByPrimaryKeySelective(User user);

	public int delUserByIds(List ids);

	public List<User> selectByUserName(String userName);

	public List<User> selectByLoginName(String loginName);

	public User selectByLoginNameAndPassword(String loginName, String password);

	public int modifyUserPwd(User user);

	public List<User> selectUserListByType(Integer userType);
	
	public int updateUserRoles(Integer userId,List<Integer> roleIds,User user);
}
