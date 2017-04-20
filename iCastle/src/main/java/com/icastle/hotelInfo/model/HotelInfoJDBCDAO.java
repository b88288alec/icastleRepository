package com.icastle.hotelInfo.model;

import java.util.List;

public class HotelInfoJDBCDAO implements HotelInfoDAO_interface{
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLserverDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName:iCastle";
	String userid = "sa";
	String passwd = "sa123456";

	@Override
	public void insert(HotelInfoVO hotelInfoVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HotelInfoVO hotelInfoVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelInfoVO findByPrimaryKey(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelInfoVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
