package com.icastle.Comments.model;

import java.util.List;

public interface CommentDAO_interface {
	
	public CommentVO comtIns(CommentVO comt);
	public List<CommentVO> hotelComtSearch(Integer hotelId);
	public CommentVO response(Integer commentId,java.sql.Date responseTime,String response);
	public CommentVO comUpdate(CommentVO comt); 
	public CommentVO pressGood(Integer commentId,Integer good);

}
