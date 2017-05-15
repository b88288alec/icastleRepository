package com.icastle.members.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelService;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

import globalservice.CheckId;

@WebServlet("/general/members/Member.do")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MembersServlet() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);
//      接收使用者輸入資料		       
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String pwcheck = req.getParameter("pwcheck");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String bdate = req.getParameter("bdate");
		String addr = req.getParameter("addr");
		String tel = req.getParameter("tel");
		String personId = req.getParameter("personId");
		String country = req.getParameter("country");
		String passport = req.getParameter("passport");
		

		
//		MembersVO membersVO = new MembersVO();
//		membersVO.setEmail(email);
//		membersVO.setPw(pw);
//		membersVO.setName(name);
//		membersVO.setGender(gender);
//		membersVO.setBdate(bDate);
//		membersVO.setAddr(addr);
//		membersVO.setTel(tel);
//		membersVO.setPersonId(personId);
//		membersVO.setCountry(country);
//		membersVO.setPassport(passport);
		
//		CheckId.checkID(personId);
		
		if (email=="" || email==null)
			errorMsgs.put("emailErr", "請輸入E-mail");
		
		MembersService ms = new MembersService();
		if (ms.findByEmail(email) != null)
			errorMsgs.put("emailErr", "此email已經註冊");
		
		if (pw=="" || pw==null)
			errorMsgs.put("pwErr", "請輸入密碼");
		
		if (pwcheck=="" || pwcheck==null)
			errorMsgs.put("pwcheckErr", "請輸入密碼");
		
		if (!pw.equals(pwcheck))
			errorMsgs.put("pwcheckErr", "確認密碼錯誤");
		
		
		if (name != "") {
			String nameRegex = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (!name.trim().matches(nameRegex)) {
				errorMsgs.put("nameErr", "姓名只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
		} else {
			errorMsgs.put("nameErr", "姓名不可空白");
		}
		
		if (gender=="" || gender==null)
			errorMsgs.put("genderErr", "請輸入性別");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date bDate = null;
		try{
			bDate = new java.sql.Date(sdf.parse(bdate).getTime());
		} catch (ParseException e){
			errorMsgs.put("bdateError", "請輸入正確日期yyyy/MM/dd");
		}

		
		if (addr=="" || addr==null)
			errorMsgs.put("addrErr", "請輸入地址");

		
		if (tel != "") {
			String telRegex = "^[(0-9)]{9,20}$";
			if (!tel.trim().matches(telRegex)) {
				errorMsgs.put("telErr", "電話號碼只能是數字，且長度必須在9到20之間");
			}
		} else {
			errorMsgs.put("telErr", "連絡人電話不可空白");
		}
		
		
		if (personId=="" || personId==null){
			errorMsgs.put("personIdErr", "身分證字號不可以是空的");
		}else if(!CheckId.checkID(personId)){
			errorMsgs.put("personIdErr", "身分證字號輸入錯誤");
		}
			

		
//		MembersService ms = new MembersService();
//		if (ms.findByEmail(email) != null)
//			errorMsgs.put("emailErr", "此email已經註冊");
		
		
//		ms.insert(email, pw, name, gender, bDate, addr, tel, personId, country, passport);
		
//		MembersVO membersVO = ms.findByPrimaryKey(email);
//		
//		req.setAttribute("membersVO", membersVO);
		
		
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher rd = req.getRequestDispatcher("registered.jsp");
			rd.forward(req, res);
			return;
		}
		
		ms.insert(email, pw, name, gender, bDate, addr, tel, personId, country, passport);
        MembersVO membersVO = ms.findByPrimaryKey(email);
		
		req.setAttribute("membersVO", membersVO);
		
		HttpSession session = req.getSession();
		
		
		MembersVO membersvo = ms.login(email, pw);
		
		session.setAttribute("MemberLoginOK", membersvo);

		RequestDispatcher rd = req.getRequestDispatcher("../../members/registeredOk.jsp");
		rd.forward(req, res);
		return;
		

		
		
//		RequestDispatcher rd = req.getRequestDispatcher("registered.jsp");
//		rd.forward(req, res);
//		return;
		
	}

}
