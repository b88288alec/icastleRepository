package com.icastle.hotels.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotels.model.*;

@WebServlet("/view/Test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//addHotel
				HotelService dao = new HotelService();
				HotelVO hotel = new HotelVO();
				hotel.setHotelName("好帥");
				hotel.setEmail("handsome@gmail.com");
				hotel.setPw("handsome");
				hotel.setAddr("台北市松山區南京東路四段2號");
				hotel.setZone("台北市");
				hotel.setStar(5);
				hotel.setRegisterId("好帥第210號");
				dao.addHotel(hotel);
				
				//updateHotel
//				HotelService dao = new HotelService();
//				HotelVO hotel = new HotelVO();
//				hotel.setHotelId(4);
//				hotel.setHotelName("555");
//				hotel.setPw("fff");
//				dao.updateHotel(1, "帥報了", "9x6x");
				
				//updateState
//				HotelService dao = new HotelService();
//				dao.updateState(4, 5);
				
				//findByPrimaryKey
//				HotelService dao = new HotelService();
//				HotelVO hotel = dao.findByPrimaryKey(5);
//				System.out.println(hotel.getEmail());
				
				//indexQuery
//				HotelService dao = new HotelService();
//				String zone = "雄市";
//				java.sql.Date startDate = java.sql.Date.valueOf("2017-01-02");
//				java.sql.Date endDate = java.sql.Date.valueOf("2017-01-04");
//				int peopleNum = 4;
//				List<ListVO> hotels = dao.indexQuery(zone, startDate, endDate, peopleNum);
//				for (ListVO list : hotels)
//					System.out.println(list.getHotelName());
		
				//advancedQuery
//				HotelService dao = new HotelService();
//				String zone = "雄市";
//				java.sql.Date startDate = java.sql.Date.valueOf("2017-01-02");
//				java.sql.Date endDate = java.sql.Date.valueOf("2017-01-04");
//				int peopleNum = 4;
//				String order = "";
//				int lowprice = 4000;
//				int highprice = 20000;
//				double point = 0;
//				int star = 5;
//				List<ListVO> hotels = dao.advancedQuery(zone, startDate, endDate, peopleNum, order, lowprice, highprice, point, star);
//				for (ListVO list : hotels)
//					System.out.println(list.getHotelName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
