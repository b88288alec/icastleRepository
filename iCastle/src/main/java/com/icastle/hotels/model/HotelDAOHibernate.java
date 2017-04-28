package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class HotelDAOHibernate implements HotelDAO_Interface {

	@Override
	public HotelVO addHotel(HotelVO hotelVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(hotelVO);// 新增
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotelVO;
	}

	@Override
	public int changePw(Integer hotelId, String pw) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelVO hotel = findByPrimaryKey(hotelId);
		hotel.setPw(pw);
		try {
			session.beginTransaction();
			session.saveOrUpdate(hotel);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return 0;
	}

	@Override
	public HotelVO updateState(Integer hotelId, Integer state) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelVO hotelVO = new HotelVO();
		hotelVO.setHotelId(hotelId);
		hotelVO.setHotelState(state);
		try {
			session.beginTransaction();
			session.saveOrUpdate(hotelVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotelVO;
	}

	@Override
	public HotelVO findByPrimaryKey(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, Integer peopleNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, Integer peopleNum, String order,
			Integer lowprice, Integer highprice, double point, Integer star) {
		// TODO Auto-generated method stub
		return null;
	}

}
