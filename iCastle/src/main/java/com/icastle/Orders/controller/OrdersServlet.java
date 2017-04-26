package com.icastle.Orders.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
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

import com.icastle.Orders.model.CheckId;
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
		ordersVO.setHotelName(req.getParameter("hotelName"));
		ordersVO.setRoomTypeId(new Integer(req.getParameter("roomTypeId")));
		ordersVO.setRoomTypeName(req.getParameter("roomTypeName"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		java.sql.Date checkinDay = null;
		java.sql.Date checkoutDay = null;
		try {
			checkinDay = new java.sql.Date(sdf.parse(req.getParameter("start").trim()).getTime());
			checkoutDay = new java.sql.Date(sdf.parse(req.getParameter("end").trim()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		HttpSession session = req.getSession();
		Map<String,String> orderMap = (Map)session.getAttribute("orderMap");
		
		RoomsService rs = new RoomsService();
		rs.getOrder(Integer.parseInt(orderMap.get("roomId")), (int)session.getAttribute("stayDayNum"));
		
		Integer memberId = new Integer(req.getParameter("memberId"));
		Integer roomId = new Integer(orderMap.get("roomId"));
		Integer hotelId = new Integer(orderMap.get("hotelId"));
		String hotelName = "寫死的名子";
		Integer roomTypeId = new Integer(orderMap.get("roomTypeId"));
		String roomTypeName = orderMap.get("roomTypeName");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		java.sql.Date checkinDay = null;
		java.sql.Date checkoutDay = null;
		java.sql.Date bdate = null;
		try {
			checkinDay = new java.sql.Date(sdf.parse(orderMap.get("checkinDay")).getTime());
			checkoutDay = new java.sql.Date(sdf.parse(orderMap.get("checkoutDay")).getTime());
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
		if(reservationer != ""){
			String nameRegex = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if(!reservationer.trim().matches(nameRegex)){
				errorMsgs.put("reservationer", "姓名只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
		}else{
			errorMsgs.put("reservationer", "入住人姓名不可空白");
		}
		
		if(req.getParameter("bdate") == ""){
			errorMsgs.put("bdate", "請輸入生日");
		}else{
			try {
				bdate = new java.sql.Date(sdf.parse(req.getParameter("bdate")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		String tel = req.getParameter("tel");
		if(tel != ""){
			String telRegex = "^[(0-9)]{9,20}$";
			if(!tel.trim().matches(telRegex)){
				errorMsgs.put("tel", "電話號碼只能是數字，且長度必須在9到20之間");
			}
		}else{
			errorMsgs.put("tel", "連絡人電話不可空白");
		}

		String personId = req.getParameter("personId");
		String country = req.getParameter("country");
		String passport = req.getParameter("passport");
		if(personId != ""){
			if(!CheckId.checkID(personId)){
				errorMsgs.put("personId", "身分證字號輸入錯誤");
			}
		}else{
			if(country == ""){
				errorMsgs.put("country", "身分證字號與國籍+護照號碼必須選一項輸入");
			}else{
				if(passport == ""){
					errorMsgs.put("country", "身分證字號與國籍+護照號碼必須選一項輸入");
				}
			}
		}
		
		String email = req.getParameter("email");
		String addr = req.getParameter("addr");
		Boolean bedAdding = Boolean.valueOf(req.getParameter("bedAdding"));
		
		Integer pricePerPerson = 0;
		if(bedAdding){
			pricePerPerson = new Integer(orderMap.get("pricePerPerson"));
		}
		
		String customerRemark = req.getParameter("customerRemark");
		String hotelRemark = orderMap.get("remark");
		Boolean orderState = true;
		
		if(!errorMsgs.isEmpty()){
			RequestDispatcher rd = req.getRequestDispatcher("insert.jsp");
			rd.forward(req, res);
			return;
		}
		
		OrdersService os = new OrdersService();
		os.newOrder(memberId,roomId,hotelId,hotelName,roomTypeId,roomTypeName,checkinDay,checkoutDay,roomCount,peopleNum,breakfast,dinner,afternoonTea,price,reservationer,bdate,tel,email,addr,personId,country,passport,bedAdding,pricePerPerson,customerRemark,hotelRemark,orderState);
		
		res.sendRedirect("success.jsp");
	}

}
