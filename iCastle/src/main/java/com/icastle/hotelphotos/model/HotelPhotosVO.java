package com.icastle.hotelphotos.model;

public class HotelPhotosVO {
	private Integer id;
	private Integer hotelId;
	private Integer photoOrder;
	private byte[] photo;
	private Integer roomTypeId;
	private String pohtoDescription;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getPhotoOrder() {
		return photoOrder;
	}
	public void setPhotoOrder(Integer photoOrder) {
		this.photoOrder = photoOrder;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getPohtoDescription() {
		return pohtoDescription;
	}
	public void setPohtoDescription(String pohtoDescription) {
		this.pohtoDescription = pohtoDescription;
	}
	
}
