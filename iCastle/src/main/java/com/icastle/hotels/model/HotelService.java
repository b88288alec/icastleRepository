package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

public class HotelService {
	
	HotelDAO_Interface dao = null;
	
	public HotelService (){
//		dao = new HotelDAOJNDI();
		dao = new HotelDAOHibernate();
	}
	
	//新增飯店
	public HotelVO addHotel(HotelVO hotelVO){
		return dao.addHotel(hotelVO);
	}
	
	//修改飯店
	public HotelVO updateHotel(int hotelId, String pw){
		HotelVO hotelVO = new HotelVO();
		hotelVO.setHotelId(hotelId);
		hotelVO.setPw(pw);
		return dao.updateHotel(hotelVO);
	}
	
	//修改飯店狀態(管理員同意上架)
	public HotelVO updateState(int hotelId, int state) {
		return dao.updateState(hotelId, state);
	}
	
	public HotelVO findByPrimaryKey(int hotelId) {
		return dao.findByPrimaryKey(hotelId);
	}
	
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum) {
		return dao.indexQuery(zone, startDate, endDate, peopleNum);
	}
	
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate
			, int peopleNum, String order, int lowprice, int highprice, double point, int star) {
		return dao.advancedQuery(zone, startDate, endDate, peopleNum, order, lowprice, highprice, point, star);
	}
}
