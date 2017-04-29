package com.icastle.rooms.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class RoomsHibernateDAO implements RoomsDAO_interface {

	@Override
	public Integer insert(List<RoomsVO> roomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public Integer updateDetail(List<RoomsVO> roomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomsVO> getRoomsByMonth(Integer hotelId, Integer roomTypeId, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomsVO> findRooms(Integer hotelId, Integer peopleNum, Date star, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getOrder(Integer roomId, Integer dayNum, Integer roomCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getOrder(Integer hotelId, Integer roomTypeId, Date checkinDay, Date checkoutDay, Integer roomCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updatePrice(List<RoomsVO> roomsList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getPerPrice(Integer roomId, Integer stayDayNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getPerPrice(Integer hotelId, Integer roomTypeId, Date checkinDay, Date checkoutDay) {
		// TODO Auto-generated method stub
		return null;
	}


}
