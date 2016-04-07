package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncWydF;
import com.hytx.model.sync.SyncWydFExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncWydFMapper {
    int countByExample(SyncWydFExample example);

    int deleteByExample(SyncWydFExample example);

    int insert(SyncWydF record);

    int insertSelective(SyncWydF record);

    List<SyncWydF> selectByExample(SyncWydFExample example);

    int updateByExampleSelective(@Param("record") SyncWydF record, @Param("example") SyncWydFExample example);

    int updateByExample(@Param("record") SyncWydF record, @Param("example") SyncWydFExample example);
}