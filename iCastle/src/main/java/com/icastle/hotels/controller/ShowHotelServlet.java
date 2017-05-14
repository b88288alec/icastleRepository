package com.icastle.hotels.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelInfo.modle.*;
import com.icastle.hotelphotos.model.HotelPhotosService;
import com.icastle.hotelphotos.model.HotelPhotosVO;
import com.icastle.hotels.model.*;
import com.icastle.rooms.model.*;

@WebServlet("/hotel/ShowHotel.do")
public class ShowHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowHotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收參數
		Integer hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String startStr = request.getParameter("start");
		String endStr = request.getParameter("end");
		Integer peopleNum = Integer.parseInt(request.getParameter("peopleNum"));
		
		//型態轉換
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date start = null;
		try{
			start = new java.sql.Date(sdf.parse(startStr).getTime());
		} catch (ParseException e){
		}
		
		java.sql.Date end = null;
		try{
			end = new java.sql.Date(sdf.parse(endStr).getTime());
		} catch (ParseException e){
		}
	
		//查詢這間飯店可以住的房間
		RoomsService roomsdao = new RoomsService();
		List<RoomsVO> roomsvo =  roomsdao.findRooms(hotelId, peopleNum, start, end);
		request.setAttribute("rooms", roomsvo);
		System.out.println("抓到"+roomsvo.size()+"筆符合條件的房間");
		
		//查詢hotel的資料
		HotelService hotelServ = new HotelService();
		HotelVO hotel = hotelServ.findByPrimaryKey(hotelId);
		request.setAttribute("hotel", hotel);
		
		//查詢hotel info
		InfoService infoServ = new InfoService();
		InfoVO hotelInfo = infoServ.findByHotelId(hotelId);
		request.setAttribute("hotelInfo", hotelInfo);
		
		//查詢hotel photo
		HotelPhotosService photoserv = new HotelPhotosService();
		List<HotelPhotosVO> photos = photoserv.findByHotelId(hotel.getHotelId());
		request.setAttribute("photos", photos);
		
		//查詢所有飯店的地址包成陣列 (centerHotel放在第一個)
		List<HotelVO> hotels = hotelServ.getAll();		
		List<String> list = new ArrayList<String>();
		for (HotelVO h : hotels){
			if (h.getHotelId() == hotel.getHotelId())
				list.add(0, h.getAddr());
			else
				list.add(h.getAddr());
		} 
		request.setAttribute("address", list);
		
//		for (String s : list)
//			System.out.println(s);
		
		//轉交給hotel.jsp
		RequestDispatcher rd = request.getRequestDispatcher("hotel.jsp");
		rd.forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
