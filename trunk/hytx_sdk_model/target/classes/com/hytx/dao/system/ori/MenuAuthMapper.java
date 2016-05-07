package com.hytx.dao.system.ori;

import com.hytx.model.system.MenuAuth;
import com.hytx.model.system.MenuAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuAuthMapper {
    int countByExample(MenuAuthExample example);

    int deleteByExample(MenuAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuAuth record);

    int insertSelective(MenuAuth record);

    List<MenuAuth> selectByExample(MenuAuthExample example);

    MenuAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuAuth record, @Param("example") MenuAuthExample example);

    int updateByExample(@Param("record") MenuAuth record, @Param("example") MenuAuthExample example);

    int updateByPrimaryKeySelective(MenuAuth record);

    int updateByPrimaryKey(MenuAuth record);
}