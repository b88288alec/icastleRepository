package com.icastle.record.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

@WebServlet("/json/HotelIdRecordToJson")
public class HotelIdRecordToJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Integer hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		RecordService res = new RecordService();
		List<RecordVO> recordList = res.search_hotel_records_by_id(hotelId);
		
		JSONArray jsonArray = new JSONArray();
		
		for(RecordVO recVO : recordList){
			JSONArray injsonArray = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("recordTime", String.valueOf(recVO.getRecordTime()).substring(0, 16));
			jsonObj.put("name", recVO.getName());
			jsonObj.put("roomTypeName", recVO.getRoomTypeName());
			jsonObj.put("peopleNum", String.valueOf(recVO.getPeopleNum()));
			jsonObj.put("roomNumber", String.valueOf(recVO.getRoomNumber()));
			jsonObj.put("weekdaysPrice", String.valueOf(recVO.getWeekdaysPrice()));
			jsonObj.put("holidayPrice", String.valueOf(recVO.getHolidayPrice()));
			jsonObj.put("seasonPrice", String.valueOf(recVO.getSeasonPrice()));
			jsonObj.put("customizedPrice", String.valueOf(recVO.getCustomizedPrice()));
			jsonObj.put("customizedName", String.valueOf(recVO.getCustomizedName()));
			jsonObj.put("breakfast", String.valueOf(recVO.getBreakfast()));
			jsonObj.put("afternoonTea", String.valueOf(recVO.getAfternoonTea()));
			jsonObj.put("dinner", String.valueOf(recVO.getDinner()));
			jsonObj.put("bedAddable", String.valueOf(recVO.getBedAddable()));
			jsonObj.put("PrcePerPerson", String.valueOf(recVO.getPricePerPerson()));
			jsonObj.put("remark", String.valueOf(recVO.getRemark()));
			injsonArray.add(jsonObj);
			jsonArray.add(injsonArray);
		}
		
		out.println(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
