package com.hytx.dao.list.ori;

import com.hytx.model.list.UserFilterList;
import com.hytx.model.list.UserFilterListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFilterListMapper {
    int countByExample(UserFilterListExample example);

    int deleteByExample(UserFilterListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFilterList record);

    int insertSelective(UserFilterList record);

    List<UserFilterList> selectByExample(UserFilterListExample example);

    UserFilterList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFilterList record, @Param("example") UserFilterListExample example);

    int updateByExample(@Param("record") UserFilterList record, @Param("example") UserFilterListExample example);

    int updateByPrimaryKeySelective(UserFilterList record);

    int updateByPrimaryKey(UserFilterList record);
}