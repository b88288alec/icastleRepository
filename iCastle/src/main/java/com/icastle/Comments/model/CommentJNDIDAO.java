package com.icastle.Comments.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommentJNDIDAO implements CommentDAO_interface {
	private static final String INS_COMT = "INSERT INTO Comments(orderId,hotelId,email,avgScore,serviceScore,qualityScore,sceneScore,comment) VALUES(?,?,?,?,?,?,?,?)";
	private static final String SHOW_COMT = "SELECT commentId,orderId,email,avgScore,serviceScore,qualityScore,sceneScore,good,comment FROM Comments WHERE orderId = ?";
	private static final String SEL_HOTELID = "SELECT commentId,orderId,hotelId,avgScore,serviceScore,qualityScore,sceneScore,good,comment FROM Comments WHERE hotelId = ?";
	private static final String HOST_RESPONSE = "UPDATE Comments SET response = ? WHERE commentId = ?";
	private static final String SHOW_RESPONSE = "SELECT response FROM Comments WHERE commentId = ?";
	private static final String UPD_COMT = "UPDATE Comments SET avgScore = ?,serviceScore = ?,qualityScore = ?,sceneScore =?,comment=? where commentId = ?";
	private static final String GOOD_COMT = "UPDATE Comments SET good = ? WHERE commentId = ?";
	private static final String SHOW_GOOD = "SELECT good FROM Comments WHERE commentId = ?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs; 
	CommentVO com;
	List<CommentVO> comtList = new ArrayList<CommentVO>();
	
	private static DataSource ds = null;
	static{
		
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/iCastleDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String comtIns(CommentVO comt){
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INS_COMT);
			stmt.setInt(1,comt.getOrderId());
			stmt.setInt(2,comt.getHotelId());
			stmt.setString(3,comt.getEmail());
			stmt.setDouble(4,(comt.getServiceScore()+comt.getSceneScore()+comt.getQualityScore())/3.0);
			stmt.setInt(5,comt.getServiceScore());
			stmt.setInt(6,comt.getQualityScore());
			stmt.setInt(7,comt.getSceneScore());
			stmt.setString(8,comt.getComment());
			stmt.setDate(9,comt.getCommentTime());
			stmt.executeUpdate();
		
			
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
		return "新增成功";
		
	}
	
	public List<CommentVO> hotelComtSearch(Integer hotelId){
		try {
			conn = ds.getConnection();
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
			com.setCommentTime(rs.getDate("commentTime"));
			comtList.add(com);
			}
			
			
			
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
	
	public CommentVO response(Integer commentId,java.sql.Date responseTime,String response){
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(HOST_RESPONSE);
			stmt.setString(1,response);
			stmt.setDate(2,responseTime);
			stmt.setInt(3, commentId);
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SHOW_RESPONSE);
			stmt.setInt(1,commentId);
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setResponse(rs.getString(1));
			com.setResponseTime(rs.getDate(2));

				
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
	
	public String comUpdate(CommentVO comt){
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPD_COMT);
			stmt.setDouble(1,(comt.getSceneScore()+comt.getQualityScore()+comt.getServiceScore())/3);
            stmt.setInt(2,comt.getServiceScore());
            stmt.setInt(3,comt.getQualityScore());
            stmt.setInt(4,comt.getSceneScore());
            stmt.setString(5,comt.getComment());
            stmt.setDate(6,comt.getCommentTime());
            stmt.setInt(7,comt.getCommentId());
            
            stmt.executeUpdate();
            
				
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
		return "修改成功";
		
	}
	
	public CommentVO pressGood(Integer commentId,Integer good){
		

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(GOOD_COMT);
			stmt.setInt(1, good);
			stmt.setInt(2, commentId);
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SHOW_GOOD);
			stmt.setInt(1,commentId);
			rs = stmt.executeQuery();
			rs.next();
			
			com = new CommentVO();
			com.setGood(rs.getInt("good"));
				
			
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
	
	public CommentVO findByOrderId(Integer orderId){
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SHOW_COMT);
			stmt.setInt(1,orderId);
			rs = stmt.executeQuery();			
			rs.next();
			
			com = new CommentVO();
			com.setCommentId(rs.getInt("commentId"));
			com.setOrderId(rs.getInt("orderId"));
			com.setEmail(rs.getString("email"));
			com.setAvgScore(rs.getDouble("avgScore"));
			com.setServiceScore(rs.getInt("serviceScore"));
			com.setQualityScore(rs.getInt("qualityScore"));
			com.setSceneScore(rs.getInt("sceneScore"));
			com.setGood(rs.getInt("good"));
			com.setComment(rs.getString("comment"));
			com.setCommentTime(rs.getDate("commentTime"));
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


