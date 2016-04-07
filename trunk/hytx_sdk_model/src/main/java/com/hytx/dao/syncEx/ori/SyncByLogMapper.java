package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import com.hytx.model.syncEx.SyncByLogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncByLogMapper {
    int countByExample(SyncByLogExample example);

    int deleteByExample(SyncByLogExample example);

    int deleteByPrimaryKey(SyncByLogKey key);

    int insert(SyncByLog record);

    int insertSelective(SyncByLog record);

    List<SyncByLog> selectByExample(SyncByLogExample example);

    SyncByLog selectByPrimaryKey(SyncByLogKey key);

    int updateByExampleSelective(@Param("record") SyncByLog record, @Param("example") SyncByLogExample example);

    int updateByExample(@Param("record") SyncByLog record, @Param("example") SyncByLogExample example);

    int updateByPrimaryKeySelective(SyncByLog record);

    int updateByPrimaryKey(SyncByLog record);
}