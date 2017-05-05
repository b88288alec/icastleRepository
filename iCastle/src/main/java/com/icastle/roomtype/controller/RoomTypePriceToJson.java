package com.icastle.roomtype.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.icastle.roomtype.model.RoomTypeService;

@WebServlet("/roomtype/RoomTypePriceToJason")
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
		jsonObj.put("平日價", price.get("weekdaysPrice"));
		jsonObj.put("假日價", price.get("holidayPrice"));
		jsonObj.put("旺季價", price.get("seasonPrice"));
		jsonObj.put(price.get("customizedName"), price.get("customizedPrice"));

		System.out.println(jsonObj);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonObj);
	}

}
