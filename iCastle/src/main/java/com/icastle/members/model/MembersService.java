package com.icastle.members.model;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import com.icastle.hotels.model.HotelVO;



public class MembersService {

	MembersDAO_interface dao = null;
	
	public MembersService (){
		dao = new MembersJNDIDAO();
	}
	
//  新增會員	
	public void insert(String email, String pw, String name, String gender, Date bDate, String addr, String tel, String personId, String country, String passport){
		MembersVO membersVO = new MembersVO();
		membersVO.setEmail(email);
		membersVO.setPw(pw);
		membersVO.setName(name);
		membersVO.setGender(gender);
		membersVO.setBdate(bDate);
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
	
//  忘記密碼
   
   public String createPw(String email){
	   MembersVO membersVO = dao.findByPrimaryKey(email);
	   Random ran = new Random();
		int range = 999999;
		String newpw = String.valueOf(ran.nextInt(range));
		membersVO.setPw(newpw);
		dao.update(membersVO);
		return newpw;
	}
//  驗證line登入
   public  MembersVO lineLogin(String name, String pw){
          return dao.lineLogin(name, pw);

   }
//  檢查帳號是否重複   
   public MembersVO findByEmail(String email){
		return dao.findByEmail(email);
	}
   
//   用姓名搜尋
   public List<MembersVO> search_by_name(String name){
	   
	   String finalName = "%" + name + "%";
	   
	   return dao.search_by_name(finalName);
   }
   
//   會員停權
   public void suspension(Integer memberId, Boolean suspension){
	   dao.suspension(memberId, suspension);
   }
   
//   升格管理員
   public void setManager(Integer memberId, Boolean manager){
	   dao.setManager(memberId, manager);
   }
   
// 搜尋管理者
 public List<MembersVO> search_manager(){
	   return dao.search_manager();
 }
	
}
