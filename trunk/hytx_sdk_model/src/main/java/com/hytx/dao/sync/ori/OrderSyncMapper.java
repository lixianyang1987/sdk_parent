package com.hytx.dao.sync.ori;

import com.hytx.model.sync.OrderSync;
import com.hytx.model.sync.OrderSyncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderSyncMapper {
    int countByExample(OrderSyncExample example);

    int deleteByExample(OrderSyncExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSync record);

    int insertSelective(OrderSync record);

    List<OrderSync> selectByExample(OrderSyncExample example);

    OrderSync selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderSync record, @Param("example") OrderSyncExample example);

    int updateByExample(@Param("record") OrderSync record, @Param("example") OrderSyncExample example);

    int updateByPrimaryKeySelective(OrderSync record);

    int updateByPrimaryKey(OrderSync record);
}