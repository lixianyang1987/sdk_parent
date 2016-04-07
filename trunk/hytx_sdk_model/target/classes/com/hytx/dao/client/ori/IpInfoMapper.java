package com.hytx.dao.client.ori;

import com.hytx.model.client.IpInfo;
import com.hytx.model.client.IpInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpInfoMapper {
    int countByExample(IpInfoExample example);

    int deleteByExample(IpInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IpInfo record);

    int insertSelective(IpInfo record);

    List<IpInfo> selectByExample(IpInfoExample example);

    IpInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IpInfo record, @Param("example") IpInfoExample example);

    int updateByExample(@Param("record") IpInfo record, @Param("example") IpInfoExample example);

    int updateByPrimaryKeySelective(IpInfo record);

    int updateByPrimaryKey(IpInfo record);
}