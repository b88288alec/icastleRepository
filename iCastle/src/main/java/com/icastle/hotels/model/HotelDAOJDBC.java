package com.icastle.hotels.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class HotelDAOJDBC{
//public class HotelDAOJDBC implements HotelDAO_Interface {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=i-Castle";
	private String sa = "sa";
	private String password = "sa123456";
//	
//	@Override
//	public HotelVO addHotel(HotelVO hotelVO) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		HotelVO hotel = null;
//		
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, sa, password);
//			String SQL_STMT = "insert into Hotels values(?,?,?,?,?,?,?,?,?,?)";
//			pStmt = conn.prepareStatement(SQL_STMT);
//			pStmt.setString(1, hotelVO.getHotelName());
//			pStmt.setString(2, hotelVO.getEmail());
//			pStmt.setString(3, hotelVO.getPw());
//			pStmt.setString(4, hotelVO.getAddr());
//			pStmt.setString(5, hotelVO.getZone());
//			pStmt.setFloat(6, 0);
//			pStmt.setInt(7, 0);
//			pStmt.setInt(8, hotelVO.getStar());
//			pStmt.setInt(9, 0);
//			pStmt.setString(10, hotelVO.getRegisterId());
//			
//			pStmt.executeUpdate();
//			
//			hotel = findByPrimaryKey(hotelVO.getHotelId());
//		} catch (ClassNotFoundException e){
//			e.printStackTrace();
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { pStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return hotel;
//	}
//
//	@Override
//	public int changePw(Integer hotelId, String pw) {
//		return 0;
//	}
//
//	@Override
//	public HotelVO updateState(Integer hotelId, Integer state) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		HotelVO hotel = null;
//		
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, sa, password);
//			String SQL_STMT = "update Hotels set hotelState=? where hotelId=?";
//			pStmt = conn.prepareStatement(SQL_STMT);
//			pStmt.setInt(1, hotelId);
//			pStmt.setInt(2, state);
//
//			pStmt.executeUpdate();
//			
//			hotel = findByPrimaryKey(hotelId);
//		} catch (ClassNotFoundException e){
//			e.printStackTrace();
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { pStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return null;
//	}
//
//	@Override
//	public HotelVO findByPrimaryKey(Integer hotelId) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		ResultSet rs = null;
//		HotelVO hotel = new HotelVO();
//		
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, sa, password);
//			String SQL_STMT = "select * from Hotels where hotelId = ?";
//			pStmt = conn.prepareStatement(SQL_STMT);
//			pStmt.setInt(1, hotelId);
//
//			rs = pStmt.executeQuery();
//			
//			while(rs.next()){
//				hotel.setHotelId(rs.getInt(1));
//				hotel.setHotelName(rs.getString(2));
//				hotel.setEmail(rs.getString(3));
//				hotel.setPw(rs.getString(4));
//				hotel.setAddr(rs.getString(5));
//				hotel.setZone(rs.getString(6));
//				hotel.setPoint(rs.getDouble(7));
//				hotel.setHot(rs.getInt(8));
//				hotel.setStar(rs.getInt(9));
//				hotel.setHotelState(rs.getInt(10));
//				hotel.setRegisterId(rs.getString(11));
//			}
//			
//		} catch (ClassNotFoundException e){
//			e.printStackTrace();
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { rs.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { pStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return hotel;
//	}
//	
//	@Override
//	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, Integer peopleNum) {
//		Connection conn = null;
//		CallableStatement cStmt = null;
//		ResultSet rs = null;
//		List<List> hotels = new ArrayList();
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, sa, password);
//			cStmt = conn.prepareCall("{call indexQuery(?,?,?,?)}");
//			cStmt.setEscapeProcessing(true);
//			cStmt.setQueryTimeout(90);
//			
//			cStmt.setString(1, zone);
//			cStmt.setDate(2, startDate);
//			cStmt.setDate(3, endDate);
//			cStmt.setInt(4, peopleNum);
//			
//			rs = cStmt.executeQuery();
//
//			while (rs.next()){
//				List hotel = new ArrayList();
//				hotel.add(rs.getInt(1));
//				hotel.add(rs.getString(2));
//				hotel.add(rs.getInt(3));
//				hotel.add(rs.getInt(4));
//				hotel.add(rs.getInt(5));
//				hotel.add(rs.getInt(6));
//				hotel.add(rs.getBoolean(7));
//				hotel.add(rs.getBoolean(8));
//				hotel.add(rs.getBoolean(9));
//				hotels.add(hotel);
//			}
//		} catch (ClassNotFoundException e){
//			e.printStackTrace();
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { rs.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { cStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return null;
//	}
//
//	@Override
//	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, Integer peopleNum, String order,
//			Integer lowprice, Integer highprice, double point, Integer star) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
