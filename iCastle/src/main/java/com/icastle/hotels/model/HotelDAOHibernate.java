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
	public HotelVO updateHotel(HotelVO hotelVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
	public HotelVO updateState(int hotelId, int state) {
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
	public HotelVO findByPrimaryKey(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, int peopleNum, String order,
			int lowprice, int highprice, double point, int star) {
		// TODO Auto-generated method stub
		return null;
	}

}
