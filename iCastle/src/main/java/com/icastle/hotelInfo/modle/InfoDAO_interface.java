package com.icastle.hotelInfo.modle;

import java.util.List;

public interface InfoDAO_interface  {
	public void insert(InfoVO InfoVO); /* 飯店註冊時新增 */
	public void updateHotelInfo(InfoVO InfoVO);  /* 修改飯店資訊*/
	public InfoVO findByHotelId(Integer hotelId); /* (客、管) 進入飯店頁面時查詢 */
	
}
