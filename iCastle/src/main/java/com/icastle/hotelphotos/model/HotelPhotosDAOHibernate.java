package com.icastle.hotelphotos.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.icastle.hotels.model.HotelVO;

import hibernate.util.HibernateUtil;

public class HotelPhotosDAOHibernate implements HotelPhotos_Interface{

	@Override
	public int addPhoto(List<HotelPhotosVO> photovos) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try {
			session.beginTransaction();
			
			for (HotelPhotosVO photovo : photovos){
				session.saveOrUpdate(photovo);
				count++;
			}
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return count;
	}

	@Override
	public int updatePhoto(List<HotelPhotosVO> photovos) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try {
			session.beginTransaction();
			
			for (HotelPhotosVO photovo : photovos){
				session.update(photovo);
				count++;
			}
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return count;
	}

	@Override
	public HotelPhotosVO findByPrimaryKey(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelPhotosVO photo = null;
		try {
			session.beginTransaction();
			photo = (HotelPhotosVO) session.get(HotelPhotosVO.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return photo;
	}

	@Override
	public HotelPhotosVO findByHotelIdTop1(Integer hotelId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		HotelPhotosVO photovo = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(
					"from HotelPhotosVO where hotelId=:hotelId and photoOrder = 1");
			query.setParameter("hotelId", hotelId);
			List<HotelPhotosVO> photos = query.list();
			photovo = (photos.size()==1) ? photos.get(0) : null;
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return photovo;
	}

	@Override
	public List<HotelPhotosVO> findByHotelId(Integer hotelId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HotelPhotosVO> photos = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(
					"from HotelPhotosVO where hotelId=:hotelId");
			query.setParameter("hotelId", hotelId);
			
			photos = query.list();
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return photos;
	}

	@Override
	public List<HotelPhotosVO> findByRoomTypeId(Integer roomTypeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HotelPhotosVO> photos = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(
					"from HotelPhotosVO where roomTypeId=:roomTypeId");
			query.setParameter("roomTypeId", roomTypeId);
			
			photos = query.list();
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return photos;
	}

	@Override
	public int deletePhoto(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try {
			session.beginTransaction();
			HotelPhotosVO photo = (HotelPhotosVO)session.get(HotelPhotosVO.class, id);
			session.delete(photo);
			count++;
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return count;
	}
}
