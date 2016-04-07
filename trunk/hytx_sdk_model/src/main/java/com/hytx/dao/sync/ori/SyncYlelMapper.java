package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncYlel;
import com.hytx.model.sync.SyncYlelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncYlelMapper {
    int countByExample(SyncYlelExample example);

    int deleteByExample(SyncYlelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncYlel record);

    int insertSelective(SyncYlel record);

    List<SyncYlel> selectByExample(SyncYlelExample example);

    SyncYlel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncYlel record, @Param("example") SyncYlelExample example);

    int updateByExample(@Param("record") SyncYlel record, @Param("example") SyncYlelExample example);

    int updateByPrimaryKeySelective(SyncYlel record);

    int updateByPrimaryKey(SyncYlel record);
}