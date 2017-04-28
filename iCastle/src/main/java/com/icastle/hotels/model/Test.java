package com.icastle.hotels.model;

import java.util.*;

public class Test {

	public static void main(String[] args){
	
		//addHotel
		HotelDAO_Interface dao = new HotelDAOJNDI();
		HotelVO hotel = new HotelVO();
		hotel.setHotelName("好帥");
		hotel.setEmail("handsome@gmail.com");
		hotel.setPw("handsome");
		hotel.setAddr("台北市松山區南京東路四段2號");
		hotel.setZone("台北市");
		hotel.setStar(5);
		hotel.setRegisterId("好帥第210號");
		dao.addHotel(hotel);
		
		//updateHotel
//		HotelDAO_Interface dao = new HotelDAO();
//		HotelVO hotel = new HotelVO();
//		hotel.setHotelId(5);
//		hotel.setHotelName("555");
//		hotel.setPw("fff");
//		dao.updateHotel(hotel);
		
		//updateState
//		HotelDAO_Interface dao = new HotelDAO();
//		dao.updateState(5, 5);
		
		//findByPrimaryKey
//		HotelDAO_Interface dao = new HotelDAO();
//		HotelVO hotel = dao.findByPrimaryKey(5);
//		System.out.println(hotel.getEmail());
		
		//indexQuery
//		HotelDAO_Interface dao = new HotelDAO();
//		String zone = "雄市";
//		java.sql.Date startDate = java.sql.Date.valueOf("2017-01-02");
//		java.sql.Date endDate = java.sql.Date.valueOf("2017-01-04");
//		int peopleNum = 4;
//		List<List> hotels = dao.indexQuery(zone, startDate, endDate, peopleNum);
//		for (List list : hotels)
//			System.out.println(list.get(1));
	}
}
