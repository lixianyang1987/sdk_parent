package com.hytx.dao.sms.ori;

import com.hytx.model.sms.SmsLtyy;
import com.hytx.model.sms.SmsLtyyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsLtyyMapper {
    int countByExample(SmsLtyyExample example);

    int deleteByExample(SmsLtyyExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(SmsLtyy record);

    int insertSelective(SmsLtyy record);

    List<SmsLtyy> selectByExample(SmsLtyyExample example);

    SmsLtyy selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") SmsLtyy record, @Param("example") SmsLtyyExample example);

    int updateByExample(@Param("record") SmsLtyy record, @Param("example") SmsLtyyExample example);

    int updateByPrimaryKeySelective(SmsLtyy record);

    int updateByPrimaryKey(SmsLtyy record);
}