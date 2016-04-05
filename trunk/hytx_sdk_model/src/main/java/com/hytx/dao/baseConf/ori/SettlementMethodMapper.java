package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.SettlementMethod;
import com.hytx.model.baseConf.SettlementMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementMethodMapper {
    int countByExample(SettlementMethodExample example);

    int deleteByExample(SettlementMethodExample example);

    int deleteByPrimaryKey(Integer smId);

    int insert(SettlementMethod record);

    int insertSelective(SettlementMethod record);

    List<SettlementMethod> selectByExample(SettlementMethodExample example);

    SettlementMethod selectByPrimaryKey(Integer smId);

    int updateByExampleSelective(@Param("record") SettlementMethod record, @Param("example") SettlementMethodExample example);

    int updateByExample(@Param("record") SettlementMethod record, @Param("example") SettlementMethodExample example);

    int updateByPrimaryKeySelective(SettlementMethod record);

    int updateByPrimaryKey(SettlementMethod record);
}