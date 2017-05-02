package com.icastle.hotelInfo.modle;

import java.util.List;

public interface InfoDAO_interface  {
	public void insert(InfoVO infoVO); /*飯店註冊*/
	public void updateHotelInfo(InfoVO infoVO); /*飯店頁面更新*/
	public InfoVO findByHotelId(Integer hotelId); /*某飯店頁面時查詢*/
}