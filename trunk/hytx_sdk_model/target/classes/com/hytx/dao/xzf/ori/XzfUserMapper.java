package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfUserMapper {
    int countByExample(XzfUserExample example);

    int deleteByExample(XzfUserExample example);

    int deleteByPrimaryKey(String imei);

    int insert(XzfUser record);

    int insertSelective(XzfUser record);

    List<XzfUser> selectByExample(XzfUserExample example);

    XzfUser selectByPrimaryKey(String imei);

    int updateByExampleSelective(@Param("record") XzfUser record, @Param("example") XzfUserExample example);

    int updateByExample(@Param("record") XzfUser record, @Param("example") XzfUserExample example);

    int updateByPrimaryKeySelective(XzfUser record);

    int updateByPrimaryKey(XzfUser record);
}