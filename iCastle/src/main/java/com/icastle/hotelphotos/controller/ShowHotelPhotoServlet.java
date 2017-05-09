package com.icastle.hotelphotos.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotelphotos.model.HotelPhotosService;
import com.icastle.hotelphotos.model.HotelPhotosVO;
import com.icastle.hotels.model.HotelVO;
import com.icastle.roomtype.model.*;

@WebServlet("/hotelcenter/ShowHotelPhoto.do")
public class ShowHotelPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowHotelPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		
		//取得該飯店所有照片的vo
		HotelPhotosService photoServ = new HotelPhotosService();
		List<HotelPhotosVO> photovos = photoServ.findByHotelId(hotelvo.getHotelId());
		HotelPhotosVO firstPhotovo = (HotelPhotosVO)photoServ.findByHotelIdTop1(hotelvo.getHotelId());
		request.setAttribute("firstPhotovo", firstPhotovo);
		session.setAttribute("photovos", photovos);
		session.setAttribute("originpage", photovos.size());
		
		//取得該飯店房型
		RoomTypeService roomTypeServ = new RoomTypeService();
		List<RoomTypeVO> roomTypeVOs = roomTypeServ.findRoomTypeByHotelId(hotelvo.getHotelId());
		request.setAttribute("roomTypeVOs", roomTypeVOs);
		System.out.println("roomTypeVOs.size= " + roomTypeVOs.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("hotelphoto.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
