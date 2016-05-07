package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfWxBillResult;
import com.hytx.model.xzf.XzfWxBillResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfWxBillResultMapper {
    int countByExample(XzfWxBillResultExample example);

    int deleteByExample(XzfWxBillResultExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(XzfWxBillResult record);

    int insertSelective(XzfWxBillResult record);

    List<XzfWxBillResult> selectByExample(XzfWxBillResultExample example);

    XzfWxBillResult selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") XzfWxBillResult record, @Param("example") XzfWxBillResultExample example);

    int updateByExample(@Param("record") XzfWxBillResult record, @Param("example") XzfWxBillResultExample example);

    int updateByPrimaryKeySelective(XzfWxBillResult record);

    int updateByPrimaryKey(XzfWxBillResult record);
}