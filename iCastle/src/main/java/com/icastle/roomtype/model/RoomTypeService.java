package com.icastle.roomtype.model;

import java.util.List;
import java.util.Map;

public class RoomTypeService {
	
	RoomTypeDAO_interface dao = new RoomTypeHibernateDAO();
	
	public Integer addOrUpdateRoomType(List<RoomTypeVO> roomTypeList){
		return dao.addOrUpdateRoomType(roomTypeList);
	}
	
	public Integer deleteRoomType(List<RoomTypeVO> roomTypeList){
		return dao.deleteRoomType(roomTypeList);
	}
	
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId){
		return dao.findRoomTypeByHotelId(hotelId);
	}
	
	public Map<String,String> findRoomTypePrice(Integer roomTypeId){
		return dao.findRoomTypePrice(roomTypeId);
	}

}
