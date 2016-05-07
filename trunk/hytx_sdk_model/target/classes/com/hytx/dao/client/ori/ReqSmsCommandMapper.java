package com.hytx.dao.client.ori;

import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.client.ReqSmsCommandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReqSmsCommandMapper {
    int countByExample(ReqSmsCommandExample example);

    int deleteByExample(ReqSmsCommandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReqSmsCommand record);

    int insertSelective(ReqSmsCommand record);

    List<ReqSmsCommand> selectByExample(ReqSmsCommandExample example);

    ReqSmsCommand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReqSmsCommand record, @Param("example") ReqSmsCommandExample example);

    int updateByExample(@Param("record") ReqSmsCommand record, @Param("example") ReqSmsCommandExample example);

    int updateByPrimaryKeySelective(ReqSmsCommand record);

    int updateByPrimaryKey(ReqSmsCommand record);
}