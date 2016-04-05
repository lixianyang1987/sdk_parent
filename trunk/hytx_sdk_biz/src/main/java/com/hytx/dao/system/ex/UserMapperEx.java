package com.hytx.dao.system.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.system.User;
import com.hytx.util.Page;

public interface UserMapperEx {
	
	public List<User>selectUserListByPage(@Param("findUser")User findUser,@Param("page")Page<User>page);
	
	public int countUser(@Param("findUser")User findUser);
}