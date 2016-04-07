package com.hytx.dao.sync.ori;

import com.hytx.model.sync.MobileSync;
import com.hytx.model.sync.MobileSyncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MobileSyncMapper {
    int countByExample(MobileSyncExample example);

    int deleteByExample(MobileSyncExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MobileSync record);

    int insertSelective(MobileSync record);

    List<MobileSync> selectByExample(MobileSyncExample example);

    MobileSync selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MobileSync record, @Param("example") MobileSyncExample example);

    int updateByExample(@Param("record") MobileSync record, @Param("example") MobileSyncExample example);

    int updateByPrimaryKeySelective(MobileSync record);

    int updateByPrimaryKey(MobileSync record);
}