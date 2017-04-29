package com.icastle.Orders.main;

import java.util.GregorianCalendar;
import java.util.List;

import com.icastle.Orders.model.OrdersDAO_interface;
import com.icastle.Orders.model.OrdersHibernateDAO;
import com.icastle.Orders.model.OrdersJDBC;
import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;

public class OrdersTest {

	public static void main(String[] args) {

		// 查詢-orderId
//		OrdersDAO_interface dao = new OrdersJDBC();
		OrdersDAO_interface dao = new OrdersHibernateDAO();
//		OrdersVO result = dao.select_by_orderId(1);
//
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
//		List<OrdersVO> orders = dao.select_by_memberId(1);
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
//		ordersVO.setMemberId(1);
//		ordersVO.setRoomId(1);
//		ordersVO.setHotelId(1);
//		ordersVO.setRoomTypeId(1);
//		ordersVO.setRoomTypeName("好帥");
//		ordersVO.setCheckinDay(new java.sql.Date(new GregorianCalendar(2018, 1, 1).getTimeInMillis()));
//		ordersVO.setCheckoutDay(new java.sql.Date(new GregorianCalendar(2018, 9, 13).getTimeInMillis()));
//		ordersVO.setRoomCount(1);
//		ordersVO.setPeopleNum(2);
//		ordersVO.setBreakfast(true);
//		ordersVO.setDinner(false);
//		ordersVO.setAfternoonTea(false);
//		ordersVO.setPrice(9000);
//		ordersVO.setReservationer("王美美");
//		ordersVO.setBdate(new java.sql.Date(new GregorianCalendar(1922, 10, 10).getTimeInMillis()));
//		ordersVO.setTel("0999555555");
//		ordersVO.setEmail("dfas@");
//		ordersVO.setAddr("fdsajkdasflewe");
//		ordersVO.setPersonId("G111111111");
//		ordersVO.setCountry("taiwan");
//		ordersVO.setPassport("1561561343412");
//		ordersVO.setBedAdding(false);
//		ordersVO.setPricePerPerson(1000);
//		ordersVO.setCustomerRemark("我朋友需要大張一點的床");
//		ordersVO.setHotelRemark("哈哈");
//		dao.insert(ordersVO);

		// 修改訂單狀態
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO order = new OrdersVO();
//		order.setOrderId(3);
//		order.setMemo("毛很多");
//		order.setOrderState(false);
//		dao.update(order);

		// //業者查詢-年
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_hotelId_year(1, 2017);
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
//		List<OrdersVO> orders = dao.select_by_hotelId_month(3, 2017, 9);
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
//		List<OrdersVO> orders = dao.select_by_hotelId_day(3, 2017, 9, 1);
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
		
	}

}
