package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfFlowLog;
import com.hytx.model.xzf.XzfFlowLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfFlowLogMapper {
    int countByExample(XzfFlowLogExample example);

    int deleteByExample(XzfFlowLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XzfFlowLog record);

    int insertSelective(XzfFlowLog record);

    List<XzfFlowLog> selectByExample(XzfFlowLogExample example);

    XzfFlowLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XzfFlowLog record, @Param("example") XzfFlowLogExample example);

    int updateByExample(@Param("record") XzfFlowLog record, @Param("example") XzfFlowLogExample example);

    int updateByPrimaryKeySelective(XzfFlowLog record);

    int updateByPrimaryKey(XzfFlowLog record);
}