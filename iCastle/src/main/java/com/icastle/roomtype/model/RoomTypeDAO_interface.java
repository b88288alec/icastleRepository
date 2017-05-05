package com.icastle.roomtype.model;

import java.util.List;
import java.util.Map;

public interface RoomTypeDAO_interface {
	//新增或修改房型
	public Integer addOrUpdateRoomType(List<RoomTypeVO> roomTypeList);
	//修改deleteStatus欄位為true
	public Integer deleteRoomType(List<RoomTypeVO> roomTypeList);
	//查詢該飯店所有房型
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId);
	//查詢房型價錢
	public Map<String,String> findRoomTypePrice(Integer roomTypeId);
}
