package com.icastle.hotels.main;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;

public class HotelTest {

	public static void main(String[] args) {
		// addHotel
		HotelService dao = new HotelService();
		HotelVO hotel = new HotelVO();
		hotel.setHotelName("好帥");
		hotel.setEmail("handsome@gmail.com");
		hotel.setPw("handsome");
		hotel.setAddr("台北市松山區南京東路四段2號");
		hotel.setZone("台北市");
		hotel.setPoint(4.0);
		hotel.setHot(135);
		hotel.setStar(5);
		hotel.setHotelState(1);
		hotel.setRegisterId("好帥第210號");
		dao.addHotel(hotel);
		System.out.println("成功新增");
		
		
	}
}
