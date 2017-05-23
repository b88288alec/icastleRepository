package com.icastle.members.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



import hibernate.util.HibernateUtil;

public class MembersHibernateDAO implements MembersDAO_interface{

	@Override
	public void insert(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(membersVO);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public void update(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(membersVO);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public MembersVO findByPrimaryKey(String email) {
		MembersVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery("from MembersVO where email = :email");
			query.setParameter("email", email);
			List<MembersVO> list = query.list();
			if(list.size() != 0){
				result = list.get(0);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<MembersVO> getAll() {
		 List<MembersVO> list = null;
		    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    try{
		    	session.beginTransaction();
		    	Query query = session.createQuery("from MembersVO");
		    	list = query.list();
		    	session.getTransaction().commit();
		    	
		    }catch (RuntimeException e){
		    	session.getTransaction().rollback();
		    	throw e;
		 	   }
		    
		  	return list;
		}


	@Override
	public MembersVO login(String email, String pw) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		MembersVO member = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from MembersVO where email=:email and pw=:pw");
			query.setParameter("email", email);
			query.setParameter("pw", pw);
			List<MembersVO> list = query.list();
			member = (list.size()==1) ? list.get(0) : null;
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return member;
	}

	@Override
	public MembersVO findByEmail(String email) {
		MembersVO member = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery("from MembersVO where email = :email");
			query.setParameter("email", email);
			List<MembersVO> list = query.list();
			if(list.size() != 0){
				member = list.get(0);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return member;
	}

	@Override
	public MembersVO lineLogin(String name, String pw) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		MembersVO member = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from MembersVO where name=:name and pw=:pw");
			query.setParameter("name", name);
			query.setParameter("pw", pw);
			List<MembersVO> list = query.list();
			member = (list.size()==1) ? list.get(0) : null;
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return member;
	}

	@Override
	public List<MembersVO> search_by_name(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembersVO> search_manager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void suspension(Integer memberId, Boolean suspension) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setManager(Integer memberId, Boolean manager) {
		// TODO Auto-generated method stub
		
	}

}
