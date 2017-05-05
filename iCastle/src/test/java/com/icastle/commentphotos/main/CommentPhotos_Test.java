package com.icastle.commentphotos.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.icastle.commentphotos.model.CommentPhotosDAO;
import com.icastle.commentphotos.model.CommentPhotosJDBCDAO;
import com.icastle.commentphotos.model.CommentPhotosVO;

public class CommentPhotos_Test {
	
	public static void main(String args[]){
		
//		try {
//			int i;
//			FileInputStream fis = new FileInputStream("C:\\Users\\Tony\\Desktop\\123.jpg");
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			
//			FileOutputStream fos = new FileOutputStream("C:\\Users\\Tony\\Desktop\\456.jpg");
//			BufferedOutputStream bps = new BufferedOutputStream(fos);
//			
//			byte[] buffer = new byte[50000];
//			int x = bis.read(buffer);
//			System.out.println(x);
//			bps.write(buffer, 0, x);
//				
//		
//			fis.close();
//			bis.close();
//			fos.close();
//			bps.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		
//		try {
//			CommentPhotosVO vo = new CommentPhotosVO();
//			CommentPhotosDAO dao = new CommentPhotosDAO();
//			
//			File f = new File("C:\\Users\\Student\\Desktop\\123.jpg");
//			InputStream fis = new FileInputStream(f);
//			int data = fis.available();
//			
//			
//			String message = dao.uploadCommentPhoto(1,fis,data);
//			fis.close();
//			System.out.println(message);
//			
//			
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		
		File f;
		FileOutputStream fis;
		BufferedOutputStream bop;
		CommentPhotosVO vo = new CommentPhotosVO();
		CommentPhotosJDBCDAO dao = new CommentPhotosJDBCDAO();
		CommentPhotosVO photoSingle;
		List<CommentPhotosVO> photo = dao.findByCommentId(1);
				
		try {
			photoSingle =photo.get(0);
		    f = new File("C:\\Users\\Student\\Desktop\\789.jpg");
			fis = new FileOutputStream(f);
		    bop = new BufferedOutputStream(fis);
			bop.write(photoSingle.getPhoto(),0,photoSingle.getPhoto().length);
			fis.close();
			bop.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		CommentPhotosDAO dao = new CommentPhotosDAO();
//		String message = dao.deleteCommentPhoto(1);
//		System.out.println(message);
		
	}
	
	

}
