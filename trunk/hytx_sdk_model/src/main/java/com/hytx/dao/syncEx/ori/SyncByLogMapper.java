package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncByLogMapper {
    int countByExample(SyncByLogExample example);

    int deleteByExample(SyncByLogExample example);

    int insert(SyncByLog record);

    int insertSelective(SyncByLog record);

    List<SyncByLog> selectByExample(SyncByLogExample example);

    int updateByExampleSelective(@Param("record") SyncByLog record, @Param("example") SyncByLogExample example);

    int updateByExample(@Param("record") SyncByLog record, @Param("example") SyncByLogExample example);
}