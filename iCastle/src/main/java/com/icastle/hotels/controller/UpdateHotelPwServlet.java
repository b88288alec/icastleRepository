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

@WebServlet("/hotelcenter/UpdateHotelPw.do")
public class UpdateHotelPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateHotelPwServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
    	request.setCharacterEncoding("UTF-8");
		Map<String,String> errMap = new HashMap<String,String>();
		request.setAttribute("errMap", errMap);
		
    	//抓到舊密碼新密碼
    	String oldpw = request.getParameter("oldpw");
    	String newpw = request.getParameter("newpw");
    	String checkNewpw = request.getParameter("checkNewpw");
    	
		//檢查是否所有欄位都有輸入
		if (oldpw==null || "".equals(oldpw))
			errMap.put("oldpwErr", "請輸入舊密碼");
		if (newpw==null || "".equals(newpw))
			errMap.put("newpwErr", "請輸入新密碼");
		if (checkNewpw ==null || "".equals(checkNewpw))
			errMap.put("chechNewpwErr", "請輸入確認新密碼");
		
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("updateHotelPw.jsp");
			rd.forward(request, response);
			return;
		}
    	
		/*商業邏輯*/
		//舊密碼是否正確
		if ( !oldpw.equals(hotelvo.getPw()) )
			errMap.put("oldpwnotcorrect", "密碼不正確");
		
		//新密碼和確認密碼是否相同
		if (!newpw.equals(checkNewpw))
			errMap.put("pwcheckErr", "確認密碼與密碼不同");
		
		//如果有任何錯誤
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("updateHotelPw.jsp");
			rd.forward(request, response);
			return;
		}
		
		//修改密碼
		HotelService hotelServ = new HotelService();
		hotelServ.changePw(hotelvo.getHotelId(), oldpw, newpw);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
