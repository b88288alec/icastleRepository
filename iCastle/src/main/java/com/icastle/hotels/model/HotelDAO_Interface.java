package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

public interface HotelDAO_Interface {
	
	//新增飯店
	public HotelVO addHotel(HotelVO hotelVO);
	//修改飯店
	public void update(HotelVO hotelVO);
	//查到單一一家飯店的資料
	public HotelVO findByPrimaryKey(Integer hotelId);
	//登入
	public HotelVO checkAccountPw(String email, String pw);
	//查詢email是否已經註冊過
	public Boolean isEmailOK(String email);
	//首頁查詢
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, Integer peopleNum);//首頁查詢
	//進階查詢
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, Integer peopleNum, String order, Integer lowprice, Integer highprice, double point, Integer star);//進階查詢
	//取得全部飯店
	public List<HotelVO> getAll();
}
