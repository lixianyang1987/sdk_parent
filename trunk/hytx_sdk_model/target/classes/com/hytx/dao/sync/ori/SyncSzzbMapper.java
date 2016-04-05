package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncSzzb;
import com.hytx.model.sync.SyncSzzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncSzzbMapper {
    int countByExample(SyncSzzbExample example);

    int deleteByExample(SyncSzzbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncSzzb record);

    int insertSelective(SyncSzzb record);

    List<SyncSzzb> selectByExample(SyncSzzbExample example);

    SyncSzzb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncSzzb record, @Param("example") SyncSzzbExample example);

    int updateByExample(@Param("record") SyncSzzb record, @Param("example") SyncSzzbExample example);

    int updateByPrimaryKeySelective(SyncSzzb record);

    int updateByPrimaryKey(SyncSzzb record);
}