package com.hytx.dao.system.ori;

import com.hytx.model.system.RoleMenuAuth;
import com.hytx.model.system.RoleMenuAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuAuthMapper {
    int countByExample(RoleMenuAuthExample example);

    int deleteByExample(RoleMenuAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuAuth record);

    int insertSelective(RoleMenuAuth record);

    List<RoleMenuAuth> selectByExample(RoleMenuAuthExample example);

    RoleMenuAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenuAuth record, @Param("example") RoleMenuAuthExample example);

    int updateByExample(@Param("record") RoleMenuAuth record, @Param("example") RoleMenuAuthExample example);

    int updateByPrimaryKeySelective(RoleMenuAuth record);

    int updateByPrimaryKey(RoleMenuAuth record);
}