package com.icastle.members.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

@WebServlet("/members/MemberForSearchNewOrdersServlet")
public class MemberForSearchNewOrdersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		try{
			MembersVO member = (MembersVO)session.getAttribute("MemberLoginOK");
			OrdersService os = new OrdersService();
			List<OrdersVO> orders = os.search_new_orders_by_memberId(member.getMemberId());
			List<Map> result = new LinkedList<Map>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
			
			for(OrdersVO vo : orders){
				Map<String, Object> hm = new HashMap<String, Object>();
				hm.put("orderId", vo.getOrderId());
				hm.put("orderedDate", sdf.format(vo.getOrderedDate()));
				hm.put("memberId", vo.getMemberId());
				hm.put("roomId", vo.getRoomId());
				hm.put("hotelId", vo.getHotelId());
				hm.put("hotelName", vo.getHotelName());
				hm.put("roomTypeId", vo.getRoomTypeId());
				hm.put("roomTypeName", vo.getRoomTypeName());
				hm.put("checkinDay", vo.getCheckinDay());
				hm.put("checkoutDay", vo.getCheckoutDay());
				hm.put("roomCount", vo.getRoomCount());
				hm.put("peopleNum", vo.getPeopleNum());
				hm.put("breakfast", vo.getBreakfast());
				hm.put("dinner", vo.getDinner());
				hm.put("afternoonTea", vo.getAfternoonTea());
				hm.put("price", vo.getPrice());
				hm.put("reservationer", vo.getReservationer());
				hm.put("bdate", vo.getBdate());
				hm.put("tel", vo.getTel());
				hm.put("email", vo.getEmail());
				hm.put("addr", vo.getAddr());
				hm.put("personId", vo.getPersonId());
				hm.put("country", vo.getCountry());
				hm.put("passport", vo.getPassport());
				hm.put("bedAdding", vo.getBedAdding());
				hm.put("pricePerPerson", vo.getPricePerPerson());
				hm.put("customerRemark", vo.getCustomerRemark());
				hm.put("hotelRemark", vo.getHotelRemark());
				hm.put("memo", vo.getMemo());
				hm.put("orderState", vo.getOrderState());
				if(vo.getCancelDate() != null){
					hm.put("cancelDate", sdf.format(vo.getCancelDate()));
				}else{
					hm.put("cancelDate", vo.getCancelDate());
				}
				
				result.add(hm);
			}
			
			req.setAttribute("orders", result);
			RequestDispatcher rd = req.getRequestDispatcher("member_orders.jsp");
			rd.forward(req, res);
			return;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
