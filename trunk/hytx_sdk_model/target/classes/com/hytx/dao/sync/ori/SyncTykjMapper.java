package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncTykj;
import com.hytx.model.sync.SyncTykjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncTykjMapper {
    int countByExample(SyncTykjExample example);

    int deleteByExample(SyncTykjExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncTykj record);

    int insertSelective(SyncTykj record);

    List<SyncTykj> selectByExample(SyncTykjExample example);

    SyncTykj selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncTykj record, @Param("example") SyncTykjExample example);

    int updateByExample(@Param("record") SyncTykj record, @Param("example") SyncTykjExample example);

    int updateByPrimaryKeySelective(SyncTykj record);

    int updateByPrimaryKey(SyncTykj record);
}