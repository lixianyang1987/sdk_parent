package com.hytx.dao.sync.ori;

import com.hytx.model.sync.Tdxlt;
import com.hytx.model.sync.TdxltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdxltMapper {
    int countByExample(TdxltExample example);

    int deleteByExample(TdxltExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(Tdxlt record);

    int insertSelective(Tdxlt record);

    List<Tdxlt> selectByExample(TdxltExample example);

    Tdxlt selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") Tdxlt record, @Param("example") TdxltExample example);

    int updateByExample(@Param("record") Tdxlt record, @Param("example") TdxltExample example);

    int updateByPrimaryKeySelective(Tdxlt record);

    int updateByPrimaryKey(Tdxlt record);
}