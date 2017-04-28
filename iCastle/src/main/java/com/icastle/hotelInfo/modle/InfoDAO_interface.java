package com.icastle.hotelInfo.modle;

import java.util.List;

public interface InfoDAO_interface  {
	public void insert(InfoVO infoVO);
	public void updateHotelInfo(InfoVO infoVO);
	public InfoVO findByHotelId(Integer hotelId);
}