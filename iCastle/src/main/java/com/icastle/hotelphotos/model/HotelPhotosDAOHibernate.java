package com.icastle.hotelphotos.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.icastle.hotels.model.HotelVO;

import hibernate.util.HibernateUtil;

public class HotelPhotosDAOHibernate implements HotelPhotos_Interface{

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

	
}
