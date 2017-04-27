package com.icastle.hotels.model;

import java.sql.Date;
import java.util.List;

public class HotelDAOHibernate implements HotelDAO_Interface {

	@Override
	public HotelVO addHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO updateHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO updateState(int hotelId, int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO findByPrimaryKey(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, int peopleNum, String order,
			int lowprice, int highprice, double point, int star) {
		// TODO Auto-generated method stub
		return null;
	}

}
