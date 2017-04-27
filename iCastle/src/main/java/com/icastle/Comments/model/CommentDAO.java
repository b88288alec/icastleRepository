package com.icastle.Comments.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements CommentDAO_interface {
	private static final String INS_COMT = "INSERT INTO Comments(orderId,hotelId,avgScore,serviceScore,qualityScore,sceneScore,comment) VALUES(?,?,?,?,?,?,?)";
	private static final String SHOW_COMT = "SELECT avgScore,serviceScore,qualityScore,sceneScore,good,comment FROM Comments WHERE orderId = ?";
	private static final String SEL_HOTELID = "SELECT commentId,orderId,hotelId,avgScore,serviceScore,qualityScore,sceneScore,good,comment FROM Comments WHERE hotelId = ?";
	private static final String HOST_RESPONSE = "UPDATE Comments SET response = ? WHERE commentId = ?";
	private static final String SHOW_RESPONSE = "SELECT response FROM Comments WHERE commentId = ?";
	private static final String UPD_COMT = "UPDATE Comments SET avgScore = ?,serviceScore = ?,qualityScore = ?,sceneScore =?,comment=? where Comment id = ?";
	private static final String GOOD_COMT = "UPDATE Comments SET good = ? WHERE commentId = ?";
	private static final String SHOW_GOOD = "SELECT good FROM Comments WHERE commentId = ?";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=i-Castle";
	private String user = "sa";
	private String password = "sa123456";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs; 
	CommentVO com;
	CommentDAO commt;
	List<CommentVO> comtList = new ArrayList<CommentVO>();
	
	public CommentVO comtIns(CommentVO comt){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(INS_COMT);
			stmt.setInt(1,comt.getOrderId());
			stmt.setInt(2,comt.getHotelId());
			stmt.setDouble(3,(comt.getServiceScore()+comt.getSceneScore()+comt.getQualityScore())/3.0);
			stmt.setInt(4,comt.getServiceScore());
			stmt.setInt(5,comt.getQualityScore());
			stmt.setInt(6,comt.getSceneScore());
			stmt.setString(7,comt.getComment());
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SHOW_COMT);
			stmt.setInt(1, comt.getOrderId());
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setAvgScore(rs.getDouble("avgScore"));
			com.setServiceScore(rs.getInt("serviceScore"));
			com.setQualityScore(rs.getInt("qualityScore"));
			com.setSceneScore(rs.getInt("sceneScore"));
			com.setGood(rs.getInt("good"));
			com.setComment(rs.getString("comment"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return com;
		
	}
	
	public List<CommentVO> hotelComtSearch(Integer hotelId){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(SEL_HOTELID);
			stmt.setInt(1, hotelId);
			rs = stmt.executeQuery();
			while(rs.next()){
				
			com = new CommentVO();
			com.setCommentId(rs.getInt("commentId"));
			com.setOrderId(rs.getInt("orderId"));
			com.setHotelId(rs.getInt("hotelId"));
			com.setAvgScore(rs.getDouble("avgScore"));
			com.setServiceScore(rs.getInt("serviceScore"));
			com.setQualityScore(rs.getInt("qualityScore"));
			com.setSceneScore(rs.getInt("sceneScore"));
			com.setGood(rs.getInt("good"));
			com.setComment(rs.getString("comment"));
			comtList.add(com);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return comtList;
			
	}
	
	public CommentVO response(Integer commentId,String response){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(HOST_RESPONSE);
			stmt.setString(1,response);
			stmt.setInt(2, commentId);
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SHOW_RESPONSE);
			stmt.setInt(1,commentId);
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setResponse(rs.getString("response"));
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return com;
		
	}
	
	public CommentVO comUpdate(CommentVO comt){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(UPD_COMT);
			stmt.setDouble(1,comt.getSceneScore()+comt.getQualityScore()+comt.getServiceScore());
            stmt.setInt(2,comt.getServiceScore());
            stmt.setInt(3,comt.getQualityScore());
            stmt.setInt(4,comt.getSceneScore());
            stmt.setString(5,comt.getComment());
            stmt.setInt(6,comt.getCommentId());
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement(SHOW_COMT);
			stmt.setInt(1, comt.getOrderId());
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setAvgScore(rs.getDouble("avgScore"));
			com.setServiceScore(rs.getInt("serviceScore"));
			com.setQualityScore(rs.getInt("qualityScore"));
			com.setSceneScore(rs.getInt("sceneScore"));
			com.setGood(rs.getInt("good"));
			com.setComment(rs.getString("comment"));
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return com;
		
	}
	
	public CommentVO pressGood(Integer commentId,Integer good){
		

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(GOOD_COMT);
			stmt.setInt(1, good);
			stmt.setInt(2, commentId);
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(GOOD_COMT);
			stmt.setInt(1,good);
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setGood(rs.getInt("good"));
				
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return com;
		
		
	}
} 






