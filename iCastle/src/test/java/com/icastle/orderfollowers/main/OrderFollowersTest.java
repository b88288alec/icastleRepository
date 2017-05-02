package com.icastle.orderfollowers.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.icastle.orderfollowers.model.OrderFollowersDAO;
import com.icastle.orderfollowers.model.OrderFollowersDAO_interface;
import com.icastle.orderfollowers.model.OrderFollowersVO;

public class OrderFollowersTest {

	public static void main(String[] args) {
		
//		新增
		OrderFollowersDAO_interface test = new OrderFollowersDAO();
		OrderFollowersVO orderFollowersVO = new OrderFollowersVO();
		orderFollowersVO.setOrderId(1);
		orderFollowersVO.setName("哈哈哈");
		orderFollowersVO.setAddr("1351561");
		orderFollowersVO.setEmail("156165@jdisafj;a");
		orderFollowersVO.setPersonId("A1155135");
		orderFollowersVO.setTel("15615543");
		orderFollowersVO.setCountry("台灣");
		orderFollowersVO.setPassport("adfafdkljkljas");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		try {
			orderFollowersVO.setBdate(new java.sql.Date(sdf.parse("1955/2/6").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		test.insert(orderFollowersVO);

//		查詢
//		OrderFollowersDAO_interface test = new OrderFollowersDAO();
		List<OrderFollowersVO> orderFollowersVOs = test.select_By_OrderId(1);
		
		for(OrderFollowersVO result: orderFollowersVOs){
			System.out.println("id = " + result.getId());
			System.out.println("orderid = " + result.getOrderId());
			System.out.println("name = " + result.getName());
			System.out.println("bdate = " + result.getBdate());
			System.out.println("addr = " + result.getAddr());
			System.out.println("email = " + result.getEmail());
			System.out.println("tel = " + result.getTel());
			System.out.println("personid = " + result.getPersonId());
			System.out.println("country = " + result.getCountry());
			System.out.println("passport = " + result.getPassport());
			System.out.println("-----------------------------------------------");
		}
		
	}

}
