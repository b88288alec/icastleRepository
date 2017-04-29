package com.icastle.hotelphotos.model;

public class HotelPhotosService {

	HotelPhotos_Interface dao = null;
	
	public HotelPhotosService(){
		dao = new HotelPhotosDAOHibernate();
	}
	
	//新增圖片
	public HotelPhotosVO addPhoto(){
		
		return null;
	}
	
	//修改圖片
	public HotelPhotosVO updatePhoto(){
		return null;
	}
	
	//根據id查詢單筆
	public HotelPhotosVO findByPrimaryKey(Integer id){
		return null;
	}
	
	//根據hotelId查詢該飯店所有照片
	public HotelPhotosVO findByHotelIdTop1(Integer hotelId){
		return dao.findByHotelIdTop1(hotelId);
	}
	
	//根據hotelId查詢該飯店所有照片
	public HotelPhotosVO findByHotelId(){
		return null;
	}
	
	//根據roomTypeId查詢該房型所有照片
	public HotelPhotosVO findByRoomTypeId(){
		return null;
	}
	
	//刪除圖片
	public void deletePhoto(){
		
	}
	
}
