package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfHuafeiBill;
import com.hytx.model.xzf.XzfHuafeiBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfHuafeiBillMapper {
    int countByExample(XzfHuafeiBillExample example);

    int deleteByExample(XzfHuafeiBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(XzfHuafeiBill record);

    int insertSelective(XzfHuafeiBill record);

    List<XzfHuafeiBill> selectByExample(XzfHuafeiBillExample example);

    XzfHuafeiBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") XzfHuafeiBill record, @Param("example") XzfHuafeiBillExample example);

    int updateByExample(@Param("record") XzfHuafeiBill record, @Param("example") XzfHuafeiBillExample example);

    int updateByPrimaryKeySelective(XzfHuafeiBill record);

    int updateByPrimaryKey(XzfHuafeiBill record);
}