package com.icastle.Orders.model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class OrdersHibernateDAO implements OrdersDAO_interface{
	
	private static final String SELECT_BY_MEMBERID = "from OrdersVO where memberId = :memberId and (checkinDay < :today or cancelDate is not null) order by checkinDay desc";
	private static final String SELECT_NEW_ORDER_BY_MEMBERID = "from OrdersVO where memberId = :memberId and checkinDay >= :today and cancelDate is null order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_YEAR = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_MONTH = "from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_DAY = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>:checkoutDay order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and roomtypeid=:roomTypeId order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and roomtypeid=:roomTypeId order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>:checkoutDay and roomtypeid=:roomTypeId order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_YEAR_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_MONTH_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and ((checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout)) and orderstate=:orderstate order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_DAY_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>:checkoutDay and orderstate=:orderstate order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate and roomtypeid=:roomTypeId order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and orderstate=:orderstate and roomtypeid=:roomTypeId order by checkinDay desc";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID_ORDERSTATE = "from OrdersVO where hotelId=:hotelId and checkinDay<=:checkinDay and checkoutDay>:checkoutDay and orderstate=:orderstate and roomtypeid=:roomTypeId order by checkinDay desc";
	
	private static final String CHART_SELECT_BY_HOTELID = "select year(checkinDay),count(*) from OrdersVO where hotelId=:hotelId group by year(checkinDay) order by year(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_YEAR = "select month(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) group by month(checkinDay) order by month(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_MONTH = "select day(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) group by day(checkinDay) order by day(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_ROOMTYPEID = "select year(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and roomtypeid=:roomTypeId group by year(checkinDay) order by year(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_YEAR_ROOMTYPEID = "select month(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and roomtypeid=:roomTypeId group by month(checkinDay) order by month(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_MONTH_ROOMTYPEID = "select day(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and roomtypeid=:roomTypeId group by day(checkinDay) order by day(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_ORDERSTATE = "select year(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and orderstate=:orderstate group by year(checkinDay) order by year(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_YEAR_ORDERSTATE = "select month(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate group by month(checkinDay) order by month(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_MONTH_ORDERSTATE = "select day(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and orderstate=:orderstate group by day(checkinDay) order by day(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_ROOMTYPEID_ORDERSTATE = "select year(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and orderstate=:orderstate and roomtypeid=:roomTypeId group by year(checkinDay) order by year(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE = "select month(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate and roomtypeid=:roomTypeId group by month(checkinDay) order by month(checkinDay)";
	private static final String CHART_SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE = "select day(checkinDay),count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and orderstate=:orderstate and roomtypeid=:roomTypeId group by day(checkinDay) order by day(checkinDay)";
	
	private static final String PIECHART_SELECT_BY_HOTELID = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId group by roomTypeName";
	private static final String PIECHART_SELECT_BY_HOTELID_YEAR = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) group by roomTypeName";
	private static final String PIECHART_SELECT_BY_HOTELID_MONTH = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) group by roomTypeName";
	private static final String PIECHART_SELECT_BY_HOTELID_ORDERSTATE = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId and orderstate=:orderstate group by roomTypeName";
	private static final String PIECHART_SELECT_BY_HOTELID_YEAR_ORDERSTATE = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId and (year(checkinDay)=:yearin or year(checkoutDay)=:yearout) and orderstate=:orderstate group by roomTypeName";
	private static final String PIECHART_SELECT_BY_HOTELID_MONTH_ORDERSTATE = "select roomTypeName,count(*) from OrdersVO where hotelId=:hotelId and (checkinDay between :Imonthin and :Imonthout or checkoutDay between :Omonthin and :Omonthout) and orderstate=:orderstate group by roomTypeName";
	
	@Override
	public void insert(OrdersVO ordersVO) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.getTransaction();
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
	public List<OrdersVO> select_by_memberId(Integer memberId, java.sql.Date today) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MEMBERID);
			query.setParameter("memberId", memberId);
			query.setParameter("today", today);
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
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(SELECT_BY_HOTELID_MONTH);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
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
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			query.setParameter("hotelId", hotelId);
			query.setParameter("checkinDay", checkDay);
			query.setParameter("checkoutDay", checkDay);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_YEAR_ROOMTYPEID);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("roomTypeId", roomTypeId);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(SELECT_BY_HOTELID_MONTH_ROOMTYPEID);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("roomTypeId", roomTypeId);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_DAY_ROOMTYPEID);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			query.setParameter("hotelId", hotelId);
			query.setParameter("checkinDay", checkDay);
			query.setParameter("checkoutDay", checkDay);
			query.setParameter("roomTypeId", roomTypeId);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_orderstate(Integer hotelId, Integer year, Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_YEAR_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_orderstate(Integer hotelId, Integer year, Integer month,
			Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(SELECT_BY_HOTELID_MONTH_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_orderstate(Integer hotelId, Integer year, Integer month, Integer day,
			Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_DAY_ORDERSTATE);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			query.setParameter("hotelId", hotelId);
			query.setParameter("checkinDay", checkDay);
			query.setParameter("checkoutDay", checkDay);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Integer month, Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day, Boolean state) {

		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_HOTELID_DAY_ROOMTYPEID_ORDERSTATE);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			query.setParameter("hotelId", hotelId);
			query.setParameter("checkinDay", checkDay);
			query.setParameter("checkoutDay", checkDay);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_all() {
		
		List<OrdersVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery("from OrdersVO");
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

//	圖表用方法
	@Override
	public List<OrdersChartVO> chart_select_by_hotelId(Integer hotelId) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID);
			query.setParameter("hotelId", hotelId);
			middle = query.list();			
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List chart_select_by_hotelId_year(Integer hotelId, Integer year) {

		List result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_YEAR);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month(Integer hotelId, Integer year, Integer month) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_MONTH);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_roomtpyeId(Integer hotelId, Integer roomTypeId) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_ROOMTYPEID);
			query.setParameter("hotelId", hotelId);
			query.setParameter("roomTypeId", roomTypeId);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_roomtpyeId(Integer hotelId, Integer roomTypeId, Integer year) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_YEAR_ROOMTYPEID);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("roomTypeId", roomTypeId);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_roomtpyeId(Integer hotelId, Integer roomTypeId,
			Integer year, Integer month) {
		
		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_MONTH_ROOMTYPEID);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("roomTypeId", roomTypeId);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_orderstate(Integer hotelId, Boolean state) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_orderstate(Integer hotelId, Boolean state, Integer year) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_YEAR_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_orderstate(Integer hotelId, Boolean state, Integer year,
			Integer month) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_MONTH_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_ROOMTYPEID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state, Integer year) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state, Integer year, Integer month) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(CHART_SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("roomTypeId", roomTypeId);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue(String.valueOf((Integer)ob[0]));
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId(Integer hotelId) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID);
			query.setParameter("hotelId", hotelId);
			middle = query.list();			
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year(Integer hotelId, Integer year) {

		List result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID_YEAR);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_month(Integer hotelId, Integer year, Integer month) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID_MONTH);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_orderstate(Integer hotelId, Boolean state) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_orderstate(Integer hotelId, Boolean state,
			Integer year) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID_YEAR_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("yearin", year);
			query.setParameter("yearout", year);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_month_orderstate(Integer hotelId, Boolean state,
			Integer year, Integer month) {

		List<OrdersChartVO> result = new LinkedList<OrdersChartVO>();
		List middle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			String in = year + "/" + month + "/" + "1";
			String inout = year + "/" + month + "/" + "2";
			String out =  year + "/" + (month+1) + "/" + "0";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date monthin = null;
			java.sql.Date monthinout = null;
			java.sql.Date monthout = null;
			try {
				monthin = new java.sql.Date(sdf.parse(in).getTime());
				monthinout = new java.sql.Date(sdf.parse(inout).getTime());
				monthout = new java.sql.Date(sdf.parse(out).getTime());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			Query query = session.createQuery(PIECHART_SELECT_BY_HOTELID_MONTH_ORDERSTATE);
			query.setParameter("hotelId", hotelId);
			query.setParameter("Imonthin", monthin);
			query.setParameter("Imonthout", monthout);
			query.setParameter("Omonthin", monthinout);
			query.setParameter("Omonthout", monthout);
			query.setParameter("orderstate", state);
			middle = query.list();
			for(int i = 0; i < middle.size(); i++){
				OrdersChartVO oc = new OrdersChartVO();
				Object[] ob = (Object[])middle.get(i);
				oc.setValue((String)ob[0]);
				oc.setCount((long)ob[1]);
				
				result.add(oc);
			}
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_new_orders_by_memberId(Integer memberId, java.sql.Date today) {

		List<OrdersVO> result = new LinkedList<OrdersVO>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_NEW_ORDER_BY_MEMBERID);
			query.setParameter("memberId", memberId);
			query.setParameter("today", today);
			result = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}
		
		return result;
	}

}
