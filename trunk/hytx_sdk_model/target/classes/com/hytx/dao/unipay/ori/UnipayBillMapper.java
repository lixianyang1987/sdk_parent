package com.hytx.dao.unipay.ori;

import com.hytx.model.unipay.UnipayBill;
import com.hytx.model.unipay.UnipayBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnipayBillMapper {
    int countByExample(UnipayBillExample example);

    int deleteByExample(UnipayBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(UnipayBill record);

    int insertSelective(UnipayBill record);

    List<UnipayBill> selectByExample(UnipayBillExample example);

    UnipayBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") UnipayBill record, @Param("example") UnipayBillExample example);

    int updateByExample(@Param("record") UnipayBill record, @Param("example") UnipayBillExample example);

    int updateByPrimaryKeySelective(UnipayBill record);

    int updateByPrimaryKey(UnipayBill record);
}