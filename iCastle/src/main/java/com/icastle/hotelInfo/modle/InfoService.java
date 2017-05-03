package com.icastle.hotelInfo.modle;


public class InfoService {
	
	InfoDAO_interface dao = null;
	
	public InfoService(){
		dao = new InfoJNDIDAO();
	}
//  新增	
	/*寫法一*/ //包成vo物件傳入
	public void insert(InfoVO infoVO){
		dao.insert(infoVO);
	}
	
	/*寫法二*/
/*	public void insert(Integer hotelId, String registerName,String tel, String transport, String website, String hotelProfile, 
			String checkin, String checkout, String GuestPolicies, String cancelPolicies, Boolean roomWifi, Boolean hallWifi,
			Boolean internet ,Boolean mineralWater ,Boolean toiletUtensils ,Boolean hairDryer ,Boolean tv ,Boolean gameRoom,
			Boolean gym ,Boolean spa ,Boolean swimPool){
		
		InfoVO infoVO = new InfoVO();
		infoVO.setHotelId(hotelId);
		infoVO.setRegisterName(registerName);
		infoVO.setTel(tel);
		infoVO.setTransport(transport);
		infoVO.setWebsite(website);
		infoVO.setHotelProfile(hotelProfile);
		infoVO.setCheckin(checkin);
		infoVO.setCheckout(checkout);
		infoVO.setGuestPolicies(GuestPolicies);
		infoVO.setCancelPolicies(cancelPolicies);
		infoVO.setRoomWifi(roomWifi);
		infoVO.setHallWifi(hallWifi);
		infoVO.setInternet(internet);
		infoVO.setMineralWater(mineralWater);
		infoVO.setToiletUtensils(toiletUtensils);
		infoVO.setHairDryer(hairDryer);
		infoVO.setTv(tv);
		infoVO.setGameRoom(gameRoom);
		infoVO.setGym(gym);
		infoVO.setSpa(spa);
		infoVO.setSwimPool(swimPool);
		
		dao.insert(infoVO);
	}*/
	
//  更新
	/*寫法一*/
	public void update(InfoVO infoVO){
		dao.updateHotelInfo(infoVO);
	}
	/*寫法二*/
//	public void update(Integer hotelId, String registerName,String tel, String transport, String website, String hotelProfile, 
//			String checkin, String checkout, String GuestPolicies, String cancelPolicies, Boolean roomWifi, Boolean hallWifi,
//			Boolean internet ,Boolean mineralWater ,Boolean toiletUtensils ,Boolean hairDryer ,Boolean tv ,Boolean gameRoom,
//			Boolean gym ,Boolean spa ,Boolean swimPool){
//		
//		InfoVO infoVO = new InfoVO();
//		infoVO.setHotelId(hotelId);
//		infoVO.setRegisterName(registerName);
//		infoVO.setTel(tel);
//		infoVO.setTransport(transport);
//		infoVO.setWebsite(website);
//		infoVO.setHotelProfile(hotelProfile);
//		infoVO.setCheckin(checkin);
//		infoVO.setCheckout(checkout);
//		infoVO.setGuestPolicies(GuestPolicies);
//		infoVO.setCancelPolicies(cancelPolicies);
//		infoVO.setRoomWifi(roomWifi);
//		infoVO.setHallWifi(hallWifi);
//		infoVO.setInternet(internet);
//		infoVO.setMineralWater(mineralWater);
//		infoVO.setToiletUtensils(toiletUtensils);
//		infoVO.setHairDryer(hairDryer);
//		infoVO.setTv(tv);
//		infoVO.setGameRoom(gameRoom);
//		infoVO.setGym(gym);
//		infoVO.setSpa(spa);
//		infoVO.setSwimPool(swimPool);
//		
//		dao.insert(infoVO);
//	}
//  查詢
	public InfoVO findByHotelId(Integer hotelId){
		return dao.findByHotelId(hotelId);
		
	}
}
