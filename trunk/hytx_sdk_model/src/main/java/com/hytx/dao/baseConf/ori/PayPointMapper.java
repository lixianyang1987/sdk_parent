package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.baseConf.PayPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayPointMapper {
    int countByExample(PayPointExample example);

    int deleteByExample(PayPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayPoint record);

    int insertSelective(PayPoint record);

    List<PayPoint> selectByExample(PayPointExample example);

    PayPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayPoint record, @Param("example") PayPointExample example);

    int updateByExample(@Param("record") PayPoint record, @Param("example") PayPointExample example);

    int updateByPrimaryKeySelective(PayPoint record);

    int updateByPrimaryKey(PayPoint record);
}