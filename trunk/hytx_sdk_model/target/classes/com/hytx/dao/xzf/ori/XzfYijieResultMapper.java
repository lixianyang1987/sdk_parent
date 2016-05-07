package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfYijieResult;
import com.hytx.model.xzf.XzfYijieResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfYijieResultMapper {
    int countByExample(XzfYijieResultExample example);

    int deleteByExample(XzfYijieResultExample example);

    int deleteByPrimaryKey(String tcd);

    int insert(XzfYijieResult record);

    int insertSelective(XzfYijieResult record);

    List<XzfYijieResult> selectByExample(XzfYijieResultExample example);

    XzfYijieResult selectByPrimaryKey(String tcd);

    int updateByExampleSelective(@Param("record") XzfYijieResult record, @Param("example") XzfYijieResultExample example);

    int updateByExample(@Param("record") XzfYijieResult record, @Param("example") XzfYijieResultExample example);

    int updateByPrimaryKeySelective(XzfYijieResult record);

    int updateByPrimaryKey(XzfYijieResult record);
}