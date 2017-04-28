package com.icastle.Orders.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class OrdersHibernateDAO implements OrdersDAO_interface{
	
	private static final String SELECT_BY_MEMBERID = "from OrdersVO where memberId = :memberId";
	private static final String SELECT_BY_ORDERID = "from OrdersVO where orderId = :orderId";
	
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

		
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year(Integer hotelId, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month(Integer hotelId, Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day(Integer hotelId, Integer year, Integer month, Integer day) {
		// TODO Auto-generated method stub
		return null;
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
