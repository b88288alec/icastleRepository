package com.icastle.Orders.main;

import java.util.List;

import com.icastle.Orders.model.OrdersDAO_interface;
import com.icastle.Orders.model.OrdersJDBC;
import com.icastle.Orders.model.OrdersVO;

public class OrdersTest {

	public static void main(String[] args) {

//		查詢-orderId
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO result = dao.select_by_orderId(2);
//		
//		System.out.println("orderId: " + result.getOrderId());
//		System.out.println("memberId: " + result.getMemberId());
//		System.out.println("roomId: " + result.getRoomId());
//		System.out.println("price: " + result.getPrice());
//		System.out.println("dates: " + result.getDates());
//		System.out.println("roomNum: " + result.getRoomNum());
//		System.out.println("orderState: " + result.getOrderState());
//		System.out.println("reservationer: " + result.getReservationer());
//		System.out.println("bdate: " + result.getBdate());
//		System.out.println("tel: " + result.getTel());
//		System.out.println("personId: " + result.getPersonId());
//		System.out.println("email: " + result.getEmail());
//		System.out.println("country: " + result.getCountry());
//		System.out.println("addr: " + result.getAddr());
//		System.out.println("passport: " + result.getPassport());
//		System.out.println("bedAdding: " + result.getBedAdding());
//		System.out.println("remark: " + result.getRemark());
		
//		查詢-memberId
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_by_memberId(1);
//		
//		for(OrdersVO result:orders){
//			System.out.println("orderId: " + result.getOrderId());
//			System.out.println("memberId: " + result.getMemberId());
//			System.out.println("roomId: " + result.getRoomId());
//			System.out.println("price: " + result.getPrice());
//			System.out.println("dates: " + result.getDates());
//			System.out.println("roomNum: " + result.getRoomNum());
//			System.out.println("orderState: " + result.getOrderState());
//			System.out.println("reservationer: " + result.getReservationer());
//			System.out.println("bdate: " + result.getBdate());
//			System.out.println("tel: " + result.getTel());
//			System.out.println("personId: " + result.getPersonId());
//			System.out.println("email: " + result.getEmail());
//			System.out.println("country: " + result.getCountry());
//			System.out.println("addr: " + result.getAddr());
//			System.out.println("passport: " + result.getPassport());
//			System.out.println("bedAdding: " + result.getBedAdding());
//			System.out.println("remark: " + result.getRemark());
//			System.out.println("---------------------------------------------");
//		}
		
//		查詢全部
//		OrdersDAO_interface dao = new OrdersJDBC();
//		List<OrdersVO> orders = dao.select_all();
//		
//		for(OrdersVO result:orders){
//			System.out.println("orderId: " + result.getOrderId());
//			System.out.println("memberId: " + result.getMemberId());
//			System.out.println("roomId: " + result.getRoomId());
//			System.out.println("price: " + result.getPrice());
//			System.out.println("dates: " + result.getDates());
//			System.out.println("roomNum: " + result.getRoomNum());
//			System.out.println("orderState: " + result.getOrderState());
//			System.out.println("reservationer: " + result.getReservationer());
//			System.out.println("bdate: " + result.getBdate());
//			System.out.println("tel: " + result.getTel());
//			System.out.println("personId: " + result.getPersonId());
//			System.out.println("email: " + result.getEmail());
//			System.out.println("country: " + result.getCountry());
//			System.out.println("addr: " + result.getAddr());
//			System.out.println("passport: " + result.getPassport());
//			System.out.println("bedAdding: " + result.getBedAdding());
//			System.out.println("remark: " + result.getRemark());
//			System.out.println("---------------------------------------------");
//		}
		
//		新增
//		OrdersDAO_interface dao = new OrdersJDBC();
//		OrdersVO order = new OrdersVO();
//		order.setMemberId(1);
//		order.setRoomId(2);
//		order.setPrice(6000);
//		order.setDates(2);
//		order.setRoomNum(301);
//		order.setOrderState(true);
//		order.setReservationer("王曉明");
//		order.setBdate(new java.sql.Date(new java.util.GregorianCalendar(1987, 10, 6).getTime().getTime()));
//		order.setTel("0987087087");
//		order.setPersonId("Z555555555");
//		order.setEmail("fdas@gmail.com");
//		order.setCountry(null);
//		order.setAddr("台北市大忠路一段");
//		order.setPassport(null);
//		order.setBedAdding(false);
//		order.setRemark("我想放假!!!");
//		dao.insert(order);
		
		//修改訂單狀態
		OrdersDAO_interface dao = new OrdersJDBC();
		OrdersVO order = new OrdersVO();
		order.setOrderId(3);
		order.setOrderState(false);
		dao.update(order);
		
	}

}
