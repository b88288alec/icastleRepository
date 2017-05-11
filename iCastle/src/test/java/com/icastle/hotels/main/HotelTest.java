package com.icastle.hotels.main;

import java.util.List;
import java.util.Random;

import com.icastle.hotels.model.HotelDAOHibernate;
import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;
import com.icastle.hotels.model.ListVO;

//hibernate版的test
public class HotelTest {

	public static void main(String[] args) {
		//addHotel
//		HOTELSERVICE DAO = NEW HOTELSERVICE();
//		HOTELVO HOTEL = NEW HOTELVO();
//		HOTEL.SETHOTELNAME("好帥");
//		HOTEL.SETEMAIL("HANDSOME@GMAIL.COM");
//		HOTEL.SETPW("HANDSOME");
//		HOTEL.SETADDR("台北市松山區南京東路四段2號");
//		HOTEL.SETZONE("台北市");
//		HOTEL.SETPOINT(4.0);
//		HOTEL.SETHOT(135);
//		HOTEL.SETSTAR(5);
//		HOTEL.SETHOTELSTATE(1);
//		HOTEL.SETREGISTERID("好帥第210號");
//		HOTELVO HOTELVO = DAO.ADDHOTEL(HOTEL);
//		SYSTEM.OUT.PRINTLN("成功新增");
		
		//changePw
//		HotelService dao = new HotelService();
//		Integer hotelId = 1;
//		String oldpw = "hand466";
//		String newpw = "454545";
//		boolean r = dao.changePw(hotelId, oldpw, newpw);
//		System.out.println(r);

		//忘記密碼時亂數產生新密碼
//		HotelService dao = new HotelService();
//		Integer hotelId = 1;
//		String pw = dao.createPw(hotelId);
//		System.out.println(pw);
		
		//修改飯店上架狀態
//		HotelService dao = new HotelService();
//		Integer hotelId = 1;
//		Integer state = 0;
//		dao.updateState(hotelId, state);
		
		//更新評分
//		HotelService dao = new HotelService();
//		Integer hotelId = 1;
//		Double point = 2.2;
//		dao.updatePoint(hotelId, point);
		
		//由管理員更新飯店的所有欄位
//		HotelService dao = new HotelService();
//		HotelVO hotel = dao.findByPrimaryKey(1);
//		hotel.setHotelName("Xppp");
//		dao.adminUpdate(hotel);
		
		//findByPrimaryKey
//		HotelService dao = new HotelService();
//		HotelVO hotelvo = dao.findByPrimaryKey(1);
//		System.out.println("----------------------");
//		System.out.println(hotelvo.getHotelId());
//		System.out.println(hotelvo.getHotelName());
//		System.out.println(hotelvo.getEmail());
//		System.out.println(hotelvo.getPw());
//		System.out.println(hotelvo.getAddr());
//		System.out.println(hotelvo.getZone());
//		System.out.println(hotelvo.getPoint());
//		System.out.println(hotelvo.getHot());
//		System.out.println(hotelvo.getStar());
//		System.out.println(hotelvo.getHotelState());
//		System.out.println(hotelvo.getRegisterId());
		
		//飯店登入
//		HotelService dao = new HotelService();
//		String email = "handsome@gmail.com"; 
//		String pw = "928749";
//		HotelVO hotelvo = dao.checkAccountPw(email, pw);
//		System.out.println(hotelvo.getHotelId());
//		System.out.println(hotelvo.getHotelName());
//		System.out.println(hotelvo.getEmail());
//		System.out.println(hotelvo.getPw());
//		System.out.println(hotelvo.getAddr());
//		System.out.println(hotelvo.getZone());
//		System.out.println(hotelvo.getPoint());
//		System.out.println(hotelvo.getHot());
//		System.out.println(hotelvo.getStar());
//		System.out.println(hotelvo.getHotelState());
//		System.out.println(hotelvo.getRegisterId());
		
		//查詢email是否已經註冊過
//		HotelService dao = new HotelService();
//		HotelVO hotelvo = dao.findByEmail("midtown@richardson.com");
//		if (hotelvo != null){
//			System.out.println(hotelvo.getHotelId());
//			System.out.println(hotelvo.getHotelName());
//			System.out.println(hotelvo.getEmail());
//			System.out.println(hotelvo.getPw());
//			System.out.println(hotelvo.getAddr());
//			System.out.println(hotelvo.getZone());
//			System.out.println(hotelvo.getPoint());
//			System.out.println(hotelvo.getHot());
//			System.out.println(hotelvo.getStar());
//			System.out.println(hotelvo.getHotelState());
//			System.out.println(hotelvo.getRegisterId());
//		}else
//			System.out.println("不存在此email帳號");
		
		//首頁查詢
//		HotelService dao = new HotelService();
//		String type = "雄市";
//		java.sql.Date startDate = java.sql.Date.valueOf("2017-01-02");
//		java.sql.Date endDate = java.sql.Date.valueOf("2017-01-04");
//		int peopleNum = 4;
//		List<ListVO> lists = dao.indexQuery(type, startDate, endDate, peopleNum);
//		for (ListVO list : lists){
//			System.out.print(list.getHotelId() + "  ");
//			System.out.print(list.getHotelName() + "  ");
//			System.out.print(list.getPrice() + "  ");
//			System.out.print(list.getStar() + "  ");
//			System.out.print(list.getPoint() + "  ");
//			System.out.print(list.getHot() + "  ");
//			System.out.print(list.isBreakfast() + "  ");
//			System.out.print(list.isDinner() + "  ");
//			System.out.println(list.isRoomWifi());
//		}
		
		//進階查詢 
//		HotelService dao = new HotelService();
//		String zone = "雄市";
//		java.sql.Date startDate = java.sql.Date.valueOf("2017-01-02");
//		java.sql.Date endDate = java.sql.Date.valueOf("2017-01-04");
//		int peopleNum = 4;
//		String order = "最低價格";
//		Integer lowprice = 4;
//		Integer highprice = 20000;
//		Double point = 0.0;
//		Integer star = 2;
//		List<ListVO> lists = dao.advancedQuery(zone, startDate, endDate, peopleNum, order, lowprice, highprice, point, star);
//		for (ListVO list : lists){
//			System.out.print(list.getHotelId() + "  ");
//			System.out.print(list.getHotelName() + "  ");
//			System.out.print(list.getPrice() + "  ");
//			System.out.print(list.getStar() + "  ");
//			System.out.print(list.getPoint() + "  ");
//			System.out.print(list.getHot() + "  ");
//			System.out.print(list.isBreakfast() + "  ");
//			System.out.print(list.isDinner() + "  ");
//			System.out.println(list.isRoomWifi());
//		}
		
		//查詢全部飯店
//		HotelService dao = new HotelService();
//		List<HotelVO> hotels = dao.getAll();
//		for (HotelVO hotelvo : hotels){
//			System.out.println(hotelvo.getHotelId());
//			System.out.println(hotelvo.getHotelName());
//			System.out.println(hotelvo.getEmail());
//			System.out.println(hotelvo.getPw());
//			System.out.println(hotelvo.getAddr());
//			System.out.println(hotelvo.getZone());
//			System.out.println(hotelvo.getPoint());
//			System.out.println(hotelvo.getHot());
//			System.out.println(hotelvo.getStar());
//			System.out.println(hotelvo.getHotelState());
//			System.out.println(hotelvo.getRegisterId());
//			System.out.println("-----------------------");
//		}
		
		//查詢未通過審核的飯店
		HotelDAOHibernate dao = new HotelDAOHibernate();
		dao.getUncheckedHotel();
	}
}
