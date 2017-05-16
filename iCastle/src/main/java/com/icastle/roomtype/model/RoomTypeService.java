package com.icastle.roomtype.model;

import java.util.List;
import java.util.Map;

public class RoomTypeService {
	
	RoomTypeDAO_interface dao = new RoomTypeHibernateDAO();
	//批次新增房型
	public Integer addOrUpdateRoomType(List<RoomTypeVO> roomTypeList){
		return dao.addOrUpdateRoomType(roomTypeList);
	}
	//修改deleteStatus欄位為true
	public Integer deleteRoomType(List<RoomTypeVO> roomTypeList){
		return dao.deleteRoomType(roomTypeList);
	}
	//查詢該飯店所有房型
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId){
		return dao.findRoomTypeByHotelId(hotelId);
	}
	//查詢房型價錢
	public Map<String,String> findRoomTypePrice(Integer roomTypeId){
		return dao.findRoomTypePrice(roomTypeId);
	}

}
