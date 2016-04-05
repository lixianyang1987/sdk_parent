package com.hytx.dao.sync.ori;

import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.CpOrderSyncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpOrderSyncMapper {
    int countByExample(CpOrderSyncExample example);

    int deleteByExample(CpOrderSyncExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CpOrderSync record);

    int insertSelective(CpOrderSync record);

    List<CpOrderSync> selectByExample(CpOrderSyncExample example);

    CpOrderSync selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CpOrderSync record, @Param("example") CpOrderSyncExample example);

    int updateByExample(@Param("record") CpOrderSync record, @Param("example") CpOrderSyncExample example);

    int updateByPrimaryKeySelective(CpOrderSync record);

    int updateByPrimaryKey(CpOrderSync record);
}