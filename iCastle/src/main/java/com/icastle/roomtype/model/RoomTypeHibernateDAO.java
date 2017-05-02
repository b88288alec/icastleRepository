package com.icastle.roomtype.model;

import java.util.ArrayList;
import java.util.List;

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

}
