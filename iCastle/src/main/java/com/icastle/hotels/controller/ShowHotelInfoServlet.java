package com.icastle.hotels.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotelInfo.modle.*;
import com.icastle.hotelphotos.model.HotelPhotosService;
import com.icastle.hotelphotos.model.HotelPhotosVO;
import com.icastle.hotels.model.*;

@WebServlet("/hotelcenter/ShowHotelInfo.do")
public class ShowHotelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowHotelInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		
		//查詢飯店info
		InfoService infoServ = new InfoService();
		InfoVO hotelInfo = infoServ.findByHotelId(hotelvo.getHotelId());
		session.setAttribute("HotelInfo", hotelInfo);  
		
		//查詢照片
//		HotelPhotosService hotelServ = new HotelPhotosService();
//		HotelPhotosVO photo = hotelServ.findByHotelIdTop1(hotelvo.getHotelId());
//		request.setAttribute("photo", photo);
		
		//轉交到view
		RequestDispatcher rd = request.getRequestDispatcher("updateHotelInfo.jsp");
		rd.forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
