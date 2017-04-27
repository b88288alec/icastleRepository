package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

public interface HotelDAO_Interface {
	
	public HotelVO addHotel(HotelVO hotelVO);//新增飯店
	public HotelVO updateHotel(HotelVO hotelVO);//密碼修改
	public HotelVO updateState(int hotelId, int state);//修改飯店狀態(管理員同意上架)
	public HotelVO findByPrimaryKey(int hotelId);
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum);
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, int peopleNum, String order, int lowprice, int highprice, double point, int star);
	
}
