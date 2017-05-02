package com.icastle.hotels.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelInfo.modle.*;
import com.icastle.hotels.model.*;

@WebServlet("/hotel/Registerhotel.do")
public class RegisterhotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterhotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errMap = new HashMap<String,String>();
		request.setAttribute("errMap", errMap);
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String hotelName = request.getParameter("hotelName");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pwcheck = request.getParameter("pwcheck");
		Integer star = Integer.parseInt(request.getParameter("star"));
		String registerName = request.getParameter("registerName");
		String registerId = request.getParameter("registerId");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String zone = request.getParameter("zone");
		String transport = request.getParameter("transport");
		String website = request.getParameter("website");
		String hotelProfile = request.getParameter("hotelProfile");
		String checkinStr = request.getParameter("checkin");
		String checkoutStr = request.getParameter("checkout");
		String guestPolicies = request.getParameter("guestPolicies");
		String cancelPolicies = request.getParameter("cancelPolicies");
		String roomWifiStr = request.getParameter("roomWifi");
		String hallWifiStr = request.getParameter("hallWifi");
		String internetStr = request.getParameter("internet");
		String mineralWaterStr = request.getParameter("mineralWater");
		String toiletUtensilsStr = request.getParameter("toiletUtensils");
		String hairDryerStr = request.getParameter("hairDryer");
		String tvStr = request.getParameter("tv");
		String gameRoomStr = request.getParameter("gameRoom");
		String gymStr = request.getParameter("gym");
		String spaStr = request.getParameter("spa");
		String swimPoolStr = request.getParameter("swimPool");
		
		//檢驗是否沒有輸入
		if (hotelName=="" || hotelName==null)
			errMap.put("hotelNameErr", "請輸入飯店名稱");
		
		if (email=="" || email==null)
			errMap.put("emailErr", "請輸入E-mail");
			
		if (pw=="" || pw==null)
			errMap.put("pwErr", "請輸入密碼");
		
		if (pwcheck=="" || pwcheck==null)
			errMap.put("pwcheckErr", "請輸入確認密碼");
		
		if (star == 0)
			errMap.put("starErr", "請選擇飯店星等");
		
		if (registerName=="" || registerName==null)
			errMap.put("registerNameErr", "請輸入登記人姓名");
		
		if (registerId=="" || registerId==null)
			errMap.put("registerIdErr", "請輸入登記證號");
		
		if (tel=="" || tel==null)
			errMap.put("telErr", "請輸入連絡電話");
		
		if (addr=="" || addr==null)
			errMap.put("addrErr", "請輸入地址");
		
		if (zone=="" || zone==null)
			errMap.put("zoneErr", "請輸入地區");
		
		if (transport=="" || transport==null)
			errMap.put("transportErr", "請輸入交通方式");
		
		if (hotelProfile=="" || hotelProfile==null)
			errMap.put("hotelProfileErr", "請輸入飯店介紹");
		
		if (checkinStr=="" || checkinStr==null)
			errMap.put("checkinErr", "請輸入最早checkin時間");
		
		if (checkoutStr=="" || checkoutStr==null)
			errMap.put("checkoutErr", "請輸入最晚checkout時間");

		if (guestPolicies=="" || guestPolicies==null)
			errMap.put("guestPoliciesErr", "請輸入入住須知");
		
		if (cancelPolicies=="" || cancelPolicies==null)
			errMap.put("cancelPoliciesErr", "請輸入取消規定");
		
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("registerhotel.jsp");
			rd.forward(request, response);
			return;
		}
		
		//確認無誤之後準備寫入資料庫
		if (!pw.equals(pwcheck))
			errMap.put("pwcheckErr", "確認密碼錯誤");
		
		HotelService hotelServ = new HotelService();
		if (!hotelServ.isEmailOK(email))
			errMap.put("emailErr", "此email已經註冊");
		
		//若是有錯秀出錯誤訊息
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("registerhotel.jsp");
			rd.forward(request, response);
			return;
		}

		//取得設施
		Boolean roomWifi = (roomWifiStr==null) ? false : true;
		Boolean hallWifi = (hallWifiStr==null) ? false : true;
		Boolean internet = (internetStr==null) ? false : true;
		Boolean mineralWater = (mineralWaterStr==null) ? false : true;
		Boolean toiletUtensils = (toiletUtensilsStr==null) ? false : true;
		Boolean hairDryer = (hairDryerStr==null) ? false : true;
		Boolean tv = (tvStr==null) ? false : true;
		Boolean gameRoom = (gameRoomStr==null) ? false : true;
		Boolean gym = (gymStr==null) ? false : true;
		Boolean spa = (spaStr==null) ? false : true;
		Boolean swimPool = (swimPoolStr==null) ? false : true;
		
		//呼叫HotelDAO
		HotelVO hotelvo = new HotelVO();
		hotelvo.setHotelName(hotelName);
		hotelvo.setEmail(email);
		hotelvo.setPw(pw);
		hotelvo.setAddr(addr);
		hotelvo.setZone(zone);
		hotelvo.setPoint(0.0);
		hotelvo.setHot(0);
		hotelvo.setStar(star);
		hotelvo.setHotelState(0);
		hotelvo.setRegisterId(registerId);
		HotelVO hotel = hotelServ.addHotel(hotelvo);
		
		//呼叫HotelInfoDAO
		InfoService infoServ = new InfoService();
		infoServ.insert(hotel.getHotelId(), registerName, tel, transport, website, hotelProfile, checkinStr, checkoutStr, guestPolicies, cancelPolicies, roomWifi, hallWifi, internet, mineralWater, toiletUtensils, hairDryer, tv, gameRoom, gym, spa, swimPool);
		
		//呼叫HotelPhotoDAO
		
		//轉交到展示層
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
