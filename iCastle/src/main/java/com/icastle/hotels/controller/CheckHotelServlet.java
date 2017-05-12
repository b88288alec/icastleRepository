package com.icastle.hotels.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/manager/CheckHotel.do")
public class CheckHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckHotelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String[] passs = request.getParameterValues("pass");
    	String[] suspends = request.getParameterValues("suspend");


    	HotelService hotelServ = new HotelService();
    	
    	//通過審的飯店的飯店狀態改為1
    	if (passs != null){
	    	for (String hotel : passs){
	    		System.out.println(hotel);
		    	hotelServ.updateState(Integer.parseInt(hotel), 1);
	    	}
    	}
    	
    	//被停權的飯店的飯店狀態改為0
    	if (suspends != null){
	    	for (String hotel : suspends){
	    		System.out.println(hotel);
	    		hotelServ.updateState(Integer.parseInt(hotel), 0);
	    	}
    	}
    	
    	//轉交到審核飯店的畫面
		RequestDispatcher rd = request.getRequestDispatcher("GetAllhotel.do");
		rd.forward(request, response);
		return;
    	
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
