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

//	用roomTypeId搜尋
	public List<RecordVO> select_by_roomTypeId(Integer roomTypeId);

//	用分類、ID搜尋
	public List<RecordVO> select_by_class_id(String id, String classification);

//	用名稱搜尋
	public List<RecordVO> select_by_name(String name, String id);
//	用分類、名稱搜尋
	public List<RecordVO> select_by_class_name(String name, String classification, String id);
	
}
