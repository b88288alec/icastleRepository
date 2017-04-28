package com.icastle.hotelInfo.main;

import com.icastle.hotelInfo.modle.InfoJDBCDAO;
import com.icastle.hotelInfo.modle.InfoVO;

public class HotelInfoTest {
	
/* ------------飯店頁面時查詢--------------- */		
	public static void select(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		
		InfoVO infoVO = dao.findByHotelId(1);		

		System.out.println(infoVO.getRegisterName());
		System.out.println(infoVO.getTel());
		System.out.println(infoVO.getTransport());
		System.out.println(infoVO.getWebsite());
		System.out.println(infoVO.getHotelProfile());
		System.out.println(infoVO.getCheckin());
		System.out.println(infoVO.getCheckout());
		System.out.println(infoVO.getGuestPolicies());
		System.out.println(infoVO.getCancelPolicies());
		System.out.println(infoVO.isRoomWifi());
		System.out.println(infoVO.isHallWifi());
		System.out.println(infoVO.isInternet());
		System.out.println(infoVO.isMineralWater());
		System.out.println(infoVO.isToiletUtensils());
		System.out.println(infoVO.isHairDryer());
		System.out.println(infoVO.isTv());
		System.out.println(infoVO.isGameRoom());
		System.out.println(infoVO.isGym());
		System.out.println(infoVO.isSpa());
		System.out.println(infoVO.isSwimPool());
		
	}
/* ------------飯店頁面更新--------------- */		
	public static void update(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		
		InfoVO infoVO = new InfoVO();
		
		infoVO.setHotelId(1);
		infoVO.setRegisterName("小明");
		infoVO.setTel("02-2222-3333");
		infoVO.setTransport("你好喔");
		infoVO.setWebsite("未知");
		infoVO.setHotelProfile("未知");
		infoVO.setCheckin("08:00");
		infoVO.setCheckout("12:00");
		infoVO.setGuestPolicies("未知");
		infoVO.setCancelPolicies("未知");
		infoVO.setRoomWifi(true);
		infoVO.setHairDryer(true);
		infoVO.setInternet(true);
		infoVO.setMineralWater(true);
		infoVO.setToiletUtensils(true);
		infoVO.setHairDryer(true);
		infoVO.setTv(true);
		infoVO.setGameRoom(true);
		infoVO.setGym(false);
		infoVO.setSpa(false);
		infoVO.setSwimPool(false);
		
		dao.updateHotelInfo(infoVO);
		
		
	}
/* ------------飯店註冊--------------- */		
	public static void insert(){
		InfoJDBCDAO dao =new InfoJDBCDAO();
		InfoVO infoVO = new InfoVO();
		
		infoVO.setHotelId(1);
		infoVO.setRegisterName("小明1");
		infoVO.setTel("02-2222-3333");
		infoVO.setTransport("你好喔");
		infoVO.setWebsite("未知");
		infoVO.setHotelProfile("未知");
		infoVO.setCheckin("08:00");
		infoVO.setCheckout("12:00");
		infoVO.setGuestPolicies("未知");
		infoVO.setCancelPolicies("未知");
		infoVO.setRoomWifi(true);
		infoVO.setHairDryer(false);
		infoVO.setInternet(false);
		infoVO.setMineralWater(false);
		infoVO.setToiletUtensils(false);
		infoVO.setHairDryer(false);
		infoVO.setTv(false);
		infoVO.setGameRoom(true);
		infoVO.setGym(true);
		infoVO.setSpa(true);
		infoVO.setSwimPool(true);
		
		dao.insert(infoVO);
	}
	public static void main(String[] args) {
//		select();
		update();
//		insert();
	}

}
