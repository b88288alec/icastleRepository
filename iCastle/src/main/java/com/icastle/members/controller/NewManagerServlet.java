package com.icastle.members.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.icastle.members.model.MembersService;

@WebServlet("/manager/NewManagerServlet")
public class NewManagerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		try{
			JSONObject jo = new JSONObject();
			Integer memberId = new Integer(req.getParameter("memberId").substring(3));
			Boolean manager = Boolean.valueOf(req.getParameter("manager"));
			String action = req.getParameter("action");
			
			MembersService ms = new MembersService();
			ms.setManager(memberId, manager);
			
			if("forManagerPage".equalsIgnoreCase(action)){
				RequestDispatcher rd = req.getRequestDispatcher("ManagerPageServlet");
				rd.forward(req, res);
				return;
			}else{

				jo.put("success", "success");
				out.println(jo);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
