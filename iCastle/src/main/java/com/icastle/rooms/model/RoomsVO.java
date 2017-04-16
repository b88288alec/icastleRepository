package com.icastle.rooms.model;

import java.sql.Date;

public class RoomsVO implements java.io.Serializable{

	private Integer roomId;
	private Integer roomTypeId;
	private Integer hotelId;
	private Date roomDate;
	private String roomTypeName;
	private Integer peopleNum;
	private Integer remaining;
	private Integer roomNumber;
	private Integer price;
	private Double discount;
	private String offerName;
	private boolean breakfast;
	private boolean lunch;
	private boolean afternoonTea;
	private boolean bedAddable;
	private Integer pricePerPerson;
	private String remark;
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public boolean isLunch() {
		return lunch;
	}
	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}
	public boolean isAfternoonTea() {
		return afternoonTea;
	}
	public void setAfternoonTea(boolean afternoonTea) {
		this.afternoonTea = afternoonTea;
	}
	public boolean isBedAddable() {
		return bedAddable;
	}
	public void setBedAddable(boolean bedAddable) {
		this.bedAddable = bedAddable;
	}
	public Integer getPricePerPerson() {
		return pricePerPerson;
	}
	public void setPricePerPerson(Integer pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
