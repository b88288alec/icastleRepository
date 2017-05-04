package com.icastle.Comments.model;

import java.util.Calendar;
import java.util.List;

public class CommentService {
	
	CommentDAO_interface comtDAO = new CommentDAO();
	
	
	
	public String comtIns(CommentVO comt){
		return comtDAO.comtIns(comt);	
	}
	
	public List<CommentVO> hotelComtSearch(Integer hotelId){
		return comtDAO.hotelComtSearch(hotelId);	
	}
	
	public CommentVO response(Integer commentId,java.sql.Date responseTime,String response){
		return comtDAO.response(commentId,responseTime,response);	
	}
	
	public String comUpdate(CommentVO comt){
		return comtDAO.comUpdate(comt);	
	}
	
	public CommentVO pressGood(Integer commentId,Integer good){
		return comtDAO.pressGood(commentId,good);
		
	}
	
	public CommentVO findByOrderId(Integer orderId){
		return comtDAO.findByOrderId(orderId);
		
	}
	
	public java.sql.Date getCurrentDate(){
		java.sql.Date d;
		d = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		return d;
	}
	
	
	

}
