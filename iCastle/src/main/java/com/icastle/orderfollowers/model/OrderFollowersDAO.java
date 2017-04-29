package com.icastle.orderfollowers.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class OrderFollowersDAO implements OrderFollowersDAO_interface{
	
	private static final String SELECT_BY_ORDERID = "from OrderFollowersVO where orderId = ?"; 

	@Override
	public void insert(OrderFollowersVO orderFollowersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
		try {
		     session.beginTransaction();
		     session.saveOrUpdate(orderFollowersVO);
		     session.getTransaction().commit();        
		} catch (RuntimeException ex) {
		     session.getTransaction().rollback();
		     throw ex; //System.out.println(ex.getMessage());
		}
	}

	@Override
	public List<OrderFollowersVO> select_By_OrderId(Integer orderId) {
		
		List<OrderFollowersVO> result = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
		try {
		     session.beginTransaction();
		     Query query = session.createQuery(SELECT_BY_ORDERID);
		     query.setParameter(0, orderId);
		     result = query.list();
		     session.getTransaction().commit();        
		} catch (RuntimeException ex) {
		     session.getTransaction().rollback();
		     throw ex; //System.out.println(ex.getMessage());
		}
		return result;
	}
	
	

}
