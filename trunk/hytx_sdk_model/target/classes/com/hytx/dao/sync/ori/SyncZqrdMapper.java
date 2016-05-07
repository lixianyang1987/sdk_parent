package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncZqrd;
import com.hytx.model.sync.SyncZqrdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncZqrdMapper {
    int countByExample(SyncZqrdExample example);

    int deleteByExample(SyncZqrdExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(SyncZqrd record);

    int insertSelective(SyncZqrd record);

    List<SyncZqrd> selectByExample(SyncZqrdExample example);

    SyncZqrd selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") SyncZqrd record, @Param("example") SyncZqrdExample example);

    int updateByExample(@Param("record") SyncZqrd record, @Param("example") SyncZqrdExample example);

    int updateByPrimaryKeySelective(SyncZqrd record);

    int updateByPrimaryKey(SyncZqrd record);
}