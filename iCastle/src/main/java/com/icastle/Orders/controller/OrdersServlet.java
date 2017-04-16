package com.icastle.Orders.controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.Orders.model.OrdersServise;

@WebServlet("/orders/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		Integer memberId = new Integer(req.getParameter("memberId"));
		Integer roomId = new Integer(req.getParameter("roomId"));
		Integer price = new Integer(req.getParameter("price"));
		Integer dates = new Integer(req.getParameter("dates"));
		Integer roomNum = new Integer(req.getParameter("roomNum"));
		Boolean orderState = true;
		String reservationer = req.getParameter("reservationer");
		
		String[] birthday = req.getParameter("bdate").trim().split("/");
		int year = 0, month = 0, date = 0;
		for(int i = 0; i < 3; i++){
			if(i == 0){
				year =  Integer.parseInt(birthday[i]);
			}if(i == 1){
				month = Integer.parseInt(birthday[i]) - 1;
			}else{
				date = Integer.parseInt(birthday[i]);
			}
		}
		java.sql.Date bdate = new java.sql.Date(new GregorianCalendar(year, month, date).getTimeInMillis());
		
		String tel = req.getParameter("tel");
		String personId = req.getParameter("personId");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		String addr = req.getParameter("addr");
		String passport = req.getParameter("passport");
		Boolean bedAdding = Boolean.valueOf(req.getParameter("bedAdding"));
		String remark = req.getParameter("remark");
		
		OrdersServise os = new OrdersServise();
		os.newOrder(memberId, roomId, price, dates, roomNum, orderState, reservationer, bdate, tel, personId, email, country, addr, passport, bedAdding, remark);
		
		res.sendRedirect("success.jsp");
	}

}
