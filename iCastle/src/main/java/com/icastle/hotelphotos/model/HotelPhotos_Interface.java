package com.icastle.hotelphotos.model;

import java.util.List;

public interface HotelPhotos_Interface {
	//批次新增圖片
	public int addPhoto(List<HotelPhotosVO> photovos);
	//批次修改圖片
	public int updatePhoto(List<HotelPhotosVO> photovos);
	//根據id查一張圖片
	public HotelPhotosVO findByPrimaryKey(Integer id);
	//查到某家飯店的第一張照片
	public HotelPhotosVO findByHotelIdTop1(Integer hotelId);
	//查到某家飯店所有照片
	public List<HotelPhotosVO> findByHotelId(Integer hotelId);
	//查到某種房型所有照片
	public List<HotelPhotosVO> findByRoomTypeId(Integer roomTypeId);
	//刪除一張照片
	public int deletePhoto(Integer id);
}
