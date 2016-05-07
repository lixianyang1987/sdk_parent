package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncYppl;
import com.hytx.model.sync.SyncYpplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncYpplMapper {
    int countByExample(SyncYpplExample example);

    int deleteByExample(SyncYpplExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncYppl record);

    int insertSelective(SyncYppl record);

    List<SyncYppl> selectByExample(SyncYpplExample example);

    SyncYppl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncYppl record, @Param("example") SyncYpplExample example);

    int updateByExample(@Param("record") SyncYppl record, @Param("example") SyncYpplExample example);

    int updateByPrimaryKeySelective(SyncYppl record);

    int updateByPrimaryKey(SyncYppl record);
}