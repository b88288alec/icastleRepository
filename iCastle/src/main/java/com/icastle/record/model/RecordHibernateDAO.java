package com.icastle.record.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.icastle.roomtype.model.RoomTypeVO;

import hibernate.util.HibernateUtil;

public class RecordHibernateDAO implements RecordDAO_interface {

	private static final String SELECT_BY_ID = "from RecordVO where id = :id order by recordTime desc";
	private static final String SELECT_BY_NAME = "from RecordVO where name like :name order by recordTime desc";
	private static final String SELECT_BY_ROOMTYPEID = "from RecordVO where roomTypeId = :id order by recordTime desc";
	
	@Override
	public void managerRecord(RecordVO record) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.save(record);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<RecordVO> select_by_id(String id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<RecordVO> result = null;
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter("id", id);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<RecordVO> select_by_name(String name) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<RecordVO> result = null;
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_NAME);
			query.setParameter("name", name);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void hotelRecord(List<RecordVO> recordList) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			for(RecordVO vo : recordList){
				session.saveOrUpdate(vo);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<RecordVO> select_by_roomTypeId(Integer roomTypeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<RecordVO> result = null;
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ROOMTYPEID);
			query.setParameter("id", roomTypeId);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

}
