package com.icastle.orderfollowers.model;

import java.util.List;

public interface OrderFollowersDAO_interface {
	
//	新增訂單同行人
	public void insert(OrderFollowersVO orderFollowersVO);
	
//	搜尋出訂單同行人
	public List<OrderFollowersVO> select_By_OrderId(Integer orderId);

}
