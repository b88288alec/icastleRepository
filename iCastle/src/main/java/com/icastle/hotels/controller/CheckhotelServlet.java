package com.icastle.hotels.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelInfo.modle.InfoService;
import com.icastle.hotels.model.*;

@WebServlet("/manager/Checkhotel.do")
public class CheckhotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckhotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取得未通過審核的飯店
		HotelService hotelServ = new HotelService();
		List<HotelVO> hotels = hotelServ.getUncheckedHotel();
		request.setAttribute("hotels", hotels);
		
//		//取得未通過審核的飯店的資訊
//		InfoService infoServ = new InfoService();
//		infoServ.findByHotelId(hotelId);
		
		//轉交到審核飯店的畫面
		RequestDispatcher rd = request.getRequestDispatcher("checkhotels.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
