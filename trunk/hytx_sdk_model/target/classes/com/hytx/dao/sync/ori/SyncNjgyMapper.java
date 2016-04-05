package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncNjgy;
import com.hytx.model.sync.SyncNjgyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncNjgyMapper {
    int countByExample(SyncNjgyExample example);

    int deleteByExample(SyncNjgyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncNjgy record);

    int insertSelective(SyncNjgy record);

    List<SyncNjgy> selectByExample(SyncNjgyExample example);

    SyncNjgy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncNjgy record, @Param("example") SyncNjgyExample example);

    int updateByExample(@Param("record") SyncNjgy record, @Param("example") SyncNjgyExample example);

    int updateByPrimaryKeySelective(SyncNjgy record);

    int updateByPrimaryKey(SyncNjgy record);
}