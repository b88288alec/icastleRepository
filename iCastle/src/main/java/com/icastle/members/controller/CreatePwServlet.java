package com.icastle.members.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.members.model.MembersService;

import globalservice.GlobalService;

/**
 * Servlet implementation class CreatePwServlet
 */
@WebServlet("/general/members/CreatePw.do")
public class CreatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreatePwServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		Map<String,String> errMap = new HashMap<String,String>();
		req.setAttribute("errMap",errMap);
		
		String email = req.getParameter("email");
		
		if (email == null || email == "")
			errMap.put("emailErr", "請輸入Email");
		
		if(!errMap.isEmpty()){
			RequestDispatcher rd = req.getRequestDispatcher("createPw.jsp");
			rd.forward(req,res);
			return;
			}
		
		
		MembersService membersSer = new MembersService();
		String newPw = membersSer.createPw(email);
		System.out.println("您的新密碼為"+newPw);
		GlobalService gs = new GlobalService();
		gs.SendGmail(email, "忘記密碼", "您的新密碼為"+newPw);
		
		RequestDispatcher rd = req.getRequestDispatcher("sendPw.jsp");
		rd.forward(req,res);
		return;

		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
