package com.icastle.Orders.model;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.ws.RespectBinding;

public class OrdersService {
	
	private OrdersDAO_interface dao = null;
	
	
	public OrdersService(){
		dao = new OrdersJNDI_DAO();
	}
	
//	新增訂單
	public void newOrder(Integer memberId, Integer roomId, Integer hotelId, String hotelName, Integer roomTypeId, String RoomTypeName, java.sql.Date checkinDay, java.sql.Date checkoutDay, Integer roomCount, Integer peopleNum, Boolean breakfast, Boolean dinner, Boolean afternoonTea, Integer price, String reservationer, java.sql.Date bdate, String tel, String email, String addr, String personId, String country, String passport, Boolean bedAdding, Integer pricePerPerson, String customerRemark, String hotelRemark, Boolean orderState){
		OrdersVO ordersVO = new OrdersVO();
		
		ordersVO.setOrderedDate(new java.sql.Date(new GregorianCalendar().getInstance().getTimeInMillis()));
		ordersVO.setMemberId(memberId);
		ordersVO.setRoomId(roomId);
		ordersVO.setHotelId(hotelId);
		ordersVO.setHotelName(hotelName);
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
	
//	客戶修改訂單狀態
	public void customerUpdate(Integer orderId, Boolean orderState){
		OrdersVO order = dao.select_by_orderId(orderId);
		
		java.sql.Date day = new java.sql.Date(new GregorianCalendar().getInstance().getTimeInMillis());
		
		order.setOrderState(orderState);
		order.setCancelDate(day);
		
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
	
//	業者修改訂單內容
	public void industryUpdate(Integer orderId, String memo){
		OrdersVO order = dao.select_by_orderId(orderId);
		
		order.setMemo(memo);
		
		dao.update(order);
	}

//	業者搜尋訂單
	public List<OrdersVO> search_By_HotelId(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Integer day, Boolean state){
		
		if(day == null){
			if(state == null){
				if(roomTypeId == null){
					if(month == null){
						return dao.select_by_hotelId_year(hotelId, year);
					}else{
						return dao.select_by_hotelId_month(hotelId, year, month);
					}
				}else{
					if(month == null){
						return dao.select_by_hotelId_year_roomTypeId(hotelId, roomTypeId, year);
					}else{
						return dao.select_by_hotelId_month_roomTypeId(hotelId, roomTypeId, year, month);
					}
				}
			}else{
				if(roomTypeId == null){
					if(month == null){
						return dao.select_by_hotelId_year_orderstate(hotelId, year, state);
					}else{
						return dao.select_by_hotelId_month_orderstate(hotelId, year, month, state);
					}
				}else{
					if(month == null){
						return dao.select_by_hotelId_year_roomTypeId_orderstate(hotelId, roomTypeId, year, state);
					}else{
						return dao.select_by_hotelId_month_roomTypeId_orderstate(hotelId, roomTypeId, year, month, state);
					}
				}
			}
		}else{
			if(state == null){
				if(roomTypeId == null){
					return dao.select_by_hotelId_day(hotelId, year, month, day);
				}else{
					return dao.select_by_hotelId_day_roomTypeId(hotelId, roomTypeId, year, month, day);
				}
			}else{
				if(roomTypeId == null){
					return dao.select_by_hotelId_day_orderstate(hotelId, year, month, day, state);
				}else{
					return dao.select_by_hotelId_day_roomTypeId_orderstate(hotelId, roomTypeId, year, month, day, state);
				}
			}
		}
		
//		if(month == null && day == null && roomTypeId == null && state == null){
//			return dao.select_by_hotelId_year(hotelId, year);
//		}
//		if(day == null && roomTypeId == null && state == null){
//			return dao.select_by_hotelId_month(hotelId, year, month);
//		}
//		if(roomTypeId == null && state == null){
//			return dao.select_by_hotelId_day(hotelId, year, month, day);
//		}
//		if(month == null && day == null && roomTypeId == null){
//			return dao.select_by_hotelId_year_orderstate(hotelId, year, state);
//		}
//		if(day == null && roomTypeId == null){
//			return dao.select_by_hotelId_month_orderstate(hotelId, year, month, state);
//		}
//		if(roomTypeId == null){
//			return dao.select_by_hotelId_day_orderstate(hotelId, year, month, day, state);
//		}
//		if(month == null && day == null && state == null){
//			return dao.select_by_hotelId_year_roomTypeId(hotelId, roomTypeId, year);
//		}
//		if(day == null && state == null){
//			return dao.select_by_hotelId_month_roomTypeId(hotelId, roomTypeId, year, month);
//		}
//		if(state == null){
//			return dao.select_by_hotelId_day_roomTypeId(hotelId, roomTypeId, year, month, day);
//		}
//		if(month == null && day == null){
//			return dao.select_by_hotelId_year_roomTypeId_orderstate(hotelId, roomTypeId, year, state);
//		}
//		if(day == null){
//			return dao.select_by_hotelId_month_roomTypeId_orderstate(hotelId, roomTypeId, year, month, state);
//		}
//		if(month != null && day != null && roomTypeId != null && state != null){
//			return dao.select_by_hotelId_day_roomTypeId_orderstate(hotelId, roomTypeId, year, month, day, state);
//		}else{
//			return null;
//		}
	}
	
//	搜尋所有訂單
	public List<OrdersVO> searchAll(){
		return dao.select_all();
	}
	
}
