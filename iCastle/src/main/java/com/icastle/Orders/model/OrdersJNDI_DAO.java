package com.icastle.Orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdersJNDI_DAO implements OrdersDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/iCastleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "insert into orders(orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,orderState) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "update orders set orderState=? , memo=? , cancelDate=? where orderid=?";
	private static final String SELECT_BY_MEMBERID_STMT = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where memberId=?";
	private static final String SELECT_BY_ORDERID_STMT = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where orderId=?";
	private static final String SELECT_BY_HOTELID_YEAR = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?)";
	private static final String SELECT_BY_HOTELID_MONTH = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and (month(checkinDay)<=? and month(checkoutDay)>=?)";
	private static final String SELECT_BY_HOTELID_DAY = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and checkinDay<=? and checkoutDay>=?";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and roomtypeid=?";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and (month(checkinDay)<=? and month(checkoutDay)>=?) and roomtypeid=?";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and checkinDay<=? and checkoutDay>=? and roomtypeid=?";
	private static final String SELECT_BY_HOTELID_YEAR_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and orderstate=?";
	private static final String SELECT_BY_HOTELID_MONTH_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and (month(checkinDay)<=? and month(checkoutDay)>=?) and orderstate=?";
	private static final String SELECT_BY_HOTELID_DAY_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and checkinDay<=? and checkoutDay>=? and orderstate=?";
	private static final String SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and orderstate=? and roomtypeid=?";
	private static final String SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and (year(checkinDay)=? or year(checkoutDay)=?) and (month(checkinDay)<=? and month(checkoutDay)>=?) and orderstate=? and roomtypeid=?";
	private static final String SELECT_BY_HOTELID_DAY_ROOMTYPEID_ORDERSTATE = "select orderId,orderedDate,memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders where hotelId=? and checkinDay<=? and checkoutDay>=? and orderstate=? and roomtypeid=?";

	private static final String SELECT_ALL_STMT = "select orderId,orderedDate,memberId,roomId,hotelId,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,memo,orderState,cancelDate from orders";
	
	public void insert(OrdersVO ordersVO) {

		Connection conn = null;
		PreparedStatement pstat = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(INSERT_STMT);

			pstat.setTimestamp(1, ordersVO.getOrderedDate());
			pstat.setInt(2, ordersVO.getMemberId());
			pstat.setInt(3, ordersVO.getRoomId());
			pstat.setInt(4, ordersVO.getHotelId());
			pstat.setString(5, ordersVO.getHotelName());
			pstat.setInt(6, ordersVO.getRoomTypeId());
			pstat.setString(7, ordersVO.getRoomTypeName());
			pstat.setDate(8, ordersVO.getCheckinDay());
			pstat.setDate(9, ordersVO.getCheckoutDay());
			pstat.setInt(10, ordersVO.getRoomCount());
			pstat.setInt(11, ordersVO.getPeopleNum());
			pstat.setBoolean(12, ordersVO.getBreakfast());
			pstat.setBoolean(13, ordersVO.getDinner());
			pstat.setBoolean(14, ordersVO.getAfternoonTea());
			pstat.setInt(15, ordersVO.getPrice());
			pstat.setString(16, ordersVO.getReservationer());
			pstat.setDate(17, ordersVO.getBdate());
			pstat.setString(18, ordersVO.getTel());
			pstat.setString(19, ordersVO.getEmail());
			pstat.setString(20, ordersVO.getAddr());
			pstat.setString(21, ordersVO.getPersonId());
			pstat.setString(22, ordersVO.getCountry());
			pstat.setString(23, ordersVO.getPassport());
			pstat.setBoolean(24, ordersVO.getBedAdding());
			pstat.setInt(25, ordersVO.getPricePerPerson());
			pstat.setString(26, ordersVO.getCustomerRemark());
			pstat.setString(27, ordersVO.getHotelRemark());
			pstat.setBoolean(28, ordersVO.getOrderState());

			pstat.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(OrdersVO ordersVO) {

		Connection conn = null;
		PreparedStatement pstat = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(UPDATE_STMT);

			pstat.setBoolean(1, ordersVO.getOrderState());
			pstat.setString(2, ordersVO.getMemo());
			pstat.setTimestamp(3, ordersVO.getCancelDate());
			pstat.setInt(4, ordersVO.getOrderId());

			pstat.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public List<OrdersVO> select_by_memberId(Integer memberId, java.sql.Date today) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_MEMBERID_STMT);

			pstat.setInt(1, memberId);
			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public OrdersVO select_by_orderId(Integer orderId) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_ORDERID_STMT);

			pstat.setInt(1, orderId);
			rs = pstat.executeQuery();
			result = new OrdersVO();

			while (rs.next()) {
				result.setOrderId(rs.getInt("orderId"));
				result.setOrderedDate(rs.getTimestamp("orderedDate"));
				result.setMemberId(rs.getInt("memberId"));
				result.setRoomId(rs.getInt("roomId"));
				result.setHotelId(rs.getInt("hotelId"));
				result.setHotelName(rs.getString("hotelName"));
				result.setRoomTypeId(rs.getInt("roomTypeId"));
				result.setRoomTypeName(rs.getString("roomTypeName"));
				result.setCheckinDay(rs.getDate("checkinDay"));
				result.setCheckoutDay(rs.getDate("checkoutDay"));
				result.setRoomCount(rs.getInt("roomCount"));
				result.setPeopleNum(rs.getInt("peopleNum"));
				result.setBreakfast(rs.getBoolean("breakfast"));
				result.setDinner(rs.getBoolean("dinner"));
				result.setAfternoonTea(rs.getBoolean("afternoonTea"));
				result.setPrice(rs.getInt("price"));
				result.setReservationer(rs.getString("reservationer"));
				result.setBdate(rs.getDate("bdate"));
				result.setTel(rs.getString("tel"));
				result.setEmail(rs.getString("email"));
				result.setAddr(rs.getString("addr"));
				result.setPersonId(rs.getString("personId"));
				result.setCountry(rs.getString("country"));
				result.setPassport(rs.getString("passport"));
				result.setBedAdding(rs.getBoolean("bedAdding"));
				result.setPricePerPerson(rs.getInt("pricePerPerson"));
				result.setCustomerRemark(rs.getString("customerRemark"));
				result.setHotelRemark(rs.getString("hotelRemark"));
				result.setMemo(rs.getString("memo"));
				result.setOrderState(rs.getBoolean("orderState"));
				result.setCancelDate(rs.getTimestamp("cancelDate"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_all() {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_ALL_STMT);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year(Integer hotelId, Integer year) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_YEAR);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month(Integer hotelId, Integer year, Integer month) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_MONTH);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setInt(4, month);
			pstat.setInt(5, month);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day(Integer hotelId, Integer year, Integer month, Integer day) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_DAY);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			pstat.setInt(1, hotelId);
			pstat.setDate(2, checkDay);
			pstat.setDate(3, checkDay);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_YEAR_ROOMTYPEID);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setInt(4, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_MONTH_ROOMTYPEID);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setInt(4, month);
			pstat.setInt(5, month);
			pstat.setInt(6, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_DAY_ROOMTYPEID);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			pstat.setInt(1, hotelId);
			pstat.setDate(2, checkDay);
			pstat.setDate(3, checkDay);
			pstat.setInt(4, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_orderstate(Integer hotelId, Integer year, Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_YEAR_ORDERSTATE);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setBoolean(4, state);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_orderstate(Integer hotelId, Integer year, Integer month,
			Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_MONTH_ORDERSTATE);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setInt(4, month);
			pstat.setInt(5, month);
			pstat.setBoolean(6, state);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_orderstate(Integer hotelId, Integer year, Integer month, Integer day,
			Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_DAY_ORDERSTATE);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			pstat.setInt(1, hotelId);
			pstat.setDate(2, checkDay);
			pstat.setDate(3, checkDay);
			pstat.setBoolean(4, state);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_year_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_YEAR_ROOMTYPEID_ORDERSTATE);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setBoolean(4, state);
			pstat.setInt(5, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_month_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId,
			Integer year, Integer month, Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_MONTH_ROOMTYPEID_ORDERSTATE);
			pstat.setInt(1, hotelId);
			pstat.setInt(2, year);
			pstat.setInt(3, year);
			pstat.setInt(4, month);
			pstat.setInt(5, month);
			pstat.setBoolean(6, state);
			pstat.setInt(7, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersVO> select_by_hotelId_day_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year,
			Integer month, Integer day, Boolean state) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;

		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_HOTELID_DAY_ROOMTYPEID_ORDERSTATE);
			java.sql.Date checkDay = new java.sql.Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			pstat.setInt(1, hotelId);
			pstat.setDate(2, checkDay);
			pstat.setDate(3, checkDay);
			pstat.setBoolean(4, state);
			pstat.setInt(5, roomTypeId);

			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();

			while (rs.next()) {
				order = new OrdersVO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderedDate(rs.getTimestamp("orderedDate"));
				order.setMemberId(rs.getInt("memberId"));
				order.setRoomId(rs.getInt("roomId"));
				order.setHotelId(rs.getInt("hotelId"));
				order.setHotelName(rs.getString("hotelName"));
				order.setRoomTypeId(rs.getInt("roomTypeId"));
				order.setRoomTypeName(rs.getString("roomTypeName"));
				order.setCheckinDay(rs.getDate("checkinDay"));
				order.setCheckoutDay(rs.getDate("checkoutDay"));
				order.setRoomCount(rs.getInt("roomCount"));
				order.setPeopleNum(rs.getInt("peopleNum"));
				order.setBreakfast(rs.getBoolean("breakfast"));
				order.setDinner(rs.getBoolean("dinner"));
				order.setAfternoonTea(rs.getBoolean("afternoonTea"));
				order.setPrice(rs.getInt("price"));
				order.setReservationer(rs.getString("reservationer"));
				order.setBdate(rs.getDate("bdate"));
				order.setTel(rs.getString("tel"));
				order.setEmail(rs.getString("email"));
				order.setAddr(rs.getString("addr"));
				order.setPersonId(rs.getString("personId"));
				order.setCountry(rs.getString("country"));
				order.setPassport(rs.getString("passport"));
				order.setBedAdding(rs.getBoolean("bedAdding"));
				order.setPricePerPerson(rs.getInt("pricePerPerson"));
				order.setCustomerRemark(rs.getString("customerRemark"));
				order.setHotelRemark(rs.getString("hotelRemark"));
				order.setMemo(rs.getString("memo"));
				order.setOrderState(rs.getBoolean("orderState"));
				order.setCancelDate(rs.getTimestamp("cancelDate"));
				result.add(order);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year(Integer hotelId, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month(Integer hotelId, Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_roomtpyeId(Integer hotelId, Integer roomTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_roomtpyeId(Integer hotelId, Integer roomTypeId, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_roomtpyeId(Integer hotelId, Integer roomTypeId,
			Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_orderstate(Integer hotelId, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_orderstate(Integer hotelId, Boolean state, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_orderstate(Integer hotelId, Boolean state, Integer year,
			Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> chart_select_by_hotelId_year_month_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId,
			Boolean state, Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year(Integer hotelId, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_month(Integer hotelId, Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_orderstate(Integer hotelId, Boolean state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_orderstate(Integer hotelId, Boolean state,
			Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersChartVO> piechart_select_by_hotelId_year_month_orderstate(Integer hotelId, Boolean state,
			Integer year, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersVO> select_new_orders_by_memberId(Integer memberId, java.sql.Date today) {
		// TODO Auto-generated method stub
		return null;
	}

}