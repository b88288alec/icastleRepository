package com.icastle.Orders.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.rooms.model.RoomsService;

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
		HttpSession session = req.getSession();
		Map<String,String> orderMap = (Map)session.getAttribute("orderMap");
		
		RoomsService rs = new RoomsService();
		rs.getOrder(Integer.parseInt(orderMap.get("roomId")), (int)session.getAttribute("stayDayNum"));
		
		Integer memberId = new Integer(req.getParameter("memberId"));
		Integer roomId = new Integer(orderMap.get("roomId"));
		Integer hotelId = new Integer(orderMap.get("hotelId"));
		Integer roomTypeId = new Integer(orderMap.get("roomTypeId"));
		String roomTypeName = orderMap.get("roomTypeName");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		java.sql.Date checkinDay = null;
		java.sql.Date checkoutDay = null;
		java.sql.Date bdate = null;
		try {
			checkinDay = new java.sql.Date(sdf.parse(orderMap.get("checkinDay")).getTime());
			checkoutDay = new java.sql.Date(sdf.parse(orderMap.get("checkoutDay")).getTime());
			bdate = new java.sql.Date(sdf.parse(req.getParameter("bdate")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//房間數量先寫死，之後再改成動態的
		Integer roomCount = 1;
		Integer peopleNum = new Integer(orderMap.get("peopleNum"));
		
		String bf = orderMap.get("breakfast");
		Boolean breakfast = false;
		if(bf != null){
			breakfast = Boolean.valueOf(bf);
		}
		
		String dr = orderMap.get("dinner");
		Boolean dinner = false;
		if(dr != null){
			dinner = Boolean.valueOf(dr);
		}
		
		String tea = orderMap.get("afternoonTea");
		Boolean afternoonTea = false;
		if(tea != null){
			afternoonTea = Boolean.valueOf(tea);
		}
		Integer price = new Integer(req.getParameter("price"));
		String reservationer = req.getParameter("reservationer");
		String tel = req.getParameter("tel");
		String personId = req.getParameter("personId");
		String email = req.getParameter("email");
		String addr = req.getParameter("addr");
		String country = req.getParameter("country");
		String passport = req.getParameter("passport");
		Boolean bedAdding = Boolean.valueOf(req.getParameter("bedAdding"));
		
		Integer pricePerPerson = 0;
		if(bedAdding){
			pricePerPerson = new Integer(orderMap.get("pricePerPerson"));
		}
		
		String customerRemark = req.getParameter("customerRemark");
		String hotelRemark = orderMap.get("remark");
		Boolean orderState = true;
		
		OrdersService os = new OrdersService();
		os.newOrder(memberId,roomId,hotelId,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,orderState);
		
		res.sendRedirect("success.jsp");
	}

}
