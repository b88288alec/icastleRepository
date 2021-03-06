package com.icastle.rooms.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.members.model.MembersVO;
import com.icastle.rooms.model.RoomsService;

@WebServlet("/members/rooms/Rooms.do")
public class RoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		MembersVO member = (MembersVO) session.getAttribute("MemberLoginOK");

		RequestDispatcher rd = null;

		if (member.isSuspension()) {
			rd = request.getRequestDispatcher("../suspension.jsp");
			rd.forward(request, response);
			return;
		}

		// 判斷請求
		if (action.trim().equals("getOrder")) {
			// 取得參數
			String roomId = request.getParameter("roomId");
			String hotelId = request.getParameter("hotelId");
			String hotelName = request.getParameter("hotelName");
			String roomTypeId = request.getParameter("roomTypeId");
			String roomTypeName = request.getParameter("roomTypeName");
			String checkinDay = request.getParameter("start");
			String checkoutDay = request.getParameter("end");
			String peopleNum = request.getParameter("peopleNum");
			String breakfast = request.getParameter("breakfast");
			String dinner = request.getParameter("dinner");
			String afternoonTea = request.getParameter("afternoonTea");
			String roomCount = request.getParameter("roomCount");
			String bedAdding = request.getParameter("bedAdding");
			String pricePerPerson = request.getParameter("pricePerPerson");
			String remark = request.getParameter("remark");
			String avgPrice = request.getParameter("price");
			String guestPolicies = request.getParameter("guestPolicies");
			String cancelPolicies = request.getParameter("cancelPolicies");

			RoomsService roomS = new RoomsService();
			Integer stayDayNum = roomS.getstayDayNum(checkinDay, checkoutDay);
			Map<String, Integer> PerPrice = roomS.getPerPriceByAuto(Integer.parseInt(roomId), Integer.parseInt(hotelId),
					Integer.parseInt(roomTypeId), checkinDay, checkoutDay, stayDayNum);
			int totalPrice = roomS.getTotalPrice(PerPrice);

			// 包裝資料
			Map<String, String> orderMap = new HashMap<String, String>();
			orderMap.put("roomId", roomId);
			orderMap.put("hotelId", hotelId);
			orderMap.put("hotelName", hotelName);
			orderMap.put("roomTypeId", roomTypeId);
			orderMap.put("roomTypeName", roomTypeName);
			orderMap.put("checkinDay", checkinDay);
			orderMap.put("checkoutDay", checkoutDay);
			orderMap.put("peopleNum", peopleNum);
			orderMap.put("roomCount", roomCount);
			orderMap.put("breakfast", breakfast);
			orderMap.put("dinner", dinner);
			orderMap.put("afternoonTea", afternoonTea);
			orderMap.put("bedAdding", bedAdding);
			orderMap.put("pricePerPerson", pricePerPerson);
			orderMap.put("remark", remark);
			orderMap.put("avgPrice", avgPrice);
			orderMap.put("guestPolicies", guestPolicies);
			orderMap.put("cancelPolicies", cancelPolicies);

			// 放入request
			session.setAttribute("orderMap", orderMap);
			session.setAttribute("stayDayNum", stayDayNum);
			session.setAttribute("PerPrice", PerPrice);
			session.setAttribute("totalPrice", totalPrice);

			// forward
			rd = request.getRequestDispatcher("../orders/order.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
