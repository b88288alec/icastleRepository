package com.icastle.record.model;

public class RecordVO implements java.io.Serializable{
	private Integer recordId;
	private java.sql.Timestamp recordTime;
	private String id;
	private String name;
	private Integer roomTypeId;
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
	private String managerRecord;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public java.sql.Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(java.sql.Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getManagerRecord() {
		return managerRecord;
	}
	public void setManagerRecord(String managerRecord) {
		this.managerRecord = managerRecord;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

}
