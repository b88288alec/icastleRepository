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

import globalservice.GlobalService;

@WebServlet("/hotel/CreateRandomPw.do")
public class CreateRandomPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateRandomPwServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		Map<String,String> errMap = new HashMap<String,String>();
		request.setAttribute("errMap", errMap);
		
		String email = request.getParameter("email");
		
		//檢查是否所有欄位都有輸入
		if (email==null || email=="")
			errMap.put("emailErr", "請輸入Email");
				
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("createrandompw.jsp");
			rd.forward(request, response);
			return;
		}	
		
		//查詢此email是否存在，若是不存在則秀出錯誤訊息
		HotelService hotelServ = new HotelService();
		HotelVO hotelvo = hotelServ.findByEmail(email);
		if (hotelvo == null){
			errMap.put("emailErr2", "Email不正確");
			RequestDispatcher rd = request.getRequestDispatcher("createrandompw.jsp");
			rd.forward(request, response);
			return;
		}
		
		//產生新的亂數密碼並寄出email
		String newPw = hotelServ.createPw(hotelvo.getHotelId());
		System.out.println("您的新密碼為"+newPw);
		GlobalService gs = new GlobalService();
		gs.SendGmail(email, "忘記密碼", "您的新密碼為"+newPw);
		
		//成功寄信,跳轉化面
		request.setAttribute("success", "已寄送新密碼到您的信箱");
		RequestDispatcher rd = request.getRequestDispatcher("createrandompw.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
