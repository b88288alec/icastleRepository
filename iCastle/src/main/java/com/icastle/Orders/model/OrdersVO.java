package com.icastle.Orders.model;

public class OrdersVO {

	private Integer orderId;
	private Integer memberId;
	private Integer roomId;
	private Integer price;
	private Integer dates;	//入住天數
	private Integer roomNum;
	private Boolean orderState;
	private String reservationer;
	private java.sql.Date bdate;
	private String tel;
	private String personId;
	private String email;
	private String country;
	private String addr;
	private String passport;
	private Boolean bedAdding;
	private String remark;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDates() {
		return dates;
	}
	public void setDates(Integer dates) {
		this.dates = dates;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public Boolean getOrderState() {
		return orderState;
	}
	public void setOrderState(Boolean orderState) {
		this.orderState = orderState;
	}
	public String getReservationer() {
		return reservationer;
	}
	public void setReservationer(String reservationer) {
		this.reservationer = reservationer;
	}
	public java.sql.Date getBdate() {
		return bdate;
	}
	public void setBdate(java.sql.Date bdate) {
		this.bdate = bdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Boolean getBedAdding() {
		return bedAdding;
	}
	public void setBedAdding(Boolean bedAdding) {
		this.bedAdding = bedAdding;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
