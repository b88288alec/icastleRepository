package com.icastle.hotels.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icastle.hotelInfo.modle.*;
import com.icastle.hotelphotos.model.*;
import com.icastle.hotels.model.*;



@WebServlet("/hotel/Registerhotel.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class RegisterhotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterhotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errMap = new HashMap<String,String>();
		request.setAttribute("errMap", errMap);
		request.setCharacterEncoding("UTF-8");
		
		String hotelName = "";
		String email = "";
		String pw = "";
		String pwcheck = "";
		String starStr = "";
		String registerName = "";
		String registerId = "";
		String tel = "";
		String addr = "";
		String zone = "";
		String transport = "";
		String website = "";
		String hotelProfile = "";
		String checkinStr = "";
		String checkoutStr = "";
		String guestPolicies = "";
		String cancelPolicies = "";
		String roomWifiStr = "";
		String hallWifiStr = "";
		String internetStr = "";
		String mineralWaterStr = "";
		String toiletUtensilsStr = "";
		String hairDryerStr = "";
		String tvStr = "";
		String gameRoomStr = "";
		String gymStr = "";
		String spaStr = "";
		String swimPoolStr = "";
		long size = 0;
		InputStream is = null;
		
		try {
			Collection<Part> parts = request.getParts();
			//GlobalService.exploreParts(parts, request);
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					//如果上傳的是字串並非檔案則getContentType()回傳null
					if (p.getContentType() == null) {
						if (fldName.equals("hotelName")) {
							hotelName = value;
							if (hotelName == null || hotelName.trim().length() == 0) {
								errMap.put("hotelNameErr", "請輸入飯店名稱");
							}
							System.out.println("飯店名稱");
						} else if (fldName.equals("email")) {
							email = value;
							if (email == null || email.trim().length() == 0) {
								errMap.put("emailErr", "請輸入E-mail");
							}
							System.out.println("email");
						} else if (fldName.equals("pw")) {
							pw = value;
							if (pw == null || pw.trim().length() == 0) {
								errMap.put("pwErr", "請輸入密碼");
							} 
							System.out.println("密碼");
						} else if (fldName.equals("pwcheck")) {
							pwcheck = value;
							if (pwcheck == null || pwcheck.trim().length() == 0) {
								errMap.put("pwcheckErr", "請輸入確認密碼");
							} 
						} else if (fldName.equals("star")) {
							starStr = value;
							if (starStr.trim().equals("0")) {
								errMap.put("starErr", "請選擇飯店星等");
							} 
						} else if (fldName.equals("registerName")) {
							registerName = value;
							if (registerName == null || registerName.trim().length() == 0) {
								errMap.put("registerNameErr", "請輸入登記人姓名");
							} 
						} else if (fldName.equals("registerId")) {
							registerId = value;
							if (registerId == null || registerId.trim().length() == 0) {
								errMap.put("registerIdErr", "請輸入登記證號");
							} 
						} else if (fldName.equals("tel")) {
							tel = value;
							if (tel == null || tel.trim().length() == 0) {
								errMap.put("telErr", "請輸入連絡電話");
							} 
						} else if (fldName.equals("addr")) {
							addr = value;
							if (addr == null || addr.trim().length() == 0) {
								errMap.put("addrErr", "請輸入地址");
							} 
						} else if (fldName.equals("zone")) {
							zone = value;
							if (zone == null || zone.trim().length() == 0) {
								errMap.put("zoneErr", "請輸入地區");
							} 
						} else if (fldName.equals("transport")) {
							transport = value;
							if (transport == null || transport.trim().length() == 0) {
								errMap.put("transportErr", "請輸入交通方式");
							} 
						}  else if (fldName.equals("website")) {
							website = value;
						} else if (fldName.equals("hotelProfile")) {
							hotelProfile = value;
							if (hotelProfile == null || hotelProfile.trim().length() == 0) {
								errMap.put("hotelProfileErr", "請輸入飯店介紹");
							} 
						} else if (fldName.equals("checkin")) {
							checkinStr = value;
							if (checkinStr == null || checkinStr.trim().length() == 0) {
								errMap.put("checkinErr", "請輸入最早checkin時間");
							} 
						} else if (fldName.equals("checkout")) {
							checkoutStr = value;
							if (checkoutStr == null || checkoutStr.trim().length() == 0) {
								errMap.put("checkoutErr", "請輸入最晚checkout時間");
							} 
						} else if (fldName.equals("guestPolicies")) {
							guestPolicies = value;
							if (guestPolicies == null || guestPolicies.trim().length() == 0) {
								errMap.put("guestPoliciesErr", "請輸入入住須知");
							} 
						} else if (fldName.equals("cancelPolicies")) {
							cancelPolicies = value;
							if (cancelPolicies == null || cancelPolicies.trim().length() == 0) {
								errMap.put("cancelPoliciesErr", "請輸入取消規定");
							} 
						} else if (fldName.equals("roomWifi")) {
							roomWifiStr = value;
						} else if (fldName.equals("hallWifi")) {
							hallWifiStr = value;
						} else if (fldName.equals("internet")) {
							internetStr = value;
						} else if (fldName.equals("mineralWater")) {
							mineralWaterStr = value;
						} else if (fldName.equals("toiletUtensils")) {
							toiletUtensilsStr = value;
						} else if (fldName.equals("hairDryer")) {
							hairDryerStr = value;
						} else if (fldName.equals("tv")) {
							tvStr = value;
						} else if (fldName.equals("gameRoom")) {
							gameRoomStr = value;
						} else if (fldName.equals("gym")) {
							gymStr = value;
						} else if (fldName.equals("spa")) {
							spaStr = value;
						} else if (fldName.equals("swimPool")) {
							swimPoolStr = value;
						}  
					} else {
						//contentType==null為圖片
						size = p.getSize();
						is = p.getInputStream();
						System.out.println("size= " + size);
						if (size == 0)
							errMap.put("photoErr", "必須挑選圖片檔");
						System.out.println("圖片");
					}
				}//for (Part p : parts)結束
			} else {
				//part==null 空的
				errMap.put("errTitle", "此表單不是上傳檔案的表單");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}//try catch結束
				
		//如果有任何欄位沒有輸入入
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("registerhotel.jsp");
			rd.forward(request, response);
			return;
		}
		
		/*商業邏輯*/
		//確認邏輯有無錯誤
		if (!pw.equals(pwcheck))
			errMap.put("pwcheckErr", "確認密碼錯誤");
		
		//將星等轉換成數字
		Integer star = null; 
		try {
		star = Integer.parseInt(starStr);
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		
		//email是否有重複
		HotelService hotelServ = new HotelService();
		if (hotelServ.findByEmail(email) != null)
			errMap.put("emailErr", "此email已經註冊");
		
		//得到圖檔的byte
		byte[] photobyte = new byte[(int)size];
		is.read(photobyte);
		System.out.println("size= "+ photobyte.length);
		
		/*商業邏輯結束*/
		
		//若是有錯秀出錯誤訊息
		if (!errMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("registerhotel.jsp");
			rd.forward(request, response);
			return;
		}

		//取得設施
		Boolean roomWifi = (roomWifiStr=="") ? false : true;
		Boolean hallWifi = (hallWifiStr=="") ? false : true;
		Boolean internet = (internetStr=="") ? false : true;
		Boolean mineralWater = (mineralWaterStr=="") ? false : true;
		Boolean toiletUtensils = (toiletUtensilsStr=="") ? false : true;
		Boolean hairDryer = (hairDryerStr=="") ? false : true;
		Boolean tv = (tvStr=="") ? false : true;
		Boolean gameRoom = (gameRoomStr=="") ? false : true;
		Boolean gym = (gymStr=="") ? false : true;
		Boolean spa = (spaStr=="") ? false : true;
		Boolean swimPool = (swimPoolStr=="") ? false : true;

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
		InfoVO infoVO = new InfoVO();
		infoVO.setHotelId(hotel.getHotelId());
		infoVO.setRegisterName(registerName);
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
		
		infoServ.insert(infoVO);
		
		//呼叫HotelPhotoDAO
		HotelPhotosService photoServ = new HotelPhotosService();
		HotelPhotosVO photovo = new HotelPhotosVO();
		photovo.setHotelId(hotelvo.getHotelId());
		photovo.setPhotoOrder(1);
		photovo.setPhoto(photobyte);
		photovo.setRoomTypeId(null);
		photovo.setPohtoDescription("飯店的一樓入口圖");
		List<HotelPhotosVO> photos = new ArrayList<HotelPhotosVO>();
		photos.add(photovo);
		photoServ.addPhoto(photos);
		
		System.out.println("transport:" + transport);
		
		//轉交到展示層
		RequestDispatcher rd = request.getRequestDispatcher("registerOK.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
