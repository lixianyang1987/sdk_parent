package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.baseConf.OperateKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateKeywordMapper {
    int countByExample(OperateKeywordExample example);

    int deleteByExample(OperateKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperateKeyword record);

    int insertSelective(OperateKeyword record);

    List<OperateKeyword> selectByExample(OperateKeywordExample example);

    OperateKeyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperateKeyword record, @Param("example") OperateKeywordExample example);

    int updateByExample(@Param("record") OperateKeyword record, @Param("example") OperateKeywordExample example);

    int updateByPrimaryKeySelective(OperateKeyword record);

    int updateByPrimaryKey(OperateKeyword record);
}