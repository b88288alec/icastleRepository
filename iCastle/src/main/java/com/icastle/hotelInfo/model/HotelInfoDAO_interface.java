package com.icastle.hotelInfo.model;

import java.util.List;

public interface HotelInfoDAO_interface {

	public void insert (HotelInfoVO hotelInfoVO);
	public void update (HotelInfoVO hotelInfoVO);
	public HotelInfoVO findByPrimaryKey (Integer hotelId);
	public List<HotelInfoVO> getAll();
}
