package com.hytx.dao.unipay.ex;

import org.apache.ibatis.annotations.Param;

public interface UnipayStateMapperEx {
	/***
	 * 统计用户在银联成功购买的订单数
	 * 
	 * @param imsi
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	public int countUserUnipayOrder(@Param("imsi") String imsi);
}