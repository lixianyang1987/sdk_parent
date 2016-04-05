package com.hytx.dao.client.ori;

import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReqSmsMapper {
    int countByExample(ReqSmsExample example);

    int deleteByExample(ReqSmsExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(ReqSms record);

    int insertSelective(ReqSms record);

    List<ReqSms> selectByExample(ReqSmsExample example);

    ReqSms selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") ReqSms record, @Param("example") ReqSmsExample example);

    int updateByExample(@Param("record") ReqSms record, @Param("example") ReqSmsExample example);

    int updateByPrimaryKeySelective(ReqSms record);

    int updateByPrimaryKey(ReqSms record);
}