package com.icastle.commentphotos.model;

import com.icastle.Orders.model.OrdersVO;

public class OrderJDBC_Test {
	
	
	public static void main(String args[]){
		
		OrdersVO ordersVO;
		OrdersJDBCTest ordersJDBC = new OrdersJDBCTest();
		ordersVO = ordersJDBC.findByOrderId(2);
		System.out.println(ordersVO.getOrderId());
		System.out.println(ordersVO.getHotelId());
	}

}
