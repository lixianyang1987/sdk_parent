package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncQhd;
import com.hytx.model.sync.SyncQhdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncQhdMapper {
    int countByExample(SyncQhdExample example);

    int deleteByExample(SyncQhdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncQhd record);

    int insertSelective(SyncQhd record);

    List<SyncQhd> selectByExample(SyncQhdExample example);

    SyncQhd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncQhd record, @Param("example") SyncQhdExample example);

    int updateByExample(@Param("record") SyncQhd record, @Param("example") SyncQhdExample example);

    int updateByPrimaryKeySelective(SyncQhd record);

    int updateByPrimaryKey(SyncQhd record);
}