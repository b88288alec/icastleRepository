package com.icastle.hotels.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.icastle.hotels.model.*;

@WebServlet("/AutoCompleteServlet.do")
public class AutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AutoCompleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String keyword = request.getParameter("keyword");
		
		if (keyword == "")
			keyword = "GGGGGGGGGGGGG";
		
		//利用keyword取得符合的地區
		HotelService dao = new HotelService();
		JSONArray list = new JSONArray();
		List<String> zones = dao.getZoneByKeyword(keyword);
		for (String zone : zones)
			list.add(zone);
		
		out.println(list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
