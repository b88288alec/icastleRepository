package com.icastle.commentphotos.model;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface CommentPhotosDAO_interface {
	public String uploadCommentPhoto(int commentId,InputStream x,long length);
	public String deleteCommentPhoto(int commentId);
	public List<CommentPhotosVO> findByCommentId(int commentId);

}