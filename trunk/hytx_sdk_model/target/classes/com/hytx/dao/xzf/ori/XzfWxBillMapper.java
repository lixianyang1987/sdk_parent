package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfWxBill;
import com.hytx.model.xzf.XzfWxBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfWxBillMapper {
    int countByExample(XzfWxBillExample example);

    int deleteByExample(XzfWxBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(XzfWxBill record);

    int insertSelective(XzfWxBill record);

    List<XzfWxBill> selectByExample(XzfWxBillExample example);

    XzfWxBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") XzfWxBill record, @Param("example") XzfWxBillExample example);

    int updateByExample(@Param("record") XzfWxBill record, @Param("example") XzfWxBillExample example);

    int updateByPrimaryKeySelective(XzfWxBill record);

    int updateByPrimaryKey(XzfWxBill record);
}