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

@WebServlet("/hotelcenter/OrdersChartServlet")
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
//			從前端取值
			Integer hotelId = hotel.getHotelId();
			String y = req.getParameter("year");
			String rti = req.getParameter("roomTypeId");
			String m = req.getParameter("month");
			String s = req.getParameter("state");
			
//			對取到的參數做處理
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
			
//			查DB
			OrdersService os = new OrdersService();
			result = os.search_Chart(hotelId, roomTypeId, year, month, state);
			
//			準備JSON格式
			JSONObject jo = new JSONObject();
			JSONArray jalabels = new JSONArray();
			JSONArray jaseries = new JSONArray();
			
//			從DB取出的資料塞到JSON裡
			for(OrdersChartVO oc : result){
				
				Integer value = (int)oc.getCount();
				
				jalabels.add(oc.getValue());
				jaseries.add(value);
			}
			
			for(Object test : jaseries){
				System.out.println(test);
			}
			
			jo.put("labels", jalabels);
			jo.put("series", jaseries);
			
//			拋出前端
			out.println(jo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
