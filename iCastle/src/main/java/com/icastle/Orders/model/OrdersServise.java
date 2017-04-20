package com.icastle.Orders.model;

import java.util.List;

public class OrdersServise {
	
	private OrdersDAO_interface dao = null;
	
	public OrdersServise(){
		dao = new OrdersJNDI_DAO();
	}
	
//	新增訂單
	public void newOrder(Integer memberId, Integer roomId, Integer hotelId, Integer roomTypeId, String RoomTypeName, java.sql.Date checkinDay, java.sql.Date checkoutDay, Integer roomCount, Integer peopleNum, Boolean breakfast, Boolean dinner, Boolean afternoonTea, Integer price, String reservationer, java.sql.Date bdate, String tel, String email, String addr, String personId, String country, String passport, Boolean bedAdding, Integer pricePerPerson, String customerRemark, String hotelRemark, Boolean orderState){
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setMemberId(memberId);
		ordersVO.setRoomId(roomId);
		ordersVO.setHotelId(hotelId);
		ordersVO.setRoomTypeId(roomTypeId);
		ordersVO.setRoomTypeName(RoomTypeName);
		ordersVO.setCheckinDay(checkinDay);
		ordersVO.setCheckoutDay(checkoutDay);
		ordersVO.setRoomCount(roomCount);
		ordersVO.setPeopleNum(peopleNum);
		ordersVO.setBreakfast(breakfast);
		ordersVO.setDinner(dinner);
		ordersVO.setAfternoonTea(afternoonTea);
		ordersVO.setPrice(price);
		ordersVO.setReservationer(reservationer);
		ordersVO.setBdate(bdate);
		ordersVO.setTel(tel);
		ordersVO.setEmail(email);
		ordersVO.setAddr(addr);
		ordersVO.setPersonId(personId);
		ordersVO.setCountry(country);
		ordersVO.setPassport(passport);
		ordersVO.setBedAdding(bedAdding);
		ordersVO.setPricePerPerson(pricePerPerson);
		ordersVO.setCustomerRemark(customerRemark);
		ordersVO.setHotelRemark(hotelRemark);
		ordersVO.setOrderState(orderState);
		
		dao.insert(ordersVO);
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
