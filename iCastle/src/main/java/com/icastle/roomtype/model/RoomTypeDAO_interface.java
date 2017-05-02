package com.icastle.roomtype.model;

import java.util.List;

public interface RoomTypeDAO_interface {
	public Integer addOrUpdateRoomType(List<RoomTypeVO> roomTypeList);
	public Integer deleteRoomType(List<RoomTypeVO> roomTypeList);
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId);
}
