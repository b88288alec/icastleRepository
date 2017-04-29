package com.icastle.hotelphotos.model;

public interface HotelPhotos_Interface {

	public HotelPhotosVO findByPrimaryKey(Integer id);//根據id查單筆
	public HotelPhotosVO findByHotelIdTop1(Integer hotelId);//查到某家飯店的第一張照面
}
