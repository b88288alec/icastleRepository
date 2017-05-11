package com.icastle.hotels.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	public void update(HotelVO hotelVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(hotelVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}



	@Override
	public HotelVO findByPrimaryKey(Integer hotelId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelVO hotel = null;
		try {
			session.beginTransaction();
			hotel = (HotelVO) session.get(HotelVO.class, hotelId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotel;
	}

	@Override
	public HotelVO findByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelVO hotelvo = new HotelVO();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from HotelVO where email = :email");
			query.setParameter("email", email);
			List<HotelVO> hotels = new ArrayList<HotelVO>();
			hotels = query.list();
			//查無此email
			if (hotels.size() == 0)
				hotelvo = null;
			else {
				//有查到資料，封裝到HotelVO
				hotelvo = hotels.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotelvo;
	}

	@Override
	public HotelVO checkAccountPw(String email, String pw){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelVO hotel = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from HotelVO where email=:email and pw=:pw");
			query.setParameter("email", email);
			query.setParameter("pw", pw);
			List<HotelVO> list = query.list();
			hotel = (list.size()==1) ? list.get(0) : null;
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotel;
	}
	
	@Override
	public List<ListVO> indexQuery(String type, Date startDate, Date endDate, Integer peopleNum) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ListVO> list = new ArrayList<ListVO>();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery("{call indexQuery(?,?,?,?)}");
			query.setParameter(0, type);
			query.setParameter(1, startDate);
			query.setParameter(2, endDate);
			query.setParameter(3, peopleNum);
			query.setTimeout(90);
			List<Object[]> objects = query.list();
			for (Object[] object : objects){
				ListVO alist = new ListVO();
				alist.setHotelId((Integer)object[0]);
				alist.setHotelName((String)object[1]);
				alist.setZone((String)object[2]);
				alist.setPrice((Integer)object[3]);
				alist.setStar((Integer)object[4]);
				alist.setPoint((Double)object[5]);
				alist.setHot((Integer)object[6]);
				alist.setBreakfast((Boolean)object[7]);
				alist.setDinner((Boolean)object[8]);
				alist.setRoomWifi((Boolean)object[9]);
				list.add(alist);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}     	
		return list;
	}

	@Override
	public List<ListVO> advancedQuery(String type, Date startDate, Date endDate, Integer peopleNum, String order,
			Integer lowprice, Integer highprice, double point, Integer star) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ListVO> list = new ArrayList<ListVO>();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery("{call advanceQuery(?,?,?,?,?,?,?,?,?)}");
			query.setParameter(0, type);
			query.setParameter(1, startDate);
			query.setParameter(2, endDate);
			query.setParameter(3, peopleNum);
			query.setParameter(4, order);
			query.setParameter(5, lowprice);
			query.setParameter(6, highprice);
			query.setParameter(7, point);
			query.setParameter(8, star);
			query.setTimeout(90);
			List<Object[]> objects = query.list();
			for (Object[] object : objects){
				ListVO alist = new ListVO();
				alist.setHotelId((Integer)object[0]);
				alist.setHotelName((String)object[1]);
				alist.setPrice((Integer)object[2]);
				alist.setStar((Integer)object[3]);
				alist.setPoint((Double)object[4]);
				alist.setHot((Integer)object[5]);
				alist.setBreakfast((Boolean)object[6]);
				alist.setDinner((Boolean)object[7]);
				alist.setRoomWifi((Boolean)object[8]);
				list.add(alist);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}     	
		return list;
	}

	@Override
	public List<HotelVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HotelVO> hotels = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from HotelVO");
			hotels = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotels;
	}

	@Override
	public List<HotelandInfoVO> getHotelAndInfo() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HotelandInfoVO> hotelAndInfos = new ArrayList<HotelandInfoVO>();
		
		try {
			session.beginTransaction();
			
			Query query = session.createSQLQuery("{call getHotelandInfo()}");
			query.setTimeout(90);
			List<Object[]> objects = query.list();
			for (Object[] object : objects){
				HotelandInfoVO hotelandInfo = new HotelandInfoVO();
				hotelandInfo.setHotelId((Integer)object[0]);
				hotelandInfo.setHotelName((String)object[1]);
				hotelandInfo.setEmail((String)object[2]);
				hotelandInfo.setPw((String)object[3]);
				hotelandInfo.setAddr((String)object[4]);
				hotelandInfo.setZone((String)object[5]);
				hotelandInfo.setPoint((Double)object[6]);
				hotelandInfo.setHot((Integer)object[7]);
				hotelandInfo.setStar((Integer)object[8]);
				hotelandInfo.setHotelState((Integer)object[9]);
				hotelandInfo.setRegisterId((String)object[10]);
				hotelandInfo.setRegisterName((String)object[11]);
				hotelandInfo.setTel((String)object[12]);
				hotelandInfo.setTransport((String)object[13]);
				hotelandInfo.setWebsite((String)object[14]);
				hotelandInfo.setHotelProfile((String)object[15]);
				hotelandInfo.setCheckin((String)object[16]);
				hotelandInfo.setCheckout((String)object[17]);
				hotelandInfo.setGuestPolicies((String)object[18]);
				hotelandInfo.setCancelPolicies((String)object[19]);
				hotelandInfo.setRoomWifi((Boolean)object[20]);
				hotelandInfo.setHallWifi((Boolean)object[21]);
				hotelandInfo.setInternet((Boolean)object[22]);
				hotelandInfo.setMineralWater((Boolean)object[23]);
				hotelandInfo.setToiletUtensils((Boolean)object[24]);
				hotelandInfo.setHairDryer((Boolean)object[25]);
				hotelandInfo.setTv((Boolean)object[26]);
				hotelandInfo.setGameRoom((Boolean)object[27]);
				hotelandInfo.setGym((Boolean)object[28]);
				hotelandInfo.setSpa((Boolean)object[29]);
				hotelandInfo.setSwimPool((Boolean)object[30]);
				hotelAndInfos.add(hotelandInfo);
			}
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hotelAndInfos;
	}
}
