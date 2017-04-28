package com.icastle.followers.model;

import java.util.List;

public interface FollowersDAO_interface {
	
	public void insert(FollowersVO followersVO);
	public void update(FollowersVO followersVO);
	public void delete(Integer memberId);
	public List<FollowersVO> getAll(Integer memberId);
	

}
