package com.icastle.Orders.model;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class OrdersHibernateDAO implements OrdersDAO_interface{
	
	private static final String SELECT_BY_MEMBERID = "from OrdersVO where memberId = :memberId";
	private static final String SELECT_BY_HOTELID_YEAR = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout)";
	private static final String SELECT_BY_HOTELID_MONTH = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and (month(checkinDay)<=:monthin and month(checkoutDay)>=:monthout)";
	private static final String SELECT_BY_HOTELID_DAY = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>=:checkoutDay";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and roomtypeid=:roomtypeid";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and (month(checkinDay)<=:monthin and month(checkoutDay)>=:monthout) and roomtypeid=:roomtypeid";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>=:checkoutDay and roomtypeid=:roomtypeid";
	private static final String SELECT_BY_HOTELID_YEAR_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate";
	private static final String SELECT_BY_HOTELID_MONTH_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and (month(checkinDay)<=:monthin and month(checkoutDay)>=:monthout) and orderstate=:orderstate";
	private static final String SELECT_BY_HOTELID_DAY_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>=:checkoutDay and orderstate=:orderstate";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate and roomtypeid=:roomtypeid";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and (month(checkinDay)<=:monthin and month(checkoutDay)>=:monthout) and orderstate=:orderstate and roomtypeid=:roomtypeid";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>=:checkoutDay and orderstate=:orderstate and roomtypeid=:roomtypeid";
	
	@Override
	public void insert(OrdersVO ordersVO) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.save(ordersVO);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		
	}

	@Override
	public void update(OrdersVO ordersVO) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(ordersVO);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		
	}

	@Override
	public List<OrdersVO> select_by_memberId(Integer memberId) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MEMBERID);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public OrdersVO select_by_orderId(Integer orderId) {

		OrdersVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			result = (OrdersVO)session.get(OrdersVO.class, orderId);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year(Integer hotelId, Integer year) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_YEAR);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month(Integer hotelId, Integer year, Integer month) {
		
		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_MONTH);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("monthin", month);
			query.setParameter("monthout", month);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day(Integer hotelId, Integer year, Integer month, Integer day) {
		
		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_DAY);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			java.sql.Date checkDay = new java.sql.Date(sdf.parse(String.valueOf(year + month + day)).getTime());
			query.setParameter("hotelId", hotelId);
			query.setParameter("checkinDay", checkDay);
			query.setParameter("checkoutDay", checkDay);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_orderstate(Integer hotelId, Integer year, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_orderstate(Integer hotelId, Integer year, Integer month,
			Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_orderstate(Integer hotelId, Integer year, Integer month, Integer day,
			Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Integer month, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_all() {
		// TODO Auto-generated method stub
		return null;
	}

}
