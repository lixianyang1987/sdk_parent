package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncSzxty;
import com.hytx.model.sync.SyncSzxtyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncSzxtyMapper {
    int countByExample(SyncSzxtyExample example);

    int deleteByExample(SyncSzxtyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SyncSzxty record);

    int insertSelective(SyncSzxty record);

    List<SyncSzxty> selectByExample(SyncSzxtyExample example);

    SyncSzxty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SyncSzxty record, @Param("example") SyncSzxtyExample example);

    int updateByExample(@Param("record") SyncSzxty record, @Param("example") SyncSzxtyExample example);

    int updateByPrimaryKeySelective(SyncSzxty record);

    int updateByPrimaryKey(SyncSzxty record);
}