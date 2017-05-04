package com.icastle.Comments.model;

import java.sql.Date;


public class CommentVO {
	
	private Integer commentId;
	private Integer orderId;
	private Integer hotelId;
	private String email;
	private Double avgScore;
	private Integer serviceScore;
	private Integer qualityScore;
	private Integer sceneScore;
	private Integer good;
	private String comment;
	private String response;
	private Date commentTime;
	private Date responseTime;
	
	
	public Integer getCommentId(){
		return commentId;
	}
	public void setCommentId(Integer commentId){
		this.commentId = commentId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	public Integer getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}
	public Integer getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(Integer qualityScore) {
		this.qualityScore = qualityScore;
	}
	public Integer getSceneScore() {
		return sceneScore;
	}
	public void setSceneScore(Integer sceneScore) {
		this.sceneScore = sceneScore;
	}
	public Integer getGood() {
		return good;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public Date getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	
	
	
}
