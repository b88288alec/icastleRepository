package com.icastle.Orders.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.icastle.Orders.model.OrdersChartVO;
import com.icastle.Orders.model.OrdersDAO_interface;
import com.icastle.Orders.model.OrdersHibernateDAO;
import com.icastle.Orders.model.OrdersJDBC;
import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;

public class OrdersTest {

	public static void main(String[] args) {

		OrdersDAO_interface dao = new OrdersHibernateDAO();

		// 查詢-orderId
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO result = dao.select_by_orderId(64);
//		System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//				+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//				+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//				+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//				+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//				+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//				+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//				+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//				+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//		System.out.println("---------------------------------------------");

		// 查詢-memberId
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_memberId(6);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 查詢全部
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_all();
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 新增
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO ordersVO = new OrdersVO();
//		ordersVO.setOrderedDate(new java.sql.Timestamp(new GregorianCalendar().getInstance().getTimeInMillis()));
//		ordersVO.setMemberId(1);
//		ordersVO.setRoomId(8);
//		ordersVO.setHotelId(1);
//		ordersVO.setHotelName("好累");
//		ordersVO.setRoomTypeId(3);
//		ordersVO.setRoomTypeName("四人房（無窗）");
//		ordersVO.setCheckinDay(new java.sql.Date(new GregorianCalendar(2017, 0, 2).getTimeInMillis()));
//		ordersVO.setCheckoutDay(new java.sql.Date(new GregorianCalendar(2017, 0, 4).getTimeInMillis()));
//		ordersVO.setRoomCount(1);
//		ordersVO.setPeopleNum(4);
//		ordersVO.setBreakfast(false);
//		ordersVO.setDinner(false);
//		ordersVO.setAfternoonTea(false);
//		ordersVO.setPrice(14800);
//		ordersVO.setReservationer("王曉華");
//		ordersVO.setBdate(new java.sql.Date(new GregorianCalendar(1922, 0, 3).getTimeInMillis()));
//		ordersVO.setTel("0955555555");
//		ordersVO.setEmail("qqq@gmail.com");
//		ordersVO.setAddr("fdasfdsaf");
//		ordersVO.setPersonId("A192648793");
//		ordersVO.setCountry("台灣");
//		ordersVO.setPassport("546343");
//		ordersVO.setBedAdding(false);
//		ordersVO.setPricePerPerson(0);
//		ordersVO.setCustomerRemark("我朋友需要大張一點的床");
//		ordersVO.setHotelRemark("若單筆預訂超過5間客房，可能會需要遵守其他相關規定以及符合額外的要求。");
//		ordersVO.setOrderState(true);
//		dao.insert(ordersVO);

		// 修改訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO order = dao.select_by_orderId(6);
//		order.setMemo("毛很多");
//		order.setOrderState(false);
//		order.setCancelDate(new java.sql.Timestamp(new GregorianCalendar().getInstance().getTimeInMillis()));
//		dao.update(order);

		// //業者查詢-年
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_year(2, 2017);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 業者查詢-年-月
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_month(2, 2017, 6);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

//		// 業者查詢-年-月-日
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_day(2, 2017, 6, 1);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}
		
		// //業者查詢-年-房型
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_year_roomTypeId(3, 2, 2017);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 業者查詢-年-月-房型
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_month_roomTypeId(3, 2, 2017, 9);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

//		// 業者查詢-年-月-日-房型
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_day_roomTypeId(3, 2, 2017, 9, 1);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// //業者查詢-年-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_year_orderstate(3, 2017, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 業者查詢-年-月-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_month_orderstate(3, 2017, 9, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

//		// 業者查詢-年-月-日-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_day_orderstate(3, 2017, 9, 1, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}		
		
		// //業者查詢-年-房型-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_year_roomTypeId_orderstate(3, 2, 2017, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

		// 業者查詢-年-月-房型-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_month_roomTypeId_orderstate(3, 2, 2017, 9, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}

//		// 業者查詢-年-月-日-房型-訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_day_roomTypeId_orderstate(3, 2, 2017, 9, 1, true);
//
//		for (OrdersVO result : orders) {
//			System.out.println(result.getHotelId() + "   " + result.getMemberId() + "   " + result.getRoomId() + "   "
//					+ result.getHotelId() + "   " + result.getRoomTypeId() + "   " + result.getRoomTypeName() + "   "
//					+ result.getCheckinDay() + "   " + result.getCheckoutDay() + "   " + result.getRoomCount() + "   "
//					+ result.getPeopleNum() + "   " + result.getBreakfast() + "   " + result.getDinner() + "   "
//					+ result.getAfternoonTea() + "   " + result.getPrice() + "   " + result.getReservationer() + "   "
//					+ result.getBdate() + "   " + result.getTel() + "   " + result.getEmail() + "   " + result.getAddr()
//					+ "   " + result.getPersonId() + "   " + result.getCountry() + "   " + result.getPassport() + "   "
//					+ result.getBedAdding() + "   " + result.getPricePerPerson() + "   " + result.getCustomerRemark()
//					+ "   " + result.getHotelRemark() + "   " + result.getMemo() + "   " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}
		
//		測試時間
//		TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");
//		java.sql.Timestamp result = new java.sql.Timestamp(new GregorianCalendar().getInstance().getTimeInMillis());
//		System.out.println(result);
		
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
//		java.sql.Timestamp result = new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis());
//		System.out.println(result);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		try {
//			java.util.Date test = sdf.parse("2016/1/0");
//			System.out.println(test);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
//		
//		System.out.println(result.getOrderedDate());
//		System.out.println(sdf.format(result.getOrderedDate()));
		
//		OrdersHibernateDAO oh = new OrdersHibernateDAO();
//		List<OrdersChartVO> test = oh.chart_select_by_hotelId(1);
//		
//		for(OrdersChartVO rs : test){
//			System.out.println(rs.getCount());
//			System.out.println(rs.getValue());
//		}
		
	}

}
