package com.icastle.members.model;

import java.util.List;

public interface MembersDAO_interface {
	  public void insert(MembersVO membersVO);  //新增會員
      public void update(MembersVO membersVO);  //更新會員
//      public void delete(String email);         //刪除會員
      public MembersVO findByPrimaryKey(String email);  //查詢會員一筆
      public List<MembersVO> getAll();          //查詢會員多筆
      public MembersVO login(String email, String pw); //會員登入
      public MembersVO findByEmail(String email); //查詢email是否已經註冊過
      public MembersVO lineLogin(String name,String pw);  // 檢查line登入
      
//    管理者用
      public List<MembersVO> search_by_name(String name);	//用姓名搜尋
      public List<MembersVO> search_manager();	//搜尋管理員
      public void suspension(Integer memberId, Boolean suspension);	//停權功能
      public void setManager(Integer memberId, Boolean manager);	//升格管理員
      
}