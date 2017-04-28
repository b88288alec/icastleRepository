package com.icastle.commentphotos.model;

public interface CommentPhotosDAO_interface {
	public void uploadCommentPhoto(CommentPhotosVO photo);
	public void deleteCommentPhoto(CommentPhotosVO id);
	public CommentPhotosVO findByCommentId(CommentPhotosVO commentId);

}
