package com.icastle.Orders.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.Orders.model.OrdersChartVO;
import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/OrdersChartServlet")
public class OrdersChartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		HotelVO hotel = (HotelVO)session.getAttribute("HotelLoginOK");
		List<OrdersChartVO> result = null;
		
		try{
			Integer hotelId = hotel.getHotelId();
			String y = req.getParameter("year");
			String rti = req.getParameter("roomTypeId");
			String m = req.getParameter("month");
			String s = req.getParameter("state");
			
			Integer roomTypeId = (!"null".equals(rti))?new Integer(rti) : null;
			Boolean state = (!"null".equals(s))?new Boolean(s) : null;
			Integer year = (!"null".equals(y))?new Integer(y) : null;
			Integer month = (!"null".equals(m))?new Integer(m) : null;

//			測試用
//			Integer hotelId = 1;
//			Integer roomTypeId = (rti != null)?new Integer(rti) : null;
//			Boolean state = (s != null)?new Boolean(s) : null;
//			Integer year = (y != null)?new Integer(y) : null;
//			Integer month = (m != null)?new Integer(m) : null;
			
			OrdersService os = new OrdersService();
			result = os.search_Chart(hotelId, roomTypeId, year, month, state);
			
			JSONArray ja = new JSONArray();
			for(OrdersChartVO oc : result){
				JSONObject jo = new JSONObject();
				jo.put("name", oc.getValue());
				jo.put("values", String.valueOf(oc.getCount()));
				
				ja.add(jo);
			}
			out.println(ja);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
