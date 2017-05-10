package com.icastle.members.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class LineLogin
 */
@WebServlet("/general/members/LineLogin.do")
public class LineLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LineLogin() {
        super();
       
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		Map<String,String> errMap = new HashMap<String,String>();
		req.setAttribute("errMap", errMap);
		MembersVO membersvo = new MembersVO();
		
		session.setAttribute("MemberLoginOK",membersvo);
     	res.sendRedirect("../../index.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
