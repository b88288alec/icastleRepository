package com.icastle.roomtype.main;

import java.util.ArrayList;
import java.util.List;

import com.icastle.roomtype.model.RoomTypeDAO_interface;
import com.icastle.roomtype.model.RoomTypeHibernateDAO;
import com.icastle.roomtype.model.RoomTypeVO;

public class RoomTypeTest {
	
	static RoomTypeDAO_interface dao = new RoomTypeHibernateDAO();
	
	public static void addRoomType(){
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		RoomTypeVO vo1 = new RoomTypeVO();
		RoomTypeVO vo2 = new RoomTypeVO();
		
		vo1.setHotelId(5);
		vo1.setRoomTypeName("豪華家庭房delete");
		vo1.setPeopleNum(4);
		vo1.setRoomNumber(500);
		vo1.setWeekdaysPrice(60000);
		vo1.setHolidayPrice(80000000);
		vo1.setSeasonPrice(10000000);
		vo1.setCustomizedPrice(200000000);
		vo1.setCustomizedName("情侶甜蜜價");
		vo1.setBreakfast(true);
		vo1.setAfternoonTea(true);
		vo1.setDinner(true);
		vo1.setBedAddable(true);
		vo1.setPricePerPerson(444444444);
		vo1.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		vo1.setDeleteStatus(true);
		
		vo2.setHotelId(5);
		vo2.setRoomTypeName("豪華家庭房delete");
		vo2.setPeopleNum(4);
		vo2.setRoomNumber(500);
		vo2.setWeekdaysPrice(60000);
		vo2.setHolidayPrice(80000000);
		vo2.setSeasonPrice(10000000);
		vo2.setCustomizedPrice(200000000);
		vo2.setCustomizedName("情侶甜蜜價");
		vo2.setBreakfast(false);
		vo2.setAfternoonTea(false);
		vo2.setDinner(false);
		vo2.setBedAddable(false);
		vo2.setPricePerPerson(444444444);
		vo2.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		vo2.setDeleteStatus(true);
		
		list.add(vo1);
		list.add(vo2);
		
		Integer count = dao.addOrUpdateRoomType(list);
		
		System.out.println(count);
	}
	
	public static void updateRoomType(){
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		RoomTypeVO vo1 = new RoomTypeVO();
		RoomTypeVO vo2 = new RoomTypeVO();
		
		vo1.setRoomTypeId(14);
		vo1.setHotelId(5);
		vo1.setRoomTypeName("豪華家庭房");
		vo1.setPeopleNum(4);
		vo1.setRoomNumber(500);
		vo1.setWeekdaysPrice(60000);
		vo1.setHolidayPrice(80000000);
		vo1.setSeasonPrice(10000000);
		vo1.setCustomizedPrice(200000000);
		vo1.setCustomizedName("情侶甜蜜價");
		vo1.setBreakfast(true);
		vo1.setAfternoonTea(true);
		vo1.setDinner(true);
		vo1.setBedAddable(true);
		vo1.setPricePerPerson(444444444);
		vo1.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		vo1.setDeleteStatus(false);
		
		vo2.setRoomTypeId(15);
		vo2.setHotelId(5);
		vo2.setRoomTypeName("豪華家庭房");
		vo2.setPeopleNum(4);
		vo2.setRoomNumber(500);
		vo2.setWeekdaysPrice(60000);
		vo2.setHolidayPrice(80000000);
		vo2.setSeasonPrice(10000000);
		vo2.setCustomizedPrice(200000000);
		vo2.setCustomizedName("情侶甜蜜價");
		vo2.setBreakfast(false);
		vo2.setAfternoonTea(false);
		vo2.setDinner(false);
		vo2.setBedAddable(false);
		vo2.setPricePerPerson(444444444);
		vo2.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		vo2.setDeleteStatus(false);
		
		list.add(vo1);
		list.add(vo2);
		
		Integer count = dao.addOrUpdateRoomType(list);
		
		System.out.println(count);
	}
	
	public static void deleteRoomType(){
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		RoomTypeVO vo1 = new RoomTypeVO();
		RoomTypeVO vo2 = new RoomTypeVO();
		
		vo1.setRoomTypeId(14);
		vo1.setHotelId(5);
		vo1.setRoomTypeName("豪華家庭房");
		vo1.setPeopleNum(4);
		vo1.setRoomNumber(500);
		vo1.setWeekdaysPrice(60000);
		vo1.setHolidayPrice(80000000);
		vo1.setSeasonPrice(10000000);
		vo1.setCustomizedPrice(200000000);
		vo1.setCustomizedName("情侶甜蜜價");
		vo1.setBreakfast(true);
		vo1.setAfternoonTea(true);
		vo1.setDinner(true);
		vo1.setBedAddable(true);
		vo1.setPricePerPerson(444444444);
		vo1.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		
		vo2.setRoomTypeId(15);
		vo2.setHotelId(5);
		vo2.setRoomTypeName("豪華家庭房");
		vo2.setPeopleNum(4);
		vo2.setRoomNumber(500);
		vo2.setWeekdaysPrice(60000);
		vo2.setHolidayPrice(80000000);
		vo2.setSeasonPrice(10000000);
		vo2.setCustomizedPrice(200000000);
		vo2.setCustomizedName("情侶甜蜜價");
		vo2.setBreakfast(false);
		vo2.setAfternoonTea(false);
		vo2.setDinner(false);
		vo2.setBedAddable(false);
		vo2.setPricePerPerson(444444444);
		vo2.setRemark("禁止攜帶寵物入住，導盲犬除外。");
		
		list.add(vo1);
		list.add(vo2);
		
		Integer count = dao.deleteRoomType(list);
		
		System.out.println(count);
	}
	
	public static void findRoomTypeByHotelId(){
		List<RoomTypeVO> list = dao.findRoomTypeByHotelId(5);
		
		for(RoomTypeVO vo : list){
			System.out.println(vo.getRoomTypeId());
			System.out.println(vo.getHotelId());
			System.out.println(vo.getRoomTypeName());
			System.out.println(vo.getPeopleNum());
			System.out.println(vo.getRoomNumber());
			System.out.println(vo.getWeekdaysPrice());
			System.out.println(vo.getHolidayPrice());
			System.out.println(vo.getSeasonPrice());
			System.out.println(vo.getCustomizedPrice());
			System.out.println(vo.getCustomizedName());
			System.out.println(vo.getBreakfast());
			System.out.println(vo.getAfternoonTea());
			System.out.println(vo.getDinner());
			System.out.println(vo.getBedAddable());
			System.out.println(vo.getPricePerPerson());
			System.out.println(vo.getRemark());
			System.out.println(vo.getDeleteStatus());
			System.out.println("--------------------------------------------");
		}
	}

	public static void main(String[] args) {
//		addRoomType();
//		updateRoomType();
		deleteRoomType();
//		findRoomTypeByHotelId();
	}

}
