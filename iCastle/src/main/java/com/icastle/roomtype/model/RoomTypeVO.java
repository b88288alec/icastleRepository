package com.icastle.roomtype.model;

public class RoomTypeVO implements java.io.Serializable{
	private Integer roomTypeId;
	private Integer hotelId;
	private String roomTypeName;
	private Integer peopleNum;
	private Integer roomNumber;
	private Integer weekdaysPrice;
	private Integer holidayPrice;
	private Integer seasonPrice;
	private Integer customizedPrice;
	private String customizedName;
	private Boolean breakfast;
	private Boolean afternoonTea;
	private Boolean dinner;
	private Boolean bedAddable;
	private Integer pricePerPerson;
	private String remark;
	private Boolean deleteStatus;
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
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getWeekdaysPrice() {
		return weekdaysPrice;
	}
	public void setWeekdaysPrice(Integer weekdaysPrice) {
		this.weekdaysPrice = weekdaysPrice;
	}
	public Integer getHolidayPrice() {
		return holidayPrice;
	}
	public void setHolidayPrice(Integer holidayPrice) {
		this.holidayPrice = holidayPrice;
	}
	public Integer getSeasonPrice() {
		return seasonPrice;
	}
	public void setSeasonPrice(Integer seasonPrice) {
		this.seasonPrice = seasonPrice;
	}
	public Integer getCustomizedPrice() {
		return customizedPrice;
	}
	public void setCustomizedPrice(Integer customizedPrice) {
		this.customizedPrice = customizedPrice;
	}
	public String getCustomizedName() {
		return customizedName;
	}
	public void setCustomizedName(String customizedName) {
		this.customizedName = customizedName;
	}
	public Boolean getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}
	public Boolean getAfternoonTea() {
		return afternoonTea;
	}
	public void setAfternoonTea(Boolean afternoonTea) {
		this.afternoonTea = afternoonTea;
	}
	public Boolean getDinner() {
		return dinner;
	}
	public void setDinner(Boolean dinner) {
		this.dinner = dinner;
	}
	public Boolean getBedAddable() {
		return bedAddable;
	}
	public void setBedAddable(Boolean bedAddable) {
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
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	
	
}
