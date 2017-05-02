package com.icastle.orderfollowers.model;

import java.util.List;

public class OrderFollowersService {

	OrderFollowersDAO_interface dao = null;
	
	public OrderFollowersService(){
		dao = new OrderFollowersDAO();
	}
	
//	新增同行人
	public void newFollowers(Integer orderid, String name, java.sql.Date bdate, String tel, String email, String addr, String personId, String country, String passport){
		
		OrderFollowersVO ofvo = new OrderFollowersVO();
		ofvo.setOrderId(orderid);
		ofvo.setName(name);
		ofvo.setBdate(bdate);
		ofvo.setTel(tel);
		ofvo.setEmail(email);
		ofvo.setAddr(addr);
		ofvo.setPersonId(personId);
		ofvo.setCountry(country);
		ofvo.setPassport(passport);
		
		dao.insert(ofvo);
		
	}
	
//	查詢同行人
	public List<OrderFollowersVO> searchFollowers(Integer orderId){
		
		List<OrderFollowersVO> result = null;
		
		result = dao.select_By_OrderId(orderId);
		
		return result;
		
	}
	
}
