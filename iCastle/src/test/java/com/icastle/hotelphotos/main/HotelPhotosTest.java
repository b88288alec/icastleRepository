package com.icastle.hotelphotos.main;

import com.icastle.hotelphotos.model.*;

public class HotelPhotosTest {

	public static void main(String[] args) {
		
		//查詢飯店的第一張照片
		HotelPhotosService dao = new HotelPhotosService();
		HotelPhotosVO photo = dao.findByHotelIdTop1(2);
		System.out.println(photo.getId());
		System.out.println(photo.getHotelId());
		System.out.println(photo.getPhotoOrder());
		System.out.println(photo.getPhoto());
		System.out.println(photo.getRoomTypeId());
		System.out.println(photo.getPohtoDescription());
	}

}
