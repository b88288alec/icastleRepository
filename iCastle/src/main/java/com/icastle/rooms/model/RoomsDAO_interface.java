package com.icastle.rooms.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface RoomsDAO_interface {
	public int insert(List<RoomsVO> roomList);
	public int updateDetail(List<RoomsVO> roomList);
	public List<RoomsVO> getRoomsByMonth(int hotelId, int roomTypeId, int month);
	public List<RoomsVO> findRooms(int hotelId, int peopleNum, Date star, Date end);
	public int getOrder(int roomId, int dayNum);
	public int updatePrice(List<RoomsVO> roomsList);
	public Map<String,Integer> getPerPrice(int roomId, int stayDayNum);
}
