package com.icastle.members.model;

import java.util.List;

public interface MembersDAO_interface {
	  public void insert(MembersVO membersVO);  //新增會員
      public void update(MembersVO membersVO);  //更新會員
      public void delete(String email);         //刪除會員
      public MembersVO findByPrimaryKey(String email);  //查詢會員一筆
      public List<MembersVO> getAll();          //查詢會員多筆
}