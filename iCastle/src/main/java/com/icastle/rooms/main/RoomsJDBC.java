package com.icastle.rooms.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.icastle.rooms.model.RoomsJDBCDAO;
import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;

public class RoomsJDBC {
	
	static RoomsJDBCDAO dao = new RoomsJDBCDAO();
	
	public static void insert(){
		RoomsVO vo = new RoomsVO();
		RoomsVO vo2 = new RoomsVO();
		RoomsVO vo3 = new RoomsVO();
		RoomsVO vo4 = new RoomsVO();
		List<RoomsVO> lis = new ArrayList<RoomsVO>();

		Calendar cal = Calendar.getInstance();
		cal.set(2017, 0, 1);
		long first = cal.getTimeInMillis();
		cal.set(2017, 0, 2);
		long second = cal.getTimeInMillis();
		cal.set(2017, 0, 3);
		long thrid = cal.getTimeInMillis();
		cal.set(2017, 0, 4);
		long fourth = cal.getTimeInMillis();
		
		
		vo.setRoomTypeId(10);
		vo.setHotelId(5);
		vo.setRoomDate(new Date(first));
		vo.setRoomTypeName("雅緻雙人房（無窗）");
		vo.setPeopleNum(2);
		vo.setBookedNum(12);
		vo.setRoomNumber(15);
		vo.setPrice(2875);
		vo.setBreakfast(true);
		vo.setDinner(false);
		vo.setAfternoonTea(false);;
		vo.setBedAddable(true);;
		vo.setPricePerPerson(600);
		vo.setRemark("若單筆預訂超過5間客房，可能會需要遵守其他相關規定以及符合額外的要求。");
		
		lis.add(vo);
		
		vo2.setRoomTypeId(10);
		vo2.setHotelId(5);
		vo2.setRoomDate(new Date(second));
		vo2.setRoomTypeName("雅緻雙人房（無窗）");
		vo2.setPeopleNum(2);
		vo2.setBookedNum(8);
		vo2.setRoomNumber(15);
		vo2.setPrice(3120);
		vo2.setBreakfast(true);
		vo2.setDinner(false);
		vo2.setAfternoonTea(false);;
		vo2.setBedAddable(true);;
		vo2.setPricePerPerson(600);
		vo2.setRemark("若單筆預訂超過5間客房，可能會需要遵守其他相關規定以及符合額外的要求。");
		
		lis.add(vo2);
		
		vo3.setRoomTypeId(10);
		vo3.setHotelId(5);
		vo3.setRoomDate(new Date(thrid));
		vo3.setRoomTypeName("雅緻雙人房（無窗）");
		vo3.setPeopleNum(2);
		vo3.setBookedNum(11);
		vo3.setRoomNumber(15);
		vo3.setPrice(2771);
		vo3.setBreakfast(true);
		vo3.setDinner(false);
		vo3.setAfternoonTea(false);;
		vo3.setBedAddable(true);;
		vo3.setPricePerPerson(600);
		vo3.setRemark("若單筆預訂超過5間客房，可能會需要遵守其他相關規定以及符合額外的要求。");
		
		lis.add(vo3);
		
		vo4.setRoomTypeId(10);
		vo4.setHotelId(5);
		vo4.setRoomDate(new Date(fourth));
		vo4.setRoomTypeName("雅緻雙人房（無窗）");
		vo4.setPeopleNum(2);
		vo4.setBookedNum(6);
		vo4.setRoomNumber(15);
		vo4.setPrice(2875);
		vo4.setBreakfast(true);
		vo4.setDinner(false);
		vo4.setAfternoonTea(false);;
		vo4.setBedAddable(true);;
		vo4.setPricePerPerson(600);
		vo4.setRemark("若單筆預訂超過5間客房，可能會需要遵守其他相關規定以及符合額外的要求。");
		
		lis.add(vo4);
		
		int count = dao.insert(lis);
		System.out.println(count);
	}

	public static void getRoomsByMonth(){
		
		
		List<RoomsVO> lis = dao.getRoomsByMonth(5, 10, 1);
		
		for(RoomsVO vo : lis){
			System.out.println("RoomId = " +vo.getRoomId());
			System.out.println("RoomTypeId = " +vo.getRoomTypeId());
			System.out.println("HotelId = " + vo.getHotelId());
			System.out.println("RoomDate = " + vo.getRoomDate());
			System.out.println("RoomTypeName = " + vo.getRoomTypeName());
			System.out.println("PeopleNum = " + vo.getPeopleNum());
			System.out.println("BookedNum = " + vo.getBookedNum());
			System.out.println("RoomNumber = " + vo.getRoomNumber());
			System.out.println("Price = " + vo.getPrice());
			System.out.println("Breakfast = " + vo.isBreakfast());
			System.out.println("Dinner = " + vo.isDinner());
			System.out.println("AfternoonTea = " + vo.isAfternoonTea());
			System.out.println("BedAddable = " + vo.isBedAddable());
			System.out.println("PricePerPerson = " + vo.getPricePerPerson());
			System.out.println("Remark = " + vo.getRemark());
			System.out.println("------------------------------------------------------------------------------------------");
		}
	}
	
	public static void update(){
		RoomsVO vo = new RoomsVO();
		RoomsVO vo2 = new RoomsVO();
		
		List<RoomsVO> lis = new ArrayList<RoomsVO>();
		
		vo.setRoomId(29);
		vo.setRoomTypeName("雅緻雙人房（無窗）");
		vo.setRoomNumber(15);
		vo.setBreakfast(true);
		vo.setDinner(false);
		vo.setAfternoonTea(false);;
		vo.setBedAddable(true);;
		vo.setPricePerPerson(400);
		vo.setRemark("");
		
		vo2.setRoomId(30);
		vo2.setRoomTypeName("雙人房");
		vo2.setRoomNumber(1000);
		vo2.setBreakfast(true);
		vo2.setDinner(true);
		vo2.setAfternoonTea(true);;
		vo2.setBedAddable(true);;
		vo2.setPricePerPerson(40000);
		vo2.setRemark(null);
		
		lis.add(vo);
		lis.add(vo2);
		
		int count = dao.updateDetail(lis);
		System.out.println(count);
	}
	
	public static void getOrder(){
		
		int count = dao.getOrder(29, 2, 2);
		System.out.println(count);
	}
	
	public static void findRooms(){
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 0, 2);
		long star = cal.getTimeInMillis();
		
		cal.set(2017, 0, 4);
		long end = cal.getTimeInMillis();
		
		List<RoomsVO> list = dao.findRooms(5, 4, new Date(star), new Date(end));
		
		for(RoomsVO vo : list){
			System.out.println("RoomId = " +vo.getRoomId());
			System.out.println("RoomTypeId = " +vo.getRoomTypeId());
			System.out.println("HotelId = " + vo.getHotelId());
			System.out.println("RoomDate = " + vo.getRoomDate());
			System.out.println("RoomTypeName = " + vo.getRoomTypeName());
			System.out.println("PeopleNum = " + vo.getPeopleNum());
			System.out.println("BookedNum = " + vo.getBookedNum());
			System.out.println("RoomNumber = " + vo.getRoomNumber());
			System.out.println("Price = " + vo.getPrice());
			System.out.println("Breakfast = " + vo.isBreakfast());
			System.out.println("Dinner = " + vo.isDinner());
			System.out.println("AfternoonTea = " + vo.isAfternoonTea());
			System.out.println("BedAddable = " + vo.isBedAddable());
			System.out.println("PricePerPerson = " + vo.getPricePerPerson());
			System.out.println("Remark = " + vo.getRemark());
			System.out.println("------------------------------------------------------------------------------------------");
		}
	}
	
	public static void updatePrice(){
		RoomsVO vo = new RoomsVO();
		RoomsVO vo2 = new RoomsVO();
		List<RoomsVO> lis = new ArrayList<RoomsVO>();
		
		vo.setRoomId(42);
		vo.setPrice(6000);
		vo2.setRoomId(43);
		vo2.setPrice(6000);
		
		lis.add(vo);
		lis.add(vo2);
		
		int count = dao.updatePrice(lis);
		System.out.println(count);
	}
	
	public static void getstayDayNum(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		int stayDayNum = 0;
		Date d = null;
		try {
			String s1 = "2017/01/02";
			String s2 = "2017/01/04";
			long start = sdf.parse(s1).getTime();
			long end = sdf.parse(s2).getTime();
			stayDayNum = (int)((end - start) / (1000*60*60*24));
			d = new Date((end - start / (24*60*60*1000)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(stayDayNum);
		System.out.println(d);
		
	}
	
	public static void getPerPrice(){
		Map<String,Integer> perPrice = dao.getPerPrice(41, 3);
		
//		for(Integer price : perPrice){
//			System.out.println(price);
//		}
	}
	
	public static void main(String[] args) {
//		insert();
//		getRoomsByMonth();
//		update();
		getOrder();
//		findRooms();
//		updatePrice();
//		getstayDayNum();
//		getPerPrice();
	}

}
