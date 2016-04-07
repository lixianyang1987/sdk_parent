package com.hytx.dao.system.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.system.Menu;
import com.hytx.model.system.User;
import com.hytx.util.Page;

public interface MenuMapperEx {

	public List<Menu> selectMenuListByPage(@Param("findMenu") Menu findMenu,
			@Param("page") Page<Menu> page);

	public int countMenu(@Param("findMenu") Menu findMenu);

	public int insertReturnId(Menu menu);

	public int deleteChildMenus(@Param("id") String id);

	public int selectMenuId();
	
	public List<Menu>selectUserChildrenMenus(@Param("pid")Integer pid,@Param("user")User user);
}