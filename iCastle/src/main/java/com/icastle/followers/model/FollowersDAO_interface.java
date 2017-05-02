package com.icastle.followers.model;

import java.util.List;

public interface FollowersDAO_interface {
	
	public void insert(FollowersVO followersVO);  //新增同行人
	public void update(FollowersVO followersVO);  //修改同行人資料
	public void delete(Integer memberId);         //刪除同行人資料
	public List<FollowersVO> getAll(Integer memberId);  //查詢同行人資料
	

}
