package com.icastle.followers.model;

import java.sql.Date;
import java.util.List;

public class FollowersService {
	
	FollowersDAO_interface dao = null;
	
	public FollowersService(){
		
		dao = new FollowersJNDIDAO();
	}
//  新增同行人	
	public void insert(String name, Date bdate, String tel, String personId, String email, String country, String addr, String passport, Integer memberId){
		
		FollowersVO followersVO = new FollowersVO();
		followersVO.setName(name);
		followersVO.setBdate(bdate);
		followersVO.setTel(tel);
		followersVO.setPersonId(personId);
		followersVO.setEmail(email);
		followersVO.setCountry(country);
		followersVO.setAddr(addr);
		followersVO.setPassport(passport);
		followersVO.setMemberId(memberId);
		dao.insert(followersVO);

	}
//  更新同行人
       public void update(String name, Date bdate, String tel, String personId, String email, String country, String addr, String passport, Integer memberId){
		
		FollowersVO followersVO = new FollowersVO();
		followersVO.setName(name);
		followersVO.setBdate(bdate);
		followersVO.setTel(tel);
		followersVO.setPersonId(personId);
		followersVO.setEmail(email);
		followersVO.setCountry(country);
		followersVO.setAddr(addr);
		followersVO.setPassport(passport);
		followersVO.setMemberId(memberId);
		dao.update(followersVO);
				
	}
//   刪除同行人
      public void delete(Integer memberId){
    	  FollowersVO followersVO = new FollowersVO();
    	  followersVO.setMemberId(memberId);
    	  dao.delete(memberId);
    	  
      }
      
//   查詢同行人資料
      public List<FollowersVO> getAll(Integer memberId){
    	  return dao.getAll(memberId);
      }
	
	
	

}
