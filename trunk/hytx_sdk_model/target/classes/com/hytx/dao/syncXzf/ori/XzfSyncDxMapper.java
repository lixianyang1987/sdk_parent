package com.hytx.dao.syncXzf.ori;

import com.hytx.model.syncXzf.XzfSyncDx;
import com.hytx.model.syncXzf.XzfSyncDxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfSyncDxMapper {
    int countByExample(XzfSyncDxExample example);

    int deleteByExample(XzfSyncDxExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(XzfSyncDx record);

    int insertSelective(XzfSyncDx record);

    List<XzfSyncDx> selectByExample(XzfSyncDxExample example);

    XzfSyncDx selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") XzfSyncDx record, @Param("example") XzfSyncDxExample example);

    int updateByExample(@Param("record") XzfSyncDx record, @Param("example") XzfSyncDxExample example);

    int updateByPrimaryKeySelective(XzfSyncDx record);

    int updateByPrimaryKey(XzfSyncDx record);
}