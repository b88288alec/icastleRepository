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

import org.json.simple.JSONObject;

import com.icastle.Orders.model.OrdersChartVO;
import com.icastle.Orders.model.OrdersService;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/member/OrdersCancelServlet")
public class OrdersCancelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		HotelVO hotel = (HotelVO)session.getAttribute("HotelLoginOK");
		
		try{
			Integer orderId = new Integer(req.getParameter("orderId"));
			OrdersService os = new OrdersService();
			String cancelTime = os.customerUpdate(orderId);
			
			JSONObject jo = new JSONObject();
			jo.put("cancelTime", cancelTime);
			
			out.println(jo);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
