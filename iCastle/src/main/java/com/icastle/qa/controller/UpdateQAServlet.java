package com.icastle.qa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.icastle.qa.model.QaService;

@WebServlet("/manager/UpdateQAServlet")
public class UpdateQAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		try{
			
			Integer id = new Integer(req.getParameter("id"));
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			
			QaService qs = new QaService();
			qs.update(question, answer, id);
			
			JSONObject jo = new JSONObject();
			jo.put("success", "success");
			
			out.println(jo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
