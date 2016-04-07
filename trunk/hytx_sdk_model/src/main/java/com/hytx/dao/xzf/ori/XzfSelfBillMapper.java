package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfSelfBill;
import com.hytx.model.xzf.XzfSelfBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfSelfBillMapper {
    int countByExample(XzfSelfBillExample example);

    int deleteByExample(XzfSelfBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(XzfSelfBill record);

    int insertSelective(XzfSelfBill record);

    List<XzfSelfBill> selectByExample(XzfSelfBillExample example);

    XzfSelfBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") XzfSelfBill record, @Param("example") XzfSelfBillExample example);

    int updateByExample(@Param("record") XzfSelfBill record, @Param("example") XzfSelfBillExample example);

    int updateByPrimaryKeySelective(XzfSelfBill record);

    int updateByPrimaryKey(XzfSelfBill record);
}