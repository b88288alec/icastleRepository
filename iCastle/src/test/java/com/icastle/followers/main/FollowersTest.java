package com.icastle.followers.main;

import java.util.List;

import com.icastle.followers.model.FollowersJDBCDAO;
import com.icastle.followers.model.FollowersVO;


public class FollowersTest {

	public static void main(String[] args) {
	
//		新增
		FollowersJDBCDAO fjo = new FollowersJDBCDAO();
//		FollowersVO fvo = new FollowersVO();
//		fvo.setName("abc");
//	    fvo.setBdate(java.sql.Date.valueOf("2017-04-28"));
//		fvo.setTel("27758858");
//		fvo.setPersonId("D123546789");
//		fvo.setEmail("qeqe@yahoo.com.tw");
//		fvo.setCountry("台灣");
//		fvo.setAddr("大安區");
//		fvo.setPassport("asd");
//		fvo.setMemeberId(4);
//		fjo.insert(fvo);
//		System.out.println("新增成功");
	
		
//      更新
//	    FollowersVO fvo2 = new FollowersVO();
//	    fvo2.setName("bcd");
//	    fvo2.setBdate(java.sql.Date.valueOf("2017-04-29"));
//	    fvo2.setTel("27758888");
//	    fvo2.setPersonId("A123456789");
//	    fvo2.setEmail("abab@yahoo.com.tw");
//	    fvo2.setCountry("美國");
//	    fvo2.setAddr("台中市");
//	    fvo2.setPassport("bbc");
//	    fvo2.setMemberId(4);
//	    fjo.update(fvo2);
//	    System.out.println("更新成功");
		
		
//      刪除
//		fjo.delete(4);
//		System.out.println("刪除成功");
		
//		查詢
		List<FollowersVO> list = fjo.getAll(4);
		for (FollowersVO aFollowers : list) {
			System.out.println(aFollowers.getName() + ",");
			System.out.println(aFollowers.getBdate() + ",");
			System.out.println(aFollowers.getTel() + ",");
			System.out.println(aFollowers.getPersonId() + ",");
			System.out.println(aFollowers.getEmail() + ",");
			System.out.println(aFollowers.getCountry() + ",");
			System.out.println(aFollowers.getAddr() + ",");
			System.out.println(aFollowers.getPassport() + ",");
			System.out.println();
		
		}
	}

}
