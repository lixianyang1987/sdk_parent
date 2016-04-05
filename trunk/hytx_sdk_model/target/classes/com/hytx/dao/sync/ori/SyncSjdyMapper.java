package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncSjdy;
import com.hytx.model.sync.SyncSjdyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncSjdyMapper {
    int countByExample(SyncSjdyExample example);

    int deleteByExample(SyncSjdyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncSjdy record);

    int insertSelective(SyncSjdy record);

    List<SyncSjdy> selectByExample(SyncSjdyExample example);

    SyncSjdy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncSjdy record, @Param("example") SyncSjdyExample example);

    int updateByExample(@Param("record") SyncSjdy record, @Param("example") SyncSjdyExample example);

    int updateByPrimaryKeySelective(SyncSjdy record);

    int updateByPrimaryKey(SyncSjdy record);
}