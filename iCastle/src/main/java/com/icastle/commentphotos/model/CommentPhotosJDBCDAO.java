package com.icastle.commentphotos.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentVO;

public class CommentPhotosJDBCDAO implements CommentPhotosDAO_interface{
	
	private final String INS_PHOTO = "INSERT INTO CommentPhotos(commentId,photo) VALUES (?,?)";
	private final String SHOW_PHOTO = "SELECT commentId,photo FROM CommentPhotos WHERE commentId=?";
	private final String DEL_PHOTO = "DELETE CommentPhotos WHERE commentId = ?";
	private final String SEL_ID = "SELECT photo from CommentPhotos WHERE id = ?";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=iCastle";
	private String user = "sa";
	private String password = "sa123456";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	CommentPhotosVO comtPhoto;
	List<CommentPhotosVO> listPhoto;


	
	
	public String uploadCommentPhoto(int commentId,InputStream x,long len){
		
		try {

			Class.forName(driver);
		    conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(INS_PHOTO);
			stmt.setInt(1,commentId);
			stmt.setBinaryStream(2,x,len);
			stmt.executeUpdate();
			
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
		return "上傳成功";

		
		
	}
	
	
	public String deleteCommentPhoto(int commentId){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(DEL_PHOTO);
			stmt.setInt(1,commentId);
			stmt.executeUpdate();
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
		return "刪除成功";
		
		
	}
	
	public List<CommentPhotosVO> findByCommentId(int commentId){
		
		     Blob b;
		     byte[] data;
		     comtPhoto = new CommentPhotosVO();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(SHOW_PHOTO);
			stmt.setInt(1,commentId);
			rs = stmt.executeQuery();
			listPhoto = new ArrayList<CommentPhotosVO>();
			
			while(rs.next()){
				b = rs.getBlob("photo");
				data = b.getBytes(1,(int)b.length());	
				comtPhoto.setPhoto(data);
				comtPhoto.setCommentId(rs.getInt("commentId"));	
				listPhoto.add(comtPhoto);
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
		return listPhoto;
		
	}


	@Override
	public CommentPhotosVO findById(int id){
		
		Blob b;
		byte[] data;
		comtPhoto = new CommentPhotosVO();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(SEL_ID);
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
            rs.next();
            
            b = rs.getBlob("photo");
            data = b.getBytes(1,(int)b.length());
            comtPhoto.setPhoto(data);
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		
		return comtPhoto;
		
	}

}
