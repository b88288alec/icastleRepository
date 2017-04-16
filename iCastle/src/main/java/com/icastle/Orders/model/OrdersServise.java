package com.icastle.Orders.model;

import java.util.List;

public class OrdersServise {
	
	private OrdersDAO_interface dao = null;
	
	public OrdersServise(){
		dao = new OrdersJNDI_DAO();
	}
	
//	新增訂單
	public void newOrder(Integer memberId, Integer roomId, Integer price, Integer dates, Integer roomNum, Boolean orderState, String reservationer, java.sql.Date bdate, String tel, String personId, String email, String country, String addr, String passport, Boolean bedAdding, String remark){
		OrdersVO order = new OrdersVO();
		order.setMemberId(memberId);
		order.setRoomId(roomId);
		order.setPrice(price);
		order.setDates(dates);
		order.setRoomNum(roomNum);
		order.setOrderState(orderState);
		order.setReservationer(reservationer);
		order.setBdate(bdate);
		order.setTel(tel);
		order.setPersonId(personId);
		order.setEmail(email);
		order.setCountry(country);
		order.setAddr(addr);
		order.setPassport(passport);
		order.setBedAdding(bedAdding);
		order.setRemark(remark);
		
		dao.insert(order);
	}
	
//	修改訂單狀態
	public void cancel(Integer orderId, Boolean orderState){
		OrdersVO order = dao.select_by_orderId(orderId);
		order.setOrderState(orderState);
		
		dao.update(order);
	}
	
//	客戶搜尋所有訂單
	public List<OrdersVO> search_By_MemberId(Integer memberId){
		List<OrdersVO> result = dao.select_by_memberId(memberId);
		
		return result;
	}
	
//	客戶搜尋單筆訂單
	public OrdersVO search_By_OrderId(Integer orderId){
		OrdersVO result = dao.select_by_orderId(orderId);
		
		return result;
	}

}
