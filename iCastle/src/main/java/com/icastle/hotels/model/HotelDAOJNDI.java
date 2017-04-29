package com.icastle.hotels.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class HotelDAOJNDI  {
//public class HotelDAOJNDI implements HotelDAO_Interface {
	private static DataSource ds = null;
	static {
	     try {
	          Context context = new InitialContext();
	                 // "java:comp/env/" + 連線池名稱 (在context.xml)
	          ds = (DataSource) context.lookup("java:comp/env/jdbc/iCastleDB");
	     } catch (NamingException e) {
	          e.printStackTrace();
	     }
	}
//	
//	@Override
//	public HotelVO addHotel(HotelVO hotelVO) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		
//		try{
//			conn = ds.getConnection();
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
//			
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { pStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return hotelVO;
//	}
//
//	@Override
//	public int changePw(Integer hotelId, String pw) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		HotelVO hotel = null;
//		int count = 0;
//		
//		try{
//			conn = ds.getConnection();
//			String SQL_STMT = "update Hotels set pw = ?  where hotelId=?";
//			pStmt = conn.prepareStatement(SQL_STMT);
//			pStmt.setString(1, pw);
//			pStmt.setInt(2, hotelId);
//
//			count = pStmt.executeUpdate();
//			
//		} catch (SQLException e){
//			e.printStackTrace();			
//		} finally {
//			try { pStmt.close();
//			} catch (SQLException e) {e.printStackTrace();}
//			try { conn.close();
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		return count;
//	}
//
//	@Override
//	public HotelVO updateState(Integer hotelId, Integer state) {
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		HotelVO hotel = null;
//		
//		try{
//			conn = ds.getConnection();
//			String SQL_STMT = "update Hotels set hotelState=? where hotelId=?";
//			pStmt = conn.prepareStatement(SQL_STMT);
//			pStmt.setInt(1, state);
//			pStmt.setInt(2, hotelId);
//
//			pStmt.executeUpdate();
//			
//			hotel = findByPrimaryKey(hotelId);
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
//			conn = ds.getConnection();
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
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, Integer peopleNum) {
		Connection conn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		List<ListVO> hotels = new ArrayList<ListVO>();
		try{
			conn = ds.getConnection();
			cStmt = conn.prepareCall("{call indexQuery(?,?,?,?)}");
			cStmt.setEscapeProcessing(true);
			cStmt.setQueryTimeout(90);
			
			cStmt.setString(1, zone);
			cStmt.setDate(2, startDate);
			cStmt.setDate(3, endDate);
			cStmt.setInt(4, peopleNum);
			
			rs = cStmt.executeQuery();

			while (rs.next()){
				ListVO hotel = new ListVO();
				hotel.setHotelId(rs.getInt(1));
				hotel.setHotelName(rs.getString(2));
				hotel.setPrice(rs.getInt(3));
				hotel.setStar(rs.getInt(4));
				hotel.setPoint(rs.getDouble(5));
				hotel.setHot(rs.getInt(6));
				hotel.setBreakfast(rs.getBoolean(7));
				hotel.setDinner(rs.getBoolean(8));
				hotel.setRoomWifi(rs.getBoolean(9));
				hotels.add(hotel);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		} finally {
			try { rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			try { cStmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			try { conn.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		return hotels;
	}
//
//	@Override
//	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate
//			, Integer peopleNum, String order, Integer lowprice, Integer highprice, double point, Integer star) {
//		Connection conn = null;
//		CallableStatement cStmt = null;
//		ResultSet rs = null;
//		List<ListVO> hotels = new ArrayList<ListVO>();
//		try{
//			conn = ds.getConnection();
//			cStmt = conn.prepareCall("{call advanceQuery(?,?,?,?,?,?,?,?,?)}");
//			cStmt.setEscapeProcessing(true);
//			cStmt.setQueryTimeout(90);
//			
//			cStmt.setString(1, zone);
//			cStmt.setDate(2, startDate);
//			cStmt.setDate(3, endDate);
//			cStmt.setInt(4, peopleNum);
//			cStmt.setString(5, order);
//			cStmt.setInt(6, lowprice);
//			cStmt.setInt(7, highprice);
//			cStmt.setDouble(8, point);
//			cStmt.setInt(9, star);
//			
//			rs = cStmt.executeQuery();
//
//			while (rs.next()){
//				ListVO hotel = new ListVO();
//				hotel.setHotelId(rs.getInt(1));
//				hotel.setHotelName(rs.getString(2));
//				hotel.setPrice(rs.getInt(3));
//				hotel.setStar(rs.getInt(4));
//				hotel.setPoint(rs.getDouble(5));
//				hotel.setHot(rs.getInt(6));
//				hotel.setBreakfast(rs.getBoolean(7));
//				hotel.setDinner(rs.getBoolean(8));
//				hotel.setRoomWifi(rs.getBoolean(9));
//				hotels.add(hotel);
//			}
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
//		return hotels;
//	}
}
