package com.hytx.service.sync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.OrderSyncMapper;
import com.hytx.model.sync.OrderSync;

@Service("orderSyncServiceImpl")
public class OrderSyncServiceImpl implements IOrderSyncService {
	@Autowired
	private OrderSyncMapper orderSyncMapper;

	public int insert(OrderSync orderSync) {
		return orderSyncMapper.insert(orderSync);
	}

}
