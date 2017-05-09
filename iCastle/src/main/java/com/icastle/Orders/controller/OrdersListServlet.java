package com.icastle.Orders.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.hotels.model.HotelVO;

/**
 * Servlet implementation class OrdersListServlet
 */
@WebServlet("/OrdersListServlet")
public class OrdersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		HotelVO hotel = (HotelVO)session.getAttribute("HotelLoginOK");
		List<OrdersVO> result = null;
		
		try{
			Integer hotelId = hotel.getHotelId();
			Integer year = new Integer(req.getParameter("year"));
			String rti = req.getParameter("roomTypeId");
			String m = req.getParameter("month");
			String d = req.getParameter("day");
			String s = req.getParameter("state");
			
			Integer roomTypeId = (!"null".equals(rti))?new Integer(rti) : null;
			Integer month = (!"null".equals(m))?new Integer(m) : null;
			Integer day = (!"null".equals(d))?new Integer(d) : null;
			Boolean state = (!"null".equals(s))?new Boolean(s) : null;
			
			OrdersService os = new OrdersService();
			result = os.search_By_HotelId(hotelId, roomTypeId, year, month, day, state);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
			String bedAdd = null;
			String orderedState = null;
			String customer = null;
			String mymemo = null;
			
			JSONArray ja = new JSONArray();
			for(OrdersVO order: result){
				
				bedAdd = (order.getBedAdding())?"加一床":"X";
				orderedState = (order.getOrderState())?"訂單完成":"已取消";
				customer = (order.getCustomerRemark() == null)?"":order.getCustomerRemark();
				mymemo = (order.getMemo() == null)?"":order.getMemo();
				
				JSONObject jo = new JSONObject();
				jo.put("orderId", String.valueOf(order.getOrderId()));
				jo.put("orderedDate", sdf.format(order.getOrderedDate()));
				jo.put("memberId", String.valueOf(order.getMemberId()));
				jo.put("roomId", String.valueOf(order.getRoomId()));
				jo.put("hotelId", String.valueOf(order.getHotelId()));
				jo.put("hotelName", String.valueOf(order.getHotelName()));
				jo.put("roomTypeId", String.valueOf(order.getRoomTypeId()));
				jo.put("roomTypeName", String.valueOf(order.getRoomTypeName()));
				jo.put("checkinDay", String.valueOf(order.getCheckinDay()));
				jo.put("checkoutDay", String.valueOf(order.getCheckoutDay()));
				jo.put("roomCount", String.valueOf(order.getRoomCount()));
				jo.put("peopleNum", String.valueOf(order.getPeopleNum()));
				jo.put("breakfast", String.valueOf(order.getBreakfast()));
				jo.put("dinner", String.valueOf(order.getDinner()));
				jo.put("afternoonTea", String.valueOf(order.getAfternoonTea()));
				jo.put("price", String.valueOf(order.getPrice()));
				jo.put("roomNo", String.valueOf(order.getRoomNo()));
				jo.put("reservationer", String.valueOf(order.getReservationer()));
				jo.put("bdate", String.valueOf(order.getBdate()));
				jo.put("tel", String.valueOf(order.getTel()));
				jo.put("email", String.valueOf(order.getEmail()));
				jo.put("addr", String.valueOf(order.getAddr()));
				jo.put("personId", String.valueOf(order.getPersonId()));
				jo.put("country", String.valueOf(order.getCountry()));
				jo.put("passport", String.valueOf(order.getPassport()));
				jo.put("bedAdding", bedAdd);
				jo.put("pricePerPerson", String.valueOf(order.getPricePerPerson()));
				jo.put("customerRemark", customer);
				jo.put("hotelRemark", String.valueOf(order.getHotelRemark()));
				jo.put("memo", mymemo);
				jo.put("orderState", orderedState);
				jo.put("cancelDate", String.valueOf(order.getCancelDate()));
				
				ja.add(jo);
			}
			out.println(ja);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
