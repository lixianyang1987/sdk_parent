package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.TCountIncome;
import com.hytx.model.syncEx.TCountIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCountIncomeMapper {
    int countByExample(TCountIncomeExample example);

    int deleteByExample(TCountIncomeExample example);

    int insert(TCountIncome record);

    int insertSelective(TCountIncome record);

    List<TCountIncome> selectByExample(TCountIncomeExample example);

    int updateByExampleSelective(@Param("record") TCountIncome record, @Param("example") TCountIncomeExample example);

    int updateByExample(@Param("record") TCountIncome record, @Param("example") TCountIncomeExample example);
}