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
			for(RoomTypeVO vo : roomTypeList){
				session.delete(vo);
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
	public List<RoomTypeVO> findRoomTypeByHotelId(Integer hotelId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		try{
			session.beginTransaction();
			Query query = session.createQuery("from RoomTypeVO where hotelId = ?");
			query.setParameter(0, hotelId);
			List<Object[]> listObj = query.list();
			for(Object[] arrayObj : listObj){
				RoomTypeVO vo = new RoomTypeVO();
				vo.setRoomTypeId((Integer)arrayObj[0]);
				vo.setHotelId((Integer)arrayObj[1]);
				vo.setRoomTypeName((String)arrayObj[2]);
				vo.setPeopleNum((Integer)arrayObj[3]);
				vo.setRoomNumber((Integer)arrayObj[4]);
				vo.setWeekdaysPrice((Integer)arrayObj[5]);
				vo.setHolidayPrice((Integer)arrayObj[6]);
				vo.setSeasonPrice((Integer)arrayObj[7]);
				vo.setCustomizedPrice((Integer)arrayObj[8]);
				vo.setCustomizedName((String)arrayObj[9]);
				vo.setBreakfast((Boolean)arrayObj[10]);
				vo.setAfternoonTea((Boolean)arrayObj[11]);
				vo.setDinner((Boolean)arrayObj[12]);
				vo.setBedAddable((Boolean)arrayObj[13]);
				vo.setPricePerPerson((Integer)arrayObj[14]);
				vo.setRemark((String)arrayObj[15]);
				list.add(vo);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}

}
