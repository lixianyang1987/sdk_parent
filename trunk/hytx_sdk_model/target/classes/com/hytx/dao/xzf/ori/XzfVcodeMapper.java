package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfVcode;
import com.hytx.model.xzf.XzfVcodeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfVcodeMapper {
    int countByExample(XzfVcodeExample example);

    int deleteByExample(XzfVcodeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(XzfVcode record);

    int insertSelective(XzfVcode record);

    List<XzfVcode> selectByExample(XzfVcodeExample example);

    XzfVcode selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") XzfVcode record, @Param("example") XzfVcodeExample example);

    int updateByExample(@Param("record") XzfVcode record, @Param("example") XzfVcodeExample example);

    int updateByPrimaryKeySelective(XzfVcode record);

    int updateByPrimaryKey(XzfVcode record);
}