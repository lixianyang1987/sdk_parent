package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncYpplDx;
import com.hytx.model.sync.SyncYpplDxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncYpplDxMapper {
    int countByExample(SyncYpplDxExample example);

    int deleteByExample(SyncYpplDxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncYpplDx record);

    int insertSelective(SyncYpplDx record);

    List<SyncYpplDx> selectByExample(SyncYpplDxExample example);

    SyncYpplDx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncYpplDx record, @Param("example") SyncYpplDxExample example);

    int updateByExample(@Param("record") SyncYpplDx record, @Param("example") SyncYpplDxExample example);

    int updateByPrimaryKeySelective(SyncYpplDx record);

    int updateByPrimaryKey(SyncYpplDx record);
}