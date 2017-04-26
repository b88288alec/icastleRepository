package com.icastle.rooms.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomsService {
	RoomsDAO_interface dao = new RoomsJNDIDAO();
	
	public int insertRooms(List<RoomsVO> roomList){
		return dao.insert(roomList);
	}
	
	public int updateDetail(List<RoomsVO> roomList){
		return dao.updateDetail(roomList);
	}
	
	public List<RoomsVO> getRoomsByMonth(int hotelId, int roomTypeId, int month){
		return dao.getRoomsByMonth(hotelId, roomTypeId, month);
	}
	
	public List<RoomsVO> findRooms(int hotelId, int peopleNum, Date star, Date end){
		return dao.findRooms(hotelId, peopleNum, star, end);
	}
	
	public int getOrder(int roomId, int stayDayNum, int roomCount){
		return dao.getOrder(roomId, stayDayNum, roomCount);
	}
	
	public int updatePrice(List<RoomsVO> roomsList){
		return dao.updatePrice(roomsList);
	}
	
	public int getstayDayNum(String checkinDay, String checkoutDay){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		int stayDayNum = 0;
		try {
			long start = sdf.parse(checkinDay).getTime();
			long end = sdf.parse(checkoutDay).getTime();
			stayDayNum = (int)((end - start) / (1000*60*60*24));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return stayDayNum;
	}
	
	public Map<String,Integer> getPerPrice(int roomId, int stayDayNum){
		return dao.getPerPrice(roomId, stayDayNum);
	}
}
