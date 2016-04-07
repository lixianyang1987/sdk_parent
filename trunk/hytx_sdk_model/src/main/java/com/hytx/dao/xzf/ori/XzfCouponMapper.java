package com.hytx.dao.xzf.ori;

import com.hytx.model.xzf.XzfCoupon;
import com.hytx.model.xzf.XzfCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzfCouponMapper {
    int countByExample(XzfCouponExample example);

    int deleteByExample(XzfCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XzfCoupon record);

    int insertSelective(XzfCoupon record);

    List<XzfCoupon> selectByExample(XzfCouponExample example);

    XzfCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XzfCoupon record, @Param("example") XzfCouponExample example);

    int updateByExample(@Param("record") XzfCoupon record, @Param("example") XzfCouponExample example);

    int updateByPrimaryKeySelective(XzfCoupon record);

    int updateByPrimaryKey(XzfCoupon record);
}