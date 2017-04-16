package com.icastle.Orders.model;

import java.util.List;

public interface OrdersDAO_interface {
	
	public void insert(OrdersVO ordersVO);
	public void update(OrdersVO ordersVO);
	public List<OrdersVO> select_by_memberId(Integer memberId);
	public OrdersVO select_by_orderId(Integer orderId);
	public List<OrdersVO> select_all();

}
