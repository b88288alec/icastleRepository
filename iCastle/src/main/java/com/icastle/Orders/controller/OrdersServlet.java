package com.icastle.Orders.controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;

@WebServlet("/orders/OrdersServlet.do")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		OrdersVO ordersVO = new OrdersVO();
		
		//先把顧客ID寫死，之後再改成動態傳入
		ordersVO.setMemberId(1);
		ordersVO.setRoomId(new Integer(req.getParameter("roomId")));
		ordersVO.setHotelId(new Integer(req.getParameter("hotelId")));
		ordersVO.setRoomTypeId(new Integer(req.getParameter("roomTypeId")));
		ordersVO.setRoomTypeName(req.getParameter("roomTypeName"));
		
		String[] checkin = req.getParameter("start").trim().split("/");
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
		
		String[] checkout = req.getParameter("end").trim().split("/");
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
		
		ordersVO.setCheckinDay(checkinDay);
		ordersVO.setCheckoutDay(checkoutDay);
//		ordersVO.setRoomCount(new Integer(req.getParameter("roomCount")));
		ordersVO.setPeopleNum(new Integer(req.getParameter("peopleNum")));
		ordersVO.setBreakfast(Boolean.valueOf(req.getParameter("breakfast")));
		ordersVO.setDinner(Boolean.valueOf(req.getParameter("dinner")));
		ordersVO.setAfternoonTea(Boolean.valueOf(req.getParameter("afternoonTea")));
		ordersVO.setPrice(new Integer(req.getParameter("price")));
		ordersVO.setBedAdding(Boolean.valueOf(req.getParameter("bedAddable")));
		ordersVO.setPricePerPerson(new Integer(req.getParameter("pricePerPerson")));
		ordersVO.setHotelRemark(req.getParameter("remark"));
		
		req.setAttribute("ordersVO", ordersVO);
		
		RequestDispatcher rd = req.getRequestDispatcher("insert.jsp");
		rd.forward(req, res);
		return;
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
		
		String[] checkin = req.getParameter("checkinDay").trim().split("-");
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
		
		String[] checkout = req.getParameter("checkoutDay").trim().split("-");
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
		
		//房間數量先寫死，之後再改成動態的
		Integer roomCount = 1;
		Integer peopleNum = new Integer(req.getParameter("peopleNum"));
		
		String bf = req.getParameter("breakfast");
		Boolean breakfast = false;
		if(bf != null){
			breakfast = Boolean.valueOf(bf);
		}
		
		String dr = req.getParameter("dinner");
		Boolean dinner = false;
		if(dr != null){
			dinner = Boolean.valueOf(dr);
		}
		
		String tea = req.getParameter("afternoonTea");
		Boolean afternoonTea = false;
		if(tea != null){
			afternoonTea = Boolean.valueOf(tea);
		}
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
		
		Integer pricePerPerson = 0;
		if(bedAdding){
			pricePerPerson = new Integer(req.getParameter("pricePerPerson"));
		}
		
		String customerRemark = req.getParameter("customerRemark");
		String hotelRemark = req.getParameter("hotelRemark");
		Boolean orderState = true;
		
		OrdersService os = new OrdersService();
		os.newOrder(memberId,roomId,hotelId,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,orderState);
		
		res.sendRedirect("success.jsp");
	}

}
