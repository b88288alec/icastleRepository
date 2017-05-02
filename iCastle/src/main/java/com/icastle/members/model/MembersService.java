package com.icastle.members.model;

import java.sql.Date;
import java.util.List;



public class MembersService {

	MembersDAO_interface dao = null;
	
	public MembersService (){
		dao = new MembersJNDIDAO();
	}
	
//  新增會員	
	public void insert(String email, String pw, String name, String gender, Date bdate, String addr, String tel, String personId, String country, String passport){
		MembersVO membersVO = new MembersVO();
		membersVO.setEmail(email);
		membersVO.setPw(pw);
		membersVO.setName(name);
		membersVO.setGender(gender);
		membersVO.setBdate(bdate);
		membersVO.setAddr(addr);
		membersVO.setTel(tel);
		membersVO.setPersonId(personId);
		membersVO.setCountry(country);
		membersVO.setPassport(passport);
		dao.insert(membersVO);
		
//		return dao.insert(membersVO);??
		
	}
	
// 更新資料
	public void update(String email, String pw, String name, String gender, Date bdate, String addr, String tel, String personId, String country, String passport, Integer memberId){
		MembersVO membersVO = new MembersVO();
		membersVO.setEmail(email);
		membersVO.setPw(pw);
		membersVO.setName(name);
		membersVO.setGender(gender);
		membersVO.setBdate(bdate);
		membersVO.setAddr(addr);
		membersVO.setTel(tel);
		membersVO.setPersonId(personId);
		membersVO.setCountry(country);
		membersVO.setPassport(passport);
		membersVO.setMemberId(memberId);
		dao.update(membersVO);
		
	}
// 刪除	
//   public void delete(String email){
//	   MembersVO membersVO = new MembersVO();
//	   membersVO.setEmail(email);
//	   dao.delete(email);
	   
//   }
// 查詢一筆
   public MembersVO findByPrimaryKey(String email){
	   return dao.findByPrimaryKey(email);
   }
 	
// 多筆查詢	
   public List<MembersVO> getAll(){
	   return dao.getAll();
   }
	
// 會員登入
   public MembersVO login(String email, String pw){
	   return dao.login (email, pw);
   }
	
	
	
	
	
	
}
