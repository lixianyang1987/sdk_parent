package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncZjhy;
import com.hytx.model.sync.SyncZjhyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncZjhyMapper {
    int countByExample(SyncZjhyExample example);

    int deleteByExample(SyncZjhyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SyncZjhy record);

    int insertSelective(SyncZjhy record);

    List<SyncZjhy> selectByExample(SyncZjhyExample example);

    SyncZjhy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SyncZjhy record, @Param("example") SyncZjhyExample example);

    int updateByExample(@Param("record") SyncZjhy record, @Param("example") SyncZjhyExample example);

    int updateByPrimaryKeySelective(SyncZjhy record);

    int updateByPrimaryKey(SyncZjhy record);
}