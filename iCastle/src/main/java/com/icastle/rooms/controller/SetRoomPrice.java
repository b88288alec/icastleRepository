package com.icastle.rooms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/rooms/SetRoomPrice")
public class SetRoomPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		RoomTypeService rots = new RoomTypeService();
		List<RoomTypeVO> roomTypeList = rots.findRoomTypeByHotelId(5);
		
		session.setAttribute("roomTypeList", roomTypeList);
		RequestDispatcher rd = request.getRequestDispatcher("calendar.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
