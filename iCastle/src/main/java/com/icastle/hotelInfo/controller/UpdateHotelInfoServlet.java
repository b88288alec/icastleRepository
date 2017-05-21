package com.icastle.hotelInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotelInfo.modle.InfoService;
import com.icastle.hotelInfo.modle.InfoVO;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/hotelcenter/UpdateHotelInfo.do")
public class UpdateHotelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateHotelInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errMap = new HashMap<String,String>();
		HttpSession session = request.getSession();
		InfoVO infoVO = (InfoVO)session.getAttribute("HotelInfo");
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		request.setAttribute("errMap", errMap);
		request.setCharacterEncoding("UTF-8");
		
		String tel = request.getParameter("tel");
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
		
		//不能空白
		if (tel == null || tel.trim().length() == 0) 
			errMap.put("telErr", "請輸入連絡電話");
		
		if (transport == null || transport.trim().length() == 0) 
			errMap.put("transportErr", "請輸入交通方式");
			
		if (hotelProfile == null || hotelProfile.trim().length() == 0) 
			errMap.put("hotelProfileErr", "請輸入飯店介紹");
			
		if (checkinStr == null || checkinStr.trim().length() == 0) 
			errMap.put("checkinErr", "請輸入最早checkin時間");	
			
		if (checkoutStr == null || checkoutStr.trim().length() == 0) 
			errMap.put("checkoutErr", "請輸入最晚checkout時間");
		
		if (guestPolicies == null || guestPolicies.trim().length() == 0) 
			errMap.put("guestPoliciesErr", "請輸入入住須知");
		
		if (cancelPolicies == null || cancelPolicies.trim().length() == 0) 
			errMap.put("cancelPoliciesErr", "請輸入取消規定");
		
		//如果有任何欄位沒有輸入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("updateHotelInfo.jsp");
			rd.forward(request, response);
			return;
		}

		//取得設施
		Boolean roomWifi = (roomWifiStr=="" || roomWifiStr==null) ? false : true;
		Boolean hallWifi = (hallWifiStr=="" || hallWifiStr==null) ? false : true;
		Boolean internet = (internetStr=="" || internetStr==null) ? false : true;
		Boolean mineralWater = (mineralWaterStr=="" || mineralWaterStr==null) ? false : true;
		Boolean toiletUtensils = (toiletUtensilsStr=="" || toiletUtensilsStr==null) ? false : true;
		Boolean hairDryer = (hairDryerStr=="" || hairDryerStr==null) ? false : true;
		Boolean tv = (tvStr=="" || tvStr==null) ? false : true;
		Boolean gameRoom = (gameRoomStr=="" || gameRoomStr==null) ? false : true;
		Boolean gym = (gymStr=="" || gymStr==null) ? false : true;
		Boolean spa = (spaStr=="" || spaStr==null) ? false : true;
		Boolean swimPool = (swimPoolStr=="" || swimPoolStr==null) ? false : true;

		//呼叫HotelInfoDAO
		InfoService infoServ = new InfoService();
		
		infoVO.setHotelId(hotelvo.getHotelId());
		infoVO.setTel(tel);
		infoVO.setTransport(transport);
		infoVO.setWebsite(website);
		infoVO.setHotelProfile(hotelProfile);
		infoVO.setCheckin(checkinStr);
		infoVO.setCheckout(checkoutStr);
		infoVO.setGuestPolicies(guestPolicies);
		infoVO.setCancelPolicies(cancelPolicies);
		infoVO.setRoomWifi(roomWifi);
		infoVO.setHallWifi(hallWifi);
		infoVO.setInternet(internet);
		infoVO.setMineralWater(mineralWater);
		infoVO.setToiletUtensils(toiletUtensils);
		infoVO.setHairDryer(hairDryer);
		infoVO.setTv(tv);
		infoVO.setGameRoom(gameRoom);
		infoVO.setGym(gym);
		infoVO.setSpa(spa);
		infoVO.setSwimPool(swimPool);
		
		infoServ.update(infoVO);

		session.removeAttribute("HotelInfo");
		
		//轉交畫面
		request.setAttribute("OK", "修改成功");
		RequestDispatcher rd = request.getRequestDispatcher("ShowHotelInfo.do");
		rd.forward(request, response);
		return;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
