package com.icastle.Comments.model;

import java.util.List;

public interface CommentDAO_interface {
	
	public String comtIns(CommentVO comt, int good);
	public List<CommentVO> hotelComtSearch(Integer hotelId);
	public String response(Integer commentId,java.sql.Date responseTime,String response);
	public String comUpdate(CommentVO comt); 
	public void pressGood(Integer commentId,Integer good);
	public CommentVO findByOrderId(Integer orderId);
	public CommentVO findByCommentId(Integer commentId);
	public List<CommentVO> findByEmail(String email);
	public List<Integer> findByGood(int good);

}
