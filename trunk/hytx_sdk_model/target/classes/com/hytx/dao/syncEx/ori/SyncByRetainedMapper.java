package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.model.syncEx.SyncByRetainedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncByRetainedMapper {
    int countByExample(SyncByRetainedExample example);

    int deleteByExample(SyncByRetainedExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(SyncByRetained record);

    int insertSelective(SyncByRetained record);

    List<SyncByRetained> selectByExample(SyncByRetainedExample example);

    SyncByRetained selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") SyncByRetained record, @Param("example") SyncByRetainedExample example);

    int updateByExample(@Param("record") SyncByRetained record, @Param("example") SyncByRetainedExample example);

    int updateByPrimaryKeySelective(SyncByRetained record);

    int updateByPrimaryKey(SyncByRetained record);
}