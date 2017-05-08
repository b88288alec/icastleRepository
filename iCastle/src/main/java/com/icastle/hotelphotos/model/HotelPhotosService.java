package com.icastle.hotelphotos.model;

import java.util.List;

public class HotelPhotosService {

	HotelPhotos_Interface dao = null;
	
	public HotelPhotosService(){
		dao = new HotelPhotosDAOHibernate();
	}
	
	//批次新增圖片
	public int addPhoto(List<HotelPhotosVO> photovos){
		return dao.addPhoto(photovos);
	}
	
	//批次修改圖片
	public int updatePhoto(List<HotelPhotosVO> photovos){
		return dao.addPhoto(photovos);
	}
	
	//根據id查詢單筆
	public HotelPhotosVO findByPrimaryKey(Integer id){
		return dao.findByPrimaryKey(id);
	}
	
	//根據hotelId查詢該飯店第一張
	public HotelPhotosVO findByHotelIdTop1(Integer hotelId){
		return dao.findByHotelIdTop1(hotelId);
	}
	
	//根據hotelId查詢該飯店所有照片
	public List<HotelPhotosVO> findByHotelId(Integer hotelId) {
		return dao.findByHotelId(hotelId);
	}
	
	//根據roomTypeId查詢該房型所有照片
	public List<HotelPhotosVO> findByRoomTypeId(Integer roomTypeId){
		return dao.findByRoomTypeId(roomTypeId);
	}
	
	//刪除圖片
	public int deletePhoto(List<Integer> id){
		return dao.deletePhoto(id);
	}
	
}
