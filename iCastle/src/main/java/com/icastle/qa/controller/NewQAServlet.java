package com.icastle.qa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.icastle.qa.model.QaService;

@WebServlet("/manager/NewQAServlet")
public class NewQAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		
		try{
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			
			QaService qs = new QaService();
			qs.insert(question, answer);
			
			RequestDispatcher rd = req.getRequestDispatcher("SearchQAServlet");
			rd.forward(req, res);
			return;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
