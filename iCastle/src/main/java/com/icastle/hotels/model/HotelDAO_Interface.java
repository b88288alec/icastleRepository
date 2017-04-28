package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

public interface HotelDAO_Interface {
	
	public HotelVO addHotel(HotelVO hotelVO);//新增飯店
	public HotelVO updateHotel(HotelVO hotelVO);//密碼修改
	public HotelVO updateState(int hotelId, int state);//修改飯店狀態(管理員同意上架)
	public HotelVO findByPrimaryKey(int hotelId);//查到單一一家飯店的資料
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum);//首頁查詢
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, int peopleNum, String order, int lowprice, int highprice, double point, int star);//進階查詢
	
//	public HotelVO changePw(HotelVO hotelVO);//飯店修改自己的密碼
//	public int updatePoint(int hotelId, Double point);//更改飯店評分，回傳更新筆數
}
