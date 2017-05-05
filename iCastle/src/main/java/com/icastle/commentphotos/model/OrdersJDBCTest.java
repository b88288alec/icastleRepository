package com.icastle.commentphotos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icastle.Orders.model.OrdersVO;

public class OrdersJDBCTest {
	
	private final String SEL_ORDERID = "select * from Orders where orderId = ?";
	
	OrdersVO ordervo;
	Connection conn;
	
	public OrdersVO findByOrderId(int orderId){
		
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		    conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iCastle","sa","sa123456");
			PreparedStatement stmt = conn.prepareStatement(SEL_ORDERID);
			stmt.setInt(1,orderId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
		    ordervo = new OrdersVO();
			ordervo.setOrderId(rs.getInt("orderId"));
			ordervo.setOrderedDate(rs.getTimestamp("orderedDate"));
			ordervo.setMemberId(rs.getInt("memberId"));
			ordervo.setRoomId(rs.getInt("roomId"));
			ordervo.setHotelId(rs.getInt("hotelId"));
			ordervo.setHotelName(rs.getString("hotelName"));
			ordervo.setRoomTypeId(rs.getInt("roomTypeId"));
			ordervo.setRoomTypeName(rs.getString("roomTypeName"));
			ordervo.setCheckinDay(rs.getDate("checkinDay"));
			ordervo.setCheckoutDay(rs.getDate("checkoutDay"));
			ordervo.setCheckoutDay(rs.getDate("checkoutDay"));
			ordervo.setRoomCount(rs.getInt("roomCount"));
			ordervo.setPeopleNum(rs.getInt("peopleNum"));
			ordervo.setBreakfast(rs.getBoolean("breakfast"));
			ordervo.setDinner(rs.getBoolean("dinner"));
			ordervo.setAfternoonTea(rs.getBoolean("afternoonTea"));
			ordervo.setAfternoonTea(rs.getBoolean("afternoonTea"));
			ordervo.setAfternoonTea(rs.getBoolean("afternoonTea"));
			ordervo.setPrice(rs.getInt("price"));
			ordervo.setRoomNo(rs.getString("roomNo"));
			ordervo.setReservationer(rs.getString("reservationer"));
			ordervo.setBdate(rs.getDate("bdate"));
			ordervo.setTel(rs.getString("tel"));
			ordervo.setEmail(rs.getString("email"));
			ordervo.setAddr(rs.getString("addr"));
			ordervo.setPersonId(rs.getString("personId"));
			ordervo.setCountry(rs.getString("country"));
			ordervo.setPassport(rs.getString("passport"));
			ordervo.setBedAdding(rs.getBoolean("bedAdding"));
			ordervo.setPricePerPerson(rs.getInt("pricePerPerson"));
			ordervo.setCustomerRemark(rs.getString("customerRemark"));
			ordervo.setHotelRemark(rs.getString("hotelRemark"));
			ordervo.setMemo(rs.getString("memo"));
			ordervo.setOrderState(rs.getBoolean("orderState"));
			ordervo.setCancelDate(rs.getTimestamp("cancelDate"));
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ordervo;
		
	}

}
