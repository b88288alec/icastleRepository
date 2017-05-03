package com.icastle.hotels.controller;

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

import com.icastle.hotels.model.*;

@WebServlet("/hotel/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		Map<String,String> errMap = new HashMap<String,String>();
		request.setAttribute("errMap", errMap);
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//檢查是否所有欄位都有輸入
		if (email==null || email=="")
			errMap.put("emailErr", "請輸入Email");
		
		if (pw==null || pw=="")
			errMap.put("pwErr", "請輸入密碼");
		
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("loginhotel.jsp");
			rd.forward(request, response);
			return;
		}
		
		//呼叫model
		HotelService hotelServ = new HotelService();
		HotelVO hotelvo = hotelServ.checkAccountPw(email, pw);
		
		if (hotelvo == null){
			//帳號或密碼錯誤
			errMap.put("accountErr", "帳號或密碼錯誤");
			RequestDispatcher rd = request.getRequestDispatcher("loginhotel.jsp");
			rd.forward(request, response);
			return;
		}else{
			//登入成功!
			session.setAttribute("LoginOK", hotelvo);
			
			System.out.println(hotelvo.getHotelId());
			System.out.println(hotelvo.getHotelName());
			System.out.println(hotelvo.getEmail());
			System.out.println(hotelvo.getPw());
			System.out.println(hotelvo.getAddr());
			System.out.println(hotelvo.getZone());
			System.out.println(hotelvo.getPoint());
			System.out.println(hotelvo.getHot());
			System.out.println(hotelvo.getStar());
			System.out.println(hotelvo.getHotelState());
			System.out.println(hotelvo.getRegisterId());
			
			response.sendRedirect(contextPath + "/index.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
