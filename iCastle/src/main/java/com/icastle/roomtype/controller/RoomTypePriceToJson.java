package com.icastle.roomtype.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.roomtype.model.RoomTypeService;

@WebServlet("/roomtype/RoomTypePriceToJson")
public class RoomTypePriceToJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));

		RoomTypeService roms = new RoomTypeService();
		Map<String, String> price = roms.findRoomTypePrice(roomTypeId);

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonObj.put("weekdaysPrice", price.get("weekdaysPrice"));
		jsonObj.put("holidayPrice", price.get("holidayPrice"));
		jsonObj.put("seasonPrice", price.get("seasonPrice"));
		jsonObj.put("customizedName", price.get("customizedName"));
		jsonObj.put("customizedPrice", price.get("customizedPrice"));
		
		jsonArray.add(jsonObj);

		System.out.println(jsonArray);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
	}

}
