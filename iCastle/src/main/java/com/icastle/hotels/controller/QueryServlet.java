package com.icastle.hotels.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.*;

@WebServlet("/Query.do")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public QueryServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("errorMsgs", errorMsgs);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//接收參數
		request.setCharacterEncoding("UTF-8");
		String type = (String) request.getParameter("type");
		String start = (String) request.getParameter("start");
		String end = (String) request.getParameter("end");
		String peopleNumStr = (String) request.getParameter("peopleNum");
		
		
		//資料型態轉換(start和end)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date startDate = null;
		try{
			startDate = new java.sql.Date(sdf.parse(start).getTime());
		} catch (ParseException e){
			errorMsgs.put("sdError", "請輸入正確日期");
		}
		
		java.sql.Date endDate = null;
		try{
			endDate = new java.sql.Date(sdf.parse(end).getTime());
		} catch (ParseException e){
			errorMsgs.put("edError", "請輸入正確日期");
		}
		
		Integer peopleNum = null;
		try{
			peopleNum = Integer.parseInt(peopleNumStr);
		} catch (NumberFormatException e){
			errorMsgs.put("numError", "請輸入正確人數");
		}
		
		if (type == null || type == "")
			errorMsgs.put("typeError", "請輸入型態");
		
		if (!errorMsgs.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("type", type);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("peopleNum", peopleNum);

		HotelService dao = new HotelService();
		List<ListVO> hotels = dao.indexQuery(type, startDate, endDate, peopleNum);
		request.setAttribute("hotels", hotels);
		RequestDispatcher rd = request.getRequestDispatcher("hotel/hotelList.jsp");
		rd.forward(request, response);
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
