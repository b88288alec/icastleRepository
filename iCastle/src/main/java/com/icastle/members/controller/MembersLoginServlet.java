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
import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class MembersLoginServlet
 */
@WebServlet("/members/Login.do")
public class MembersLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MembersLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		Map<String,String> errMap = new HashMap<String,String>();
		req.setAttribute("errMap", errMap);
		
		
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String requestURI = (String)session.getAttribute("requestURI");
		String queryString = (String)session.getAttribute("queryString");
		
		//檢查是否所有欄位都有輸入
		if (email==null || email=="")
			errMap.put("emailErr", "請輸入Email");
		
		if (pw==null || pw=="")
			errMap.put("pwErr", "請輸入密碼");
		
		
		 if( req.getParameter("value").equals(session.getAttribute("imageMask")) ){
		       
		    }else{
		    	errMap.put("cdErr","驗證碼錯誤");
		    }
		
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = req.getRequestDispatcher("loginMembers.jsp");
			rd.forward(req, res);
			return;
		}
		
		//呼叫model
		MembersService membersSer = new MembersService();
		MembersVO membersvo = membersSer.login(email, pw);
		
		if (membersvo == null){
			//帳號或密碼錯誤
			errMap.put("accountErr", "帳號或密碼錯誤");
			RequestDispatcher rd = req.getRequestDispatcher("loginMembers.jsp");
			rd.forward(req, res);
			return;
		}else{
			//登入成功!
			if(membersvo.isManager()){
				session.setAttribute("ManagerLoginOK", membersvo);
			}else{
				session.setAttribute("MemberLoginOK", membersvo);
			}
			System.out.println(membersvo.getMemberId());
			System.out.println(membersvo.getEmail());
			System.out.println(membersvo.getPw());
			System.out.println(membersvo.getName());
			System.out.println(membersvo.getGender());
			System.out.println(membersvo.getBdate());
			System.out.println(membersvo.getAddr());
			System.out.println(membersvo.getTel());
			System.out.println(membersvo.getPersonId());
			System.out.println(membersvo.getCountry());
			System.out.println(membersvo.getPassport());
		

			if(requestURI == null){
				res.sendRedirect(contextPath + "/index.jsp");
				return;
			}else{
				res.sendRedirect(requestURI + "?" + queryString);
				return;
			}
			
			
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		doGet(req, res);
	}

}
