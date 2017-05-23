package com.icastle.roomtype.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class RoomTypeHibernateDAO implements RoomTypeDAO_interface{

	@Override
	public Integer addOrUpdateRoomType(List<RoomTypeVO> roomTypeList) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Integer updateCount = 0;
		try{
			session.beginTransaction();
			for(RoomTypeVO vo : roomTypeList){
				session.saveOrUpdate(vo);
				updateCount += 1;
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return updateCount;
	}

	@Override
	public Integer deleteRoomType(List<RoomTypeVO> roomTypeList) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Integer updateCount = 0;
		try{
			session.beginTransaction();
			Query query = session.createQuery("update RoomTypeVO set deleteStatus = 1 where roomTypeId = ?");
			for(RoomTypeVO vo : roomTypeList){
				query.setParameter(0, vo.getRoomTypeId());
				updateCount = query.executeUpdate();
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return updateCount;
	}

	@Override
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<RoomTypeVO> list = null;
		try{
			session.beginTransaction();
			Query query = session.createQuery("from RoomTypeVO where hotelId = ?");
			query.setParameter(0, hotelId);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}

	@Override
	public Map<String, String> findRoomTypePrice(Integer roomTypeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Map<String, String> price = new TreeMap<String, String>();
		try{
			session.beginTransaction();
			Query query = session.createQuery("select weekdaysPrice, holidayPrice, seasonPrice, customizedPrice, customizedName from RoomTypeVO where roomTypeId = ?");
			query.setParameter(0, roomTypeId);
			List<Object[]> list = query.list();
			for(Object[] obj : list){
				price.put("weekdaysPrice", ((Integer)obj[0]).toString());
				price.put("holidayPrice", ((Integer)obj[1]).toString());
				price.put("seasonPrice", ((Integer)obj[2]).toString());
				price.put("customizedPrice", (String.valueOf((Integer)obj[3])));
				price.put("customizedName", String.valueOf((String)obj[4]));
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return price;
	}

}
