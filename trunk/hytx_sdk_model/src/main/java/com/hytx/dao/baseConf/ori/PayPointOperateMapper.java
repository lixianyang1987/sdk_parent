package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.PayPointOperate;
import com.hytx.model.baseConf.PayPointOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayPointOperateMapper {
    int countByExample(PayPointOperateExample example);

    int deleteByExample(PayPointOperateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayPointOperate record);

    int insertSelective(PayPointOperate record);

    List<PayPointOperate> selectByExample(PayPointOperateExample example);

    PayPointOperate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayPointOperate record, @Param("example") PayPointOperateExample example);

    int updateByExample(@Param("record") PayPointOperate record, @Param("example") PayPointOperateExample example);

    int updateByPrimaryKeySelective(PayPointOperate record);

    int updateByPrimaryKey(PayPointOperate record);
}