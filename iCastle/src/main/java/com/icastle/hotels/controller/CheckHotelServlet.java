package com.icastle.hotels.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;
import com.icastle.members.model.MembersVO;
import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

@WebServlet("/manager/CheckHotel.do")
public class CheckHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckHotelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
    	
    	String[] passs = request.getParameterValues("pass");
    	String[] suspends = request.getParameterValues("suspend");
    	HttpSession session = request.getSession();
    	MembersVO manager = (MembersVO)session.getAttribute("ManagerLoginOK");

    	HotelService hotelServ = new HotelService();
    	
    	//通過審的飯店的飯店狀態改為1
    	if (passs != null){
	    	for (String hotel : passs){
	    		System.out.println(hotel);
	    		Integer id = new Integer(hotel.substring(0, hotel.indexOf("@")));
	    		String hotelName = hotel.substring((hotel.indexOf("@") + 1));
	    		
		    	hotelServ.updateState(id, 1);
		    	
//		    	存入歷史紀錄
		    	String content = manager.getName() + " 審核通過 " + hotelName + " 的飯店資訊";
		    	RecordVO record = new RecordVO();
		    	record.setId(("m" + manager.getMemberId()));
		    	record.setName(manager.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("飯店相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
	    	}
    	}
    	
    	//被停權的飯店的飯店狀態改為0
    	if (suspends != null){
	    	for (String hotel : suspends){
	    		System.out.println(hotel);
	    		Integer id = new Integer(hotel.substring(0, hotel.indexOf("@")));
	    		String hotelName = hotel.substring((hotel.indexOf("@") + 1));
	    		
	    		hotelServ.updateState(id, 0);
	    		
//		    	存入歷史紀錄
		    	String content = manager.getName() + " 把 " + hotelName + " 的狀態改為停權";
		    	RecordVO record = new RecordVO();
		    	record.setId(("m" + manager.getMemberId()));
		    	record.setName(manager.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("飯店相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
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
