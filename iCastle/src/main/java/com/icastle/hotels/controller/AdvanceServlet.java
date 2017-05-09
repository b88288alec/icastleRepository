package com.icastle.hotels.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;
import com.icastle.hotels.model.ListVO;

@WebServlet("/view/hotel/Advance.do")
public class AdvanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdvanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("errorMsgs", errorMsgs);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
				
		//接收參數
		request.setCharacterEncoding("UTF-8");
//		String type = (String) request.getParameter("type");
//		String start = (String) request.getParameter("start");
//		String end = (String) request.getParameter("end");
//		String peopleNumStr = (String) request.getParameter("peopleNum");
//		String order = request.getParameter("order");
//		Integer lowprice = Integer.parseInt(request.getParameter("lowprice"));
//		Integer highprice = Integer.parseInt(request.getParameter("highprice"));
//		Integer point = Integer.parseInt(request.getParameter("point"));
//		Integer star = Integer.parseInt(request.getParameter("star"));
		
		String type = "台北";
		String start = "2017/06/02";
		String end = "2017/06/04";
		Integer peopleNum = 4;
		String order = "熱門度";
		Integer lowprice = 0;
		Integer highprice = 20000;
		Double point = 3.1;
		Integer star = 3;
		
		//驗證關鍵字和人數是否有輸入 懶得做了
		
		//若有空白秀出錯誤訊息 懶得做了
		
		//資料型態轉換(start和end)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date startDate = null;
		try{
			startDate = new java.sql.Date(sdf.parse(start).getTime());
		} catch (ParseException e){
			errorMsgs.put("sdError", "請輸入正確日期");
		}
		
		java.sql.Date endDate = null;
		try{
			endDate = new java.sql.Date(sdf.parse(end).getTime());
		} catch (ParseException e){
			errorMsgs.put("edError", "請輸入正確日期");
		}

		HotelService hotelServ = new HotelService();
		List<ListVO> hotels = hotelServ.advancedQuery(type, startDate, endDate, peopleNum, order, lowprice, highprice, point, star);
		JSONArray list = new JSONArray();
		
		for (ListVO hotel : hotels){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("hotelId", hotel.getHotelId());
			map.put("hotelName", hotel.getHotelName());
			map.put("zone", hotel.getZone());
			map.put("price", hotel.getPrice());
			map.put("star", hotel.getStar());
			map.put("point", hotel.getPoint());
			map.put("hot", hotel.getHot());
			map.put("breakfast", hotel.isBreakfast());
			map.put("dinner", hotel.isDinner());
			map.put("roomWifi", hotel.isRoomWifi());
			list.add(map);
		}
		
		out.println(list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
