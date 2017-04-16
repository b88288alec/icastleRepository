package com.icastle.Orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdersJNDI_DAO implements OrdersDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/iCastleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "insert into orders(memberId,roomId,price,dates,roomNum,orderState,reservationer,bdate,tel,personId,email,country,addr,passport,bedAdding,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "update orders set orderState=? where orderid=?";
	private static final String SELECT_BY_MEMBERID_STMT = "select orderId,memberId,roomId,price,dates,roomNum,orderState,reservationer,bdate,tel,personId,email,country,addr,passport,bedAdding,remark from orders where memberId=?";
	private static final String SELECT_BY_ORDERID_STMT = "select orderId,memberId,roomId,price,dates,roomNum,orderState,reservationer,bdate,tel,personId,email,country,addr,passport,bedAdding,remark from orders where orderId=?";
	private static final String SELECT_ALL_STMT = "select orderId,memberId,roomId,price,dates,roomNum,orderState,reservationer,bdate,tel,personId,email,country,addr,passport,bedAdding,remark from orders";
	
	public void insert(OrdersVO ordersVO){
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		try{
			conn = ds.getConnection();
			pstat = conn.prepareStatement(INSERT_STMT);
			
			pstat.setInt(1, ordersVO.getMemberId());
			pstat.setInt(2, ordersVO.getRoomId());
			pstat.setInt(3, ordersVO.getPrice());
			pstat.setInt(4, ordersVO.getDates());
			pstat.setInt(5, ordersVO.getRoomNum());
			pstat.setBoolean(6, ordersVO.getOrderState());
			pstat.setString(7, ordersVO.getReservationer());
			pstat.setDate(8, ordersVO.getBdate());
			pstat.setString(9, ordersVO.getTel());
			pstat.setString(10, ordersVO.getPersonId());
			pstat.setString(11, ordersVO.getEmail());
			pstat.setString(12, ordersVO.getCountry());
			pstat.setString(13, ordersVO.getAddr());
			pstat.setString(14, ordersVO.getPassport());
			pstat.setBoolean(15, ordersVO.getBedAdding());
			pstat.setString(16, ordersVO.getRemark());
			
			pstat.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		try{
			conn = ds.getConnection();
			pstat = conn.prepareStatement(UPDATE_STMT);
			
			pstat.setBoolean(1, ordersVO.getOrderState());
			pstat.setInt(2, ordersVO.getOrderId());
			
			pstat.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public List<OrdersVO> select_by_memberId(Integer memberId) {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		OrdersVO order = null;
		List<OrdersVO> result = null;
		
		try{
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_MEMBERID_STMT);
			
			pstat.setInt(1, memberId);
			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();
			
			while(rs.next()){
				order = new OrdersVO();
				order.setOrderId(rs.getInt(1));
				order.setMemberId(rs.getInt(2));
				order.setRoomId(rs.getInt(3));
				order.setPrice(rs.getInt(4));
				order.setDates(rs.getInt(5));
				order.setRoomNum(rs.getInt(6));
				order.setOrderState(rs.getBoolean(7));
				order.setReservationer(rs.getString(8));
				order.setBdate(rs.getDate(9));
				order.setTel(rs.getString(10));
				order.setPersonId(rs.getString(11));
				order.setEmail(rs.getString(12));
				order.setCountry(rs.getString(13));
				order.setAddr(rs.getString(14));
				order.setPassport(rs.getString(15));
				order.setBedAdding(rs.getBoolean(16));
				order.setRemark(rs.getString(17));
				result.add(order);
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		try{
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_BY_ORDERID_STMT);
			
			pstat.setInt(1, orderId);
			rs = pstat.executeQuery();
			result = new OrdersVO();
			
			while(rs.next()){
				result.setOrderId(rs.getInt(1));
				result.setMemberId(rs.getInt(2));
				result.setRoomId(rs.getInt(3));
				result.setPrice(rs.getInt(4));
				result.setDates(rs.getInt(5));
				result.setRoomNum(rs.getInt(6));
				result.setOrderState(rs.getBoolean(7));
				result.setReservationer(rs.getString(8));
				result.setBdate(rs.getDate(9));
				result.setTel(rs.getString(10));
				result.setPersonId(rs.getString(11));
				result.setEmail(rs.getString(12));
				result.setCountry(rs.getString(13));
				result.setAddr(rs.getString(14));
				result.setPassport(rs.getString(15));
				result.setBedAdding(rs.getBoolean(16));
				result.setRemark(rs.getString(17));
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		try{
			conn = ds.getConnection();
			pstat = conn.prepareStatement(SELECT_ALL_STMT);
			
			rs = pstat.executeQuery();
			result = new ArrayList<OrdersVO>();
			
			while(rs.next()){
				order = new OrdersVO();
				order.setOrderId(rs.getInt(1));
				order.setMemberId(rs.getInt(2));
				order.setRoomId(rs.getInt(3));
				order.setPrice(rs.getInt(4));
				order.setDates(rs.getInt(5));
				order.setRoomNum(rs.getInt(6));
				order.setOrderState(rs.getBoolean(7));
				order.setReservationer(rs.getString(8));
				order.setBdate(rs.getDate(9));
				order.setTel(rs.getString(10));
				order.setPersonId(rs.getString(11));
				order.setEmail(rs.getString(12));
				order.setCountry(rs.getString(13));
				order.setAddr(rs.getString(14));
				order.setPassport(rs.getString(15));
				order.setBedAdding(rs.getBoolean(16));
				order.setRemark(rs.getString(17));
				result.add(order);
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	
}