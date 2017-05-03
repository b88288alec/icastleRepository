package com.icastle.commentphotos.model;

import java.io.InputStream;
import java.util.List;

public class CommentPhotosService {
	
	CommentPhotosDAO_interface comtphotoDAO = new CommentPhotosDAO();
	
	public String uploadCommentPhoto(int commentId,InputStream x,long len){
		return comtphotoDAO.uploadCommentPhoto(commentId, x, len);
		
	}
	
	public String deleteCommentPhoto(int commentId){
		return comtphotoDAO.deleteCommentPhoto(commentId);
		
	}
	
	public List<CommentPhotosVO> findByCommentId(int commentId){
		return comtphotoDAO.findByCommentId(commentId);
		
	}
	
	

}
