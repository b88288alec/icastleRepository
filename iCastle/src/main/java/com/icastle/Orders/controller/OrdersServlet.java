package com.icastle.Orders.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.orderfollowers.model.OrderFollowersVO;
import com.icastle.rooms.model.RoomsService;

import globalservice.CheckId;

@WebServlet("/members/orders/OrdersServlet.do")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("../index.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		HttpSession session = req.getSession();
		Map<String, String> orderMap = (Map) session.getAttribute("orderMap");
		String action = req.getParameter("action");

		if("keyin".equals(action.trim())){
			try {
				Integer memberId = new Integer(req.getParameter("memberId"));
				Integer roomId = new Integer(orderMap.get("roomId"));
				Integer hotelId = new Integer(orderMap.get("hotelId"));
				String hotelName = orderMap.get("hotelName");
				Integer roomTypeId = new Integer(orderMap.get("roomTypeId"));
				String roomTypeName = orderMap.get("roomTypeName");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				java.sql.Date checkinDay = null;
				java.sql.Date checkoutDay = null;
				java.sql.Date bdate = null;
				try {
					checkinDay = new java.sql.Date(sdf.parse(orderMap.get("checkinDay")).getTime());
					checkoutDay = new java.sql.Date(sdf.parse(orderMap.get("checkoutDay")).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Integer roomCount = new Integer(orderMap.get("roomCount"));
				Integer peopleNum = new Integer(orderMap.get("peopleNum"));

				String bf = orderMap.get("breakfast");
				Boolean breakfast = false;
				if (bf != null) {
					breakfast = Boolean.valueOf(bf);
				}

				String dr = orderMap.get("dinner");
				Boolean dinner = false;
				if (dr != null) {
					dinner = Boolean.valueOf(dr);
				}

				String tea = orderMap.get("afternoonTea");
				Boolean afternoonTea = false;
				if (tea != null) {
					afternoonTea = Boolean.valueOf(tea);
				}
				Integer price = new Integer(req.getParameter("price"));

				String reservationer = req.getParameter("reservationer");
				if (reservationer != "") {
					String nameRegex = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
					if (!reservationer.trim().matches(nameRegex)) {
						errorMsgs.put("reservationer", "姓名只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
					}
				} else {
					errorMsgs.put("reservationer", "入住人姓名不可空白");
				}

				if (req.getParameter("bdate") == "") {
					errorMsgs.put("bdate", "請輸入生日");
				} else {
					try {
						bdate = new java.sql.Date(sdf.parse(req.getParameter("bdate")).getTime());
					} catch (ParseException e) {
						errorMsgs.put("bdate", "輸入生日格式錯誤，請參照\"yyyy/mm/dd\"");
					}
				}

				String tel = req.getParameter("tel");
				if (tel != "") {
					String telRegex = "^[(0-9)]{9,20}$";
					if (!tel.trim().matches(telRegex)) {
						errorMsgs.put("tel", "電話號碼只能是數字，且長度必須在9到20之間");
					}
				} else {
					errorMsgs.put("tel", "連絡人電話不可空白");
				}

				String personId = req.getParameter("personId");
				String country = req.getParameter("country");
				String passport = req.getParameter("passport");
				if (personId != "") {
					if (!CheckId.checkID(personId)) {
						errorMsgs.put("personId", "身分證字號輸入錯誤");
					}
				} else {
					if (country == "") {
						errorMsgs.put("country", "身分證字號與國籍+護照號碼必須選一項輸入");
					} else {
						if (passport == "") {
							errorMsgs.put("country", "身分證字號與國籍+護照號碼必須選一項輸入");
						}
					}
				}

				String email = req.getParameter("email");
				String addr = req.getParameter("addr");
				Boolean bedAdding = Boolean.valueOf(req.getParameter("bedAdding"));

				Integer pricePerPerson = 0;
				if (bedAdding) {
					pricePerPerson = new Integer(orderMap.get("pricePerPerson"));
				}

				String customerRemark = req.getParameter("customerRemark");
				String hotelRemark = orderMap.get("remark");
				Boolean orderState = true;
//				還沒寫!!!!!!!!!!!!!!!!!
				Set<OrderFollowersVO> orderFollowersVO = new LinkedHashSet<OrderFollowersVO>();

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher rd = req.getRequestDispatcher("insert.jsp");
					rd.forward(req, res);
					return;
				}
				
				OrdersVO ordersVO = new OrdersVO();
				ordersVO.setMemberId(memberId);
				ordersVO.setRoomId(roomId);
				ordersVO.setHotelId(hotelId);
				ordersVO.setHotelName(hotelName);
				ordersVO.setRoomTypeId(roomTypeId);
				ordersVO.setRoomTypeName(roomTypeName);
				ordersVO.setCheckinDay(checkinDay);
				ordersVO.setCheckoutDay(checkoutDay);
				ordersVO.setRoomCount(roomCount);
				ordersVO.setPeopleNum(peopleNum);
				ordersVO.setBreakfast(breakfast);
				ordersVO.setDinner(dinner);
				ordersVO.setAfternoonTea(afternoonTea);
				ordersVO.setPrice(price);
				ordersVO.setReservationer(reservationer);
				ordersVO.setBdate(bdate);
				ordersVO.setTel(tel);
				ordersVO.setEmail(email);
				ordersVO.setAddr(addr);
				ordersVO.setPersonId(personId);
				ordersVO.setCountry(country);
				ordersVO.setPassport(passport);
				ordersVO.setBedAdding(bedAdding);
				ordersVO.setPricePerPerson(pricePerPerson);
				ordersVO.setCustomerRemark(customerRemark);
				ordersVO.setHotelRemark(hotelRemark);
				ordersVO.setOrderState(orderState);
				ordersVO.setOrderFollowersVO(orderFollowersVO);
				
				session.setAttribute("OrdersVO", ordersVO);

				RequestDispatcher rd = req.getRequestDispatcher("creditCard.jsp");
				rd.forward(req, res);
				return;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if("check".equals(action.trim())){
			try {
				RoomsService rs = new RoomsService();
				rs.getOrderByAuto(Integer.parseInt(orderMap.get("roomId")), Integer.parseInt(orderMap.get("hotelId")), Integer.parseInt(orderMap.get("roomTypeId")), orderMap.get("checkinDay"), orderMap.get("checkoutDay"), (Integer)session.getAttribute("stayDayNum"), Integer.parseInt(orderMap.get("roomCount")));
//				rs.getOrder(Integer.parseInt(orderMap.get("roomId")), (int) session.getAttribute("stayDayNum"),
//						Integer.parseInt(orderMap.get("roomCount")));

				OrdersService os = new OrdersService();
				os.newOrder((OrdersVO)session.getAttribute("OrdersVO"));
				
				Enumeration en = session.getAttributeNames();
				while(en.hasMoreElements()){
					String name = (String)en.nextElement();
					if(!name.equalsIgnoreCase("MemberLoginOK")){
						session.removeAttribute(name);
					}
				}

				res.sendRedirect("success.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
