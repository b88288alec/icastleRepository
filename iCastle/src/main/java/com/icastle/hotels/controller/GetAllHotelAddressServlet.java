package com.icastle.hotels.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.icastle.hotels.model.*;

@WebServlet("/hotel/GetAllHotelAddressServlet")
public class GetAllHotelAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetAllHotelAddressServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		

		
		//取得飯店
		HotelService hotelServ = new HotelService();
		List<HotelVO> hotels = hotelServ.getAll(); 
		
		List list = new ArrayList();
		
		//將所有飯店的地址包成陣列 (centerHotel放在第一個)
		for (HotelVO hotel : hotels){
			if (hotel.getHotelId() == 2)
				list.add(0, hotel.getAddr());
			else
				list.add(hotel.getAddr());
		} 
		System.out.println("size=" + list.size());
		System.out.println(list.get(0));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
