package com.hytx.dao.sync.ori;

import com.hytx.model.sync.Tsyskmm;
import com.hytx.model.sync.TsyskmmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TsyskmmMapper {
    int countByExample(TsyskmmExample example);

    int deleteByExample(TsyskmmExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Tsyskmm record);

    int insertSelective(Tsyskmm record);

    List<Tsyskmm> selectByExample(TsyskmmExample example);

    Tsyskmm selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Tsyskmm record, @Param("example") TsyskmmExample example);

    int updateByExample(@Param("record") Tsyskmm record, @Param("example") TsyskmmExample example);

    int updateByPrimaryKeySelective(Tsyskmm record);

    int updateByPrimaryKey(Tsyskmm record);
}