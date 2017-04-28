package com.icastle.commentphotos.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentVO;

public class CommentPhotosDAO implements CommentPhotosDAO_interface{
	
	private final String INS_PHOTOS = "INSERT INTO CommentPhotos VALUES (?,?)";
	
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=i-Castle";
	private String user = "sa";
	private String password = "sa123456";
	
	Connection conn;
	PreparedStatement stmt;


	
	
	public void uploadCommentPhoto(CommentPhotosVO comtPhoto){
//		
//		try { 
//			FileInputStream inputStream = new FileInputStream(f);
//			Class.forName(driver);
//		conn = DriverManager.getConnection(url, user, password);
//			stmt = conn.prepareStatement(INS_PHOTOS);
//			stmt.setInt(1, comtPhoto.getCommentId());
//			stmt.setBinaryStream(2, comtPhoto.getPhoto());
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		
	}
	
	
	public void deleteCommentPhoto(CommentPhotosVO id){
		
	}
	
	public CommentPhotosVO findByCommentId(CommentPhotosVO commentId){
		return null;
		
		
	}

}
