package com.icastle.hotelInfo.main;

import com.icastle.hotelInfo.modle.InfoJDBCDAO;
import com.icastle.hotelInfo.modle.InfoVO;

public class HotelInfoTest {
	
/* ------------飯店頁面時查詢--------------- */		
	public static void select(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		
		InfoVO infoVO = dao.findByHotelId(1);
		int n = infoVO.getHotelId();
		String v = infoVO.getRegisterName();
		String a = infoVO.getCancelPolicies();
//		string y = infoVO.getRegisterName();
		System.out.println(infoVO.getRegisterName());
//		System.out.println(n);			
		
	}
/* ------------飯店頁面更新--------------- */		
	public static void update(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		
		InfoVO infoVO = new InfoVO();
		
		infoVO.setHotelId(1);
		infoVO.setRegisterName("小明");
		
		dao.updateHotelInfo(infoVO);
		
		
	}
	public static void insert(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		InfoVO infoVO = new InfoVO();
		infoVO.setHotelId(2);
		infoVO.setRegisterName("小花");
		dao.insert(infoVO);
		
		
		
	}
	public static void main(String[] args) {
//		select();
//		update();
		insert();
	}

}
