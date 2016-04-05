package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncYzf;
import com.hytx.model.syncEx.SyncYzfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncYzfMapper {
    int countByExample(SyncYzfExample example);

    int deleteByExample(SyncYzfExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(SyncYzf record);

    int insertSelective(SyncYzf record);

    List<SyncYzf> selectByExample(SyncYzfExample example);

    SyncYzf selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") SyncYzf record, @Param("example") SyncYzfExample example);

    int updateByExample(@Param("record") SyncYzf record, @Param("example") SyncYzfExample example);

    int updateByPrimaryKeySelective(SyncYzf record);

    int updateByPrimaryKey(SyncYzf record);
}