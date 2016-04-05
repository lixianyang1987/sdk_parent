package com.hytx.dao.unipay.ori;

import com.hytx.model.unipay.UnipayState;
import com.hytx.model.unipay.UnipayStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnipayStateMapper {
    int countByExample(UnipayStateExample example);

    int deleteByExample(UnipayStateExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(UnipayState record);

    int insertSelective(UnipayState record);

    List<UnipayState> selectByExample(UnipayStateExample example);

    UnipayState selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") UnipayState record, @Param("example") UnipayStateExample example);

    int updateByExample(@Param("record") UnipayState record, @Param("example") UnipayStateExample example);

    int updateByPrimaryKeySelective(UnipayState record);

    int updateByPrimaryKey(UnipayState record);
}