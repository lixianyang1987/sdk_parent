package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncHddx;
import com.hytx.model.sync.SyncHddxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncHddxMapper {
    int countByExample(SyncHddxExample example);

    int deleteByExample(SyncHddxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncHddx record);

    int insertSelective(SyncHddx record);

    List<SyncHddx> selectByExample(SyncHddxExample example);

    SyncHddx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncHddx record, @Param("example") SyncHddxExample example);

    int updateByExample(@Param("record") SyncHddx record, @Param("example") SyncHddxExample example);

    int updateByPrimaryKeySelective(SyncHddx record);

    int updateByPrimaryKey(SyncHddx record);
}