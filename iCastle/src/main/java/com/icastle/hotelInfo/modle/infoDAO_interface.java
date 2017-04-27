package com.icastle.hotelInfo.modle;

import java.util.List;

public interface infoDAO_interface  {
	public void insert(infoVO infoVO);
	public void update(infoVO infoVO);
	public void select(infoVO infoVO);
	public infoVO findByPrimaryKey(Integer hotelId);
	public List<infoVO> getAll();
}
