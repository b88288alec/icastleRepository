package com.icastle.commentphotos.model;

public class CommentPhotosVO {
	
	private byte[] photo;
	private Integer commentId;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

}
