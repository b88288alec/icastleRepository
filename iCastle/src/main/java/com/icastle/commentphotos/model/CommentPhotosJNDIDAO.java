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

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentVO;

public class CommentPhotosJNDIDAO implements CommentPhotosDAO_interface{
	
	private final String INS_PHOTO = "INSERT INTO CommentPhotos(commentId,photo) VALUES (?,?)";
	private final String SHOW_PHOTO = "SELECT commentId,photo FROM CommentPhotos WHERE commentId=?";
	private final String DEL_PHOTO = "DELETE CommentPhotos WHERE commentId = ?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	List<CommentPhotosVO> listPhoto;
	CommentPhotosVO comtPhoto;
	
	private static DataSource ds = null;
	static{
		
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/iCastleDB(private)");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String uploadCommentPhoto(int commentId,InputStream x,long len){
		
		try {

			
		    conn = ds.getConnection();
			stmt = conn.prepareStatement(INS_PHOTO);
			stmt.setInt(1,commentId);
			stmt.setBinaryStream(2,x,len);
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
		return "上傳成功";

		
		
	}
	
	
	public String deleteCommentPhoto(int commentId){
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DEL_PHOTO);
			stmt.setInt(1,commentId);
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
		return "刪除成功";
		
		
	}
	
	public List<CommentPhotosVO> findByCommentId(int commentId){
		
		
	     Blob b;
	     byte[] data;
	     comtPhoto = new CommentPhotosVO();
	try {
		
		conn = ds.getConnection();
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
	public CommentPhotosVO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

