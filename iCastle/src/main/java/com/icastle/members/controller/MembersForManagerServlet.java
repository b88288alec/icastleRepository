package com.icastle.members.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

@WebServlet("/manager/MembersForManagerServlet")
public class MembersForManagerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		JSONArray ja = new JSONArray();
		
		try{
			String email = req.getParameter("email");
			
			MembersService ms = new MembersService();
			MembersVO member = null;
			List<MembersVO> members = null;
			
			if(email.indexOf("@") != -1){
				member = ms.findByPrimaryKey(email);
				
				JSONObject jo = new JSONObject();
				jo.put("memberId", String.valueOf(member.getMemberId()));
				jo.put("email", member.getEmail());
				jo.put("name", member.getName());
				jo.put("gender", member.getGender());
				jo.put("bdate", String.valueOf(member.getBdate()));
				jo.put("addr", member.getAddr());
				jo.put("tel", member.getTel());
				jo.put("personId", member.getPersonId());
				jo.put("country", member.getCountry());
				jo.put("passport", member.getPassport());
				jo.put("manager", String.valueOf(member.isManager()));
				jo.put("suspension", String.valueOf(member.isSuspension()));
				
				ja.add(jo);
				
			}else{
				members = ms.search_by_name(email);
				
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
