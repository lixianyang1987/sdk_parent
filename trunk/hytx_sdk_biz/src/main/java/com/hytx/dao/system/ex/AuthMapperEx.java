package com.hytx.dao.system.ex;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.system.Auth;
import com.hytx.util.Page;

public interface AuthMapperEx {

	public List<Auth>selectAuthListByPage(@Param("findAuth")Auth findAuth,@Param("page")Page<Auth>page);

	public int countAuth(@Param("findAuth")Auth findAuth);
}