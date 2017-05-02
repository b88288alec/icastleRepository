package com.icastle.hotelInfo.modle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class InfoJNDIDAO implements InfoDAO_interface{
	//一個資料庫 ,共用一個DataSource
	private static DataSource ds = null;
	static {
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/iCastle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
	  "INSERT INTO HotelInfo (hotelId,registerName,tel,transport,website,hotelProfile,checkin,checkout,GuestPolicies,cancelPolicies"
	  + ",roomWifi,hallWifi,internet,mineralWater,toiletUtensils,hairDryer,tv,gameRoom,gym,spa,swimPool) "
	  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_STMT = 
			"select * from HotelInfo where hotelId = ?";
	private static final String UPDATE = 
	  "UPDATE HotelInfo set registerName = ? ,tel = ? ,transport = ? ,website = ? ,hotelProfile = ? ,checkin = ? ,"
	  + "checkout = ? ,GuestPolicies = ? ,cancelPolicies = ? ,roomWifi = ? ,hallWifi = ? ,internet = ? ,mineralWater = ? ,"
	  + "toiletUtensils = ? ,hairDryer = ? ,tv = ? ,gameRoom = ? ,gym = ? ,spa = ? ,swimPool = ? where hotelId = ?";

	@Override
	public void insert(InfoVO infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, infoVO.getHotelId());
			pstmt.setString(2, infoVO.getRegisterName());
			pstmt.setString(3, infoVO.getTel());
			pstmt.setString(4, infoVO.getTransport());
			pstmt.setString(5, infoVO.getWebsite() );
			pstmt.setString(6, infoVO.getHotelProfile() );
			pstmt.setString(7, infoVO.getCheckin() );
			pstmt.setString(8, infoVO.getCheckout() );
			pstmt.setString(9, infoVO.getGuestPolicies() );
			pstmt.setString(10, infoVO.getCancelPolicies() );
			pstmt.setBoolean(11, infoVO.isRoomWifi());
			pstmt.setBoolean(12, infoVO.isHallWifi() );
			pstmt.setBoolean(13, infoVO.isInternet() );
			pstmt.setBoolean(14, infoVO.isMineralWater() );
			pstmt.setBoolean(15, infoVO.isToiletUtensils() );
			pstmt.setBoolean(16, infoVO.isHairDryer() );
			pstmt.setBoolean(17, infoVO.isTv() );
			pstmt.setBoolean(18, infoVO.isGameRoom() );
			pstmt.setBoolean(19, infoVO.isGym() );
			pstmt.setBoolean(20, infoVO.isSpa() );
			pstmt.setBoolean(21, infoVO.isSwimPool() );		
			
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A datasource error occured" +
						se.getMessage());
		} finally {
			if (pstmt != null){
				try{
					pstmt.close();
				}catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null){
				try{
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateHotelInfo(InfoVO infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, infoVO.getRegisterName());
			pstmt.setString(2, infoVO.getTel());
			pstmt.setString(3, infoVO.getTransport());
			pstmt.setString(4, infoVO.getWebsite());
			pstmt.setString(5, infoVO.getCheckin());
			pstmt.setString(6, infoVO.getCheckout());
			pstmt.setString(7, infoVO.getGuestPolicies());
			pstmt.setString(8, infoVO.getCancelPolicies());
			pstmt.setString(9, infoVO.getCancelPolicies() );
			pstmt.setBoolean(10, infoVO.isRoomWifi());
			pstmt.setBoolean(11, infoVO.isHallWifi() );
			pstmt.setBoolean(12, infoVO.isInternet() );
			pstmt.setBoolean(13, infoVO.isMineralWater() );
			pstmt.setBoolean(14, infoVO.isToiletUtensils() );
			pstmt.setBoolean(15, infoVO.isHairDryer() );
			pstmt.setBoolean(16, infoVO.isTv() );
			pstmt.setBoolean(17, infoVO.isGameRoom() );
			pstmt.setBoolean(18, infoVO.isGym() );
			pstmt.setBoolean(19, infoVO.isSpa() );
			pstmt.setBoolean(20, infoVO.isSwimPool() );
			pstmt.setInt(21, infoVO.getHotelId());
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null){
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public InfoVO findByHotelId(Integer hotelId) {
		InfoVO infoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_STMT);
			
			pstmt.setInt(1, hotelId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				infoVO = new InfoVO();
				infoVO.setHotelId(rs.getInt("hotelId"));
				infoVO.setRegisterName(rs.getString("registerName"));
				infoVO.setTel(rs.getString("tel"));
				infoVO.setTransport(rs.getString("transport"));
				infoVO.setWebsite(rs.getString("website"));
				infoVO.setHotelProfile(rs.getString("HotelProfile"));
				infoVO.setCheckin(rs.getString("checkin"));
				infoVO.setCheckout(rs.getString("checkout"));
				infoVO.setGuestPolicies(rs.getString("guestPolicies"));
				infoVO.setCancelPolicies(rs.getString("cancelPolicies"));
				infoVO.setRoomWifi(rs.getBoolean("roomWifi"));
				infoVO.setHallWifi(rs.getBoolean("hallWifi"));
				infoVO.setInternet(rs.getBoolean("internet"));
				infoVO.setMineralWater(rs.getBoolean("mineralWater"));
				infoVO.setToiletUtensils(rs.getBoolean("toiletUtensils"));
				infoVO.setHairDryer(rs.getBoolean("hairDryer"));
				infoVO.setTv(rs.getBoolean("tv"));
				infoVO.setGameRoom(rs.getBoolean("gameRoom"));
				infoVO.setGym(rs.getBoolean("gym"));
				infoVO.setSpa(rs.getBoolean("spa"));
				infoVO.setSwimPool(rs.getBoolean("swimPool"));
				}
				
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
				if (rs != null){
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null){
					try{
						pstmt.close();
					}catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null){
					try {
						con.close();
					}catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		return infoVO;
	}

}
