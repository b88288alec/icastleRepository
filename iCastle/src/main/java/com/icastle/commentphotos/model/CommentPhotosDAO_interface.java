package com.icastle.commentphotos.model;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface CommentPhotosDAO_interface {
	public String uploadCommentPhoto(int commentId,InputStream x,long len);
	public String deleteCommentPhoto(int commentId);
	public List<CommentPhotosVO> findByCommentId(int commentId);
	public CommentPhotosVO findById(int id);
	public List<Integer> findByIds(int commentId);

}