package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfUnipayBill;
import com.hytx.model.xzf.XzfUnipayBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfUnipayBillMapper {
    int countByExample(XzfUnipayBillExample example);

    int deleteByExample(XzfUnipayBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(XzfUnipayBill record);

    int insertSelective(XzfUnipayBill record);

    List<XzfUnipayBill> selectByExample(XzfUnipayBillExample example);

    XzfUnipayBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") XzfUnipayBill record, @Param("example") XzfUnipayBillExample example);

    int updateByExample(@Param("record") XzfUnipayBill record, @Param("example") XzfUnipayBillExample example);

    int updateByPrimaryKeySelective(XzfUnipayBill record);

    int updateByPrimaryKey(XzfUnipayBill record);
}