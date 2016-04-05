package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.model.syncEx.SyncTyAllKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncTyAllMapper {
    int countByExample(SyncTyAllExample example);

    int deleteByExample(SyncTyAllExample example);

    int deleteByPrimaryKey(SyncTyAllKey key);

    int insert(SyncTyAll record);

    int insertSelective(SyncTyAll record);

    List<SyncTyAll> selectByExample(SyncTyAllExample example);

    SyncTyAll selectByPrimaryKey(SyncTyAllKey key);

    int updateByExampleSelective(@Param("record") SyncTyAll record, @Param("example") SyncTyAllExample example);

    int updateByExample(@Param("record") SyncTyAll record, @Param("example") SyncTyAllExample example);

    int updateByPrimaryKeySelective(SyncTyAll record);

    int updateByPrimaryKey(SyncTyAll record);
}