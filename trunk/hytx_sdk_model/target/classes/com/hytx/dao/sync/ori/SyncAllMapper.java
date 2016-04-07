package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncAll;
import com.hytx.model.sync.SyncAllExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncAllMapper {
    int countByExample(SyncAllExample example);

    int deleteByExample(SyncAllExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(SyncAll record);

    int insertSelective(SyncAll record);

    List<SyncAll> selectByExample(SyncAllExample example);

    SyncAll selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") SyncAll record, @Param("example") SyncAllExample example);

    int updateByExample(@Param("record") SyncAll record, @Param("example") SyncAllExample example);

    int updateByPrimaryKeySelective(SyncAll record);

    int updateByPrimaryKey(SyncAll record);
}