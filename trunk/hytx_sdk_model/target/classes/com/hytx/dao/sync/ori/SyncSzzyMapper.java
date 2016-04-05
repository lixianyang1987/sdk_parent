package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncSzzy;
import com.hytx.model.sync.SyncSzzyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncSzzyMapper {
    int countByExample(SyncSzzyExample example);

    int deleteByExample(SyncSzzyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SyncSzzy record);

    int insertSelective(SyncSzzy record);

    List<SyncSzzy> selectByExample(SyncSzzyExample example);

    SyncSzzy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SyncSzzy record, @Param("example") SyncSzzyExample example);

    int updateByExample(@Param("record") SyncSzzy record, @Param("example") SyncSzzyExample example);

    int updateByPrimaryKeySelective(SyncSzzy record);

    int updateByPrimaryKey(SyncSzzy record);
}