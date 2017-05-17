package com.icastle.members.controller;

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

import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

@WebServlet("/manager/ManagerPageServlet")
public class ManagerPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		
		try{
			String action = req.getParameter("action");
			
			MembersService ms = new MembersService();
			List<MembersVO> members = ms.search_manager();
			
			if("forManagerPage".equalsIgnoreCase(action)){
				res.setHeader("content-type", "application/json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				JSONArray ja = new JSONArray();
				
				for(MembersVO listmember : members){
					
					JSONObject jo = new JSONObject();
					jo.put("memberId", String.valueOf(listmember.getMemberId()));
					jo.put("email", listmember.getEmail());
					jo.put("name", listmember.getName());
					jo.put("gender", listmember.getGender());
					jo.put("bdate", String.valueOf(listmember.getBdate()));
					jo.put("addr", listmember.getAddr());
					jo.put("tel", listmember.getTel());
					jo.put("personId", listmember.getPersonId());
					jo.put("country", listmember.getCountry());
					jo.put("passport", listmember.getPassport());
					jo.put("manager", String.valueOf(listmember.isManager()));
					jo.put("suspension", String.valueOf(listmember.isSuspension()));
					
					ja.add(jo);
					
				}
				
				out.println(ja);
				
			}else{
				req.setAttribute("members", members);
				
				RequestDispatcher rd = req.getRequestDispatcher("new_manager.jsp");
				rd.forward(req, res);
				return;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
