package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncXl;
import com.hytx.model.syncEx.SyncXlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncXlMapper {
    int countByExample(SyncXlExample example);

    int deleteByExample(SyncXlExample example);

    int deleteByPrimaryKey(String pdorderid);

    int insert(SyncXl record);

    int insertSelective(SyncXl record);

    List<SyncXl> selectByExample(SyncXlExample example);

    SyncXl selectByPrimaryKey(String pdorderid);

    int updateByExampleSelective(@Param("record") SyncXl record, @Param("example") SyncXlExample example);

    int updateByExample(@Param("record") SyncXl record, @Param("example") SyncXlExample example);

    int updateByPrimaryKeySelective(SyncXl record);

    int updateByPrimaryKey(SyncXl record);
}