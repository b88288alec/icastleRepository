package com.icastle.roomtype.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelVO;
import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/hotelcenter/ShowRoomType")
public class ShowRoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		
		RoomTypeService rots = new RoomTypeService();
		List<RoomTypeVO> roomTypeList = rots.findRoomTypeByHotelId(hotelvo.getHotelId());
		request.setAttribute("roomTypeList", roomTypeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("setRoomType.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
