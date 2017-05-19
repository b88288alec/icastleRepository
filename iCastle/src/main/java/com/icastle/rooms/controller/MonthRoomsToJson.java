package com.icastle.rooms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;

@WebServlet("/json/rooms/MonthRoomsToJson")
public class MonthRoomsToJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer hotelId = Integer.parseInt(request.getParameter("hotelId"));
		Integer roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		long startlong = 0;
		long endlong = 0;
		try {
			startlong = sdf.parse(start).getTime();
			endlong = sdf.parse(end).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		RoomsService roms = new RoomsService();
		List<RoomsVO> list = roms.getRoomsByMonth(hotelId, roomTypeId, new Date(startlong), new Date(endlong));
		
		String[] subStart = start.split("-");
		String[] subEnd = start.split("-");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(subEnd[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(subEnd[1]));
		cal.set(Calendar.DATE, cal.getMinimum(Calendar.DATE));
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date starGray = new Date(cal.getTimeInMillis());
		System.out.println(starGray.getTime());
		
		cal.set(Calendar.DATE, cal.getMaximum(Calendar.DATE));
		Date endGray = new Date(cal.getTimeInMillis());
		System.out.println(endGray);
		
		JSONArray jsonArray = new JSONArray();
		for(RoomsVO vo : list){
			JSONObject jsonObj = new JSONObject();
			if(vo.getRoomDate().getTime() >= starGray.getTime() && vo.getRoomDate().getTime() <= endGray.getTime()){
				jsonObj.put("id", vo.getRoomDate().toString());
				jsonObj.put("roomId", vo.getRoomId().toString());
				jsonObj.put("title", vo.getPrice().toString());
				jsonObj.put("start", vo.getRoomDate().toString());
				jsonObj.put("allDay", "true");
			}else{
				jsonObj.put("id", vo.getRoomDate().toString());
				jsonObj.put("roomId", vo.getRoomId().toString());
				jsonObj.put("title", vo.getPrice().toString());
				jsonObj.put("start", vo.getRoomDate().toString());
				jsonObj.put("allDay", "true");
				jsonObj.put("color", "#9E9E9E");
			}
			
			jsonArray.add(jsonObj);
		}
		System.out.println(jsonArray);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
