package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncQsxx;
import com.hytx.model.sync.SyncQsxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncQsxxMapper {
    int countByExample(SyncQsxxExample example);

    int deleteByExample(SyncQsxxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncQsxx record);

    int insertSelective(SyncQsxx record);

    List<SyncQsxx> selectByExample(SyncQsxxExample example);

    SyncQsxx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncQsxx record, @Param("example") SyncQsxxExample example);

    int updateByExample(@Param("record") SyncQsxx record, @Param("example") SyncQsxxExample example);

    int updateByPrimaryKeySelective(SyncQsxx record);

    int updateByPrimaryKey(SyncQsxx record);
}