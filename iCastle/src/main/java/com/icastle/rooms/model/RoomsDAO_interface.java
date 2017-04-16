package com.icastle.rooms.model;

import java.sql.Date;
import java.util.List;

public interface RoomsDAO_interface {
	public int insert(List<RoomsVO> roomList);
	public int update(List<RoomsVO> roomList);
	public List<RoomsVO> getRoomsByMonth(int hotelId, int roomTypeId, int month);
	public List<RoomsVO> findRooms(int hotelId, int peopleNum, Date star, Date end);
	public int getOrder(List<RoomsVO> roomsList);
}
