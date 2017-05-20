package com.icastle.record.model;

import java.util.List;

import com.icastle.roomtype.model.RoomTypeVO;

public interface RecordDAO_interface {

//	飯店異動紀錄
	public void hotelRecord(List<RecordVO> recordsList);
//	管理員異動紀錄
	public void managerRecord(RecordVO record);
//	用ID搜尋
	public List<RecordVO> select_by_id(String id);
//	用名稱搜尋
	public List<RecordVO> select_by_name(String name);
	
}
