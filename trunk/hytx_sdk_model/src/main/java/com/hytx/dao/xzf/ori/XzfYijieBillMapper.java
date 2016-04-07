package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfYijieBill;
import com.hytx.model.xzf.XzfYijieBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfYijieBillMapper {
    int countByExample(XzfYijieBillExample example);

    int deleteByExample(XzfYijieBillExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(XzfYijieBill record);

    int insertSelective(XzfYijieBill record);

    List<XzfYijieBill> selectByExample(XzfYijieBillExample example);

    XzfYijieBill selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") XzfYijieBill record, @Param("example") XzfYijieBillExample example);

    int updateByExample(@Param("record") XzfYijieBill record, @Param("example") XzfYijieBillExample example);

    int updateByPrimaryKeySelective(XzfYijieBill record);

    int updateByPrimaryKey(XzfYijieBill record);
}