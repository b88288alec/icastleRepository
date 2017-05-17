package com.icastle.qa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.qa.model.QaService;
import com.icastle.qa.model.QaVO;

@WebServlet("/manager/DeleteQAServlet")
public class DeleteQAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		try{

			JSONArray ja = new JSONArray();
			
			QaService qs = new QaService();
			
			String del[] = req.getParameterValues("id");
			for(String id : del){
				qs.delete(new Integer(id));
				JSONObject jo = new JSONObject();
				jo.put("id", id);
				ja.add(jo);
			}
			
			out.println(ja);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
