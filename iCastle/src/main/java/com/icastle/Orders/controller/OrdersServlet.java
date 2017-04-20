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
		Integer hotelId = new Integer(req.getParameter("hotelId"));
		Integer roomTypeId = new Integer(req.getParameter("roomTypeId"));
		String roomTypeName = req.getParameter("roomTypeName");
		
		String[] checkin = req.getParameter("checkinDay").trim().split("/");
		int year = 0, month = 0, date = 0;
		for(int i = 0; i < 3; i++){
			if(i == 0){
				year =  Integer.parseInt(checkin[i]);
			}if(i == 1){
				month = Integer.parseInt(checkin[i]) - 1;
			}else{
				date = Integer.parseInt(checkin[i]);
			}
		}
		java.sql.Date checkinDay = new java.sql.Date(new GregorianCalendar(year, month, date).getTimeInMillis());
		
		String[] checkout = req.getParameter("checkoutDay").trim().split("/");
		for(int i = 0; i < 3; i++){
			if(i == 0){
				year =  Integer.parseInt(checkout[i]);
			}if(i == 1){
				month = Integer.parseInt(checkout[i]) - 1;
			}else{
				date = Integer.parseInt(checkout[i]);
			}
		}
		java.sql.Date checkoutDay = new java.sql.Date(new GregorianCalendar(year, month, date).getTimeInMillis());
		
		Integer roomCount = new Integer(req.getParameter("roomCount"));
		Integer peopleNum = new Integer(req.getParameter("peopleNum"));
		Boolean breakfast = Boolean.valueOf(req.getParameter("breakfast"));
		Boolean dinner = Boolean.valueOf(req.getParameter("dinner"));
		Boolean afternoonTea = Boolean.valueOf(req.getParameter("afternoonTea"));
		Integer price = new Integer(req.getParameter("price"));
		String reservationer = req.getParameter("reservationer");
		
		String[] birthday = req.getParameter("bdate").trim().split("/");
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
		String addr = req.getParameter("addr");
		String country = req.getParameter("country");
		String passport = req.getParameter("passport");
		Boolean bedAdding = Boolean.valueOf(req.getParameter("bedAdding"));
		Integer pricePerPerson = new Integer(req.getParameter("pricePerPerson"));
		String customerRemark = req.getParameter("customerRemark");
		String hotelRemark = req.getParameter("hotelRemark");
		Boolean orderState = true;
		
		OrdersServise os = new OrdersServise();
		os.newOrder(memberId,roomId,hotelId,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,orderState);
		
		res.sendRedirect("success.jsp");
	}

}
