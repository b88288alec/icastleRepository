package com.icastle.qa.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class QaHibernateDAO implements QaDAO_interface{

	@Override
	public void insert(QaVO qaVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try{
	    	session.beginTransaction();
	    	session.saveOrUpdate(qaVO);
	    	session.getTransaction().commit();
	    	
	    }catch (RuntimeException ex){
	    	session.getTransaction().rollback();
	    	throw ex;
	 	   }
	}

	@Override
	public void update(QaVO qaVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try{
	    	session.beginTransaction();
	    	session.saveOrUpdate(qaVO);
	    	session.getTransaction().commit();
	    	
	    }catch (RuntimeException ex){
	    	session.getTransaction().rollback();
	    	throw ex;
	 	   }
	}

	@Override
	public void delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try{
	    	session.beginTransaction();
	    	QaVO qaVO = (QaVO) session.get(QaVO.class, id);
	    	session.delete(qaVO);
	    	session.getTransaction().commit();
	    	
	    }catch (RuntimeException ex){
	    	session.getTransaction().rollback();
	    	throw ex;
	 	   }
		
	}

	@Override
	public List<QaVO> getAll() {
	    List<QaVO> list = null;
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try{
	    	session.beginTransaction();
	    	Query query = session.createQuery("from QaVO order by id");
	    	list = query.list();
	    	session.getTransaction().commit();
	    	
	    }catch (RuntimeException ex){
	    	session.getTransaction().rollback();
	    	throw ex;
	 	   }
	    
	  	return list;
	}

}
