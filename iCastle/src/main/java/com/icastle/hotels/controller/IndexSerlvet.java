package com.icastle.hotels.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/Index.do")
public class IndexSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexSerlvet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//查詢所有飯店
		HotelService hotelServ = new HotelService();
		List<HotelVO> hotels = hotelServ.getAll();
		
		session.setAttribute("hotels", hotels);
		System.out.println(hotels.size());
		
		//轉交到index.jsp
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
