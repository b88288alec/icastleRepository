package com.icastle.Comments.model;

import java.util.List;

public interface CommentDAO_interface {
	
	public String comtIns(CommentVO comt);
	public List<CommentVO> hotelComtSearch(Integer hotelId);
	public CommentVO response(Integer commentId,java.sql.Date responseTime,String response);
	public String comUpdate(CommentVO comt); 
	public CommentVO pressGood(Integer commentId,Integer good);
	public CommentVO findByOrderId(Integer orderId);
	public CommentVO findByCommentId(Integer commentId);

}
