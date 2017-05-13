package com.icastle.Orders.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.Orders.model.OrdersChartVO;
import com.icastle.Orders.model.OrdersService;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/hotelcenter/OrdersLineChartServlet")
public class OrdersLineChartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		HotelVO hotel = (HotelVO)session.getAttribute("HotelLoginOK");
		List<OrdersChartVO> result1 = null;
		List<OrdersChartVO> result2 = null;
		
		try{
//			從前端取值
			Integer hotelId = hotel.getHotelId();
			String y1 = "2016";
			String y2 = "2017";
			String rti = req.getParameter("roomTypeId");
			String m = req.getParameter("month");
			String s = req.getParameter("state");
			
//			對取到的參數做處理
			Integer roomTypeId = (!"null".equals(rti))?new Integer(rti) : null;
			Boolean state = (!"null".equals(s))?new Boolean(s) : null;
			Integer year1 = new Integer(y1);
			Integer year2 = new Integer(y2);
			Integer month = (!"null".equals(m))?new Integer(m) : null;
			
//			查DB
			OrdersService os = new OrdersService();
			result1 = os.search_Line_Chart(hotelId, roomTypeId, year1, month, state);
			result2 = os.search_Line_Chart(hotelId, roomTypeId, year2, month, state);
			
//			準備JSON格式
			JSONObject jo = new JSONObject();
			JSONArray jalabels = new JSONArray();
			JSONArray jaseries = new JSONArray();
			
//			準備陣列做資料對應
			String[] fullMonthOrDay = new String[result1.size()];
			String[] monthOrDay = new String[result2.size()];
			Integer[] originvalue = new Integer[result2.size()];
			Integer[] resultvalue = new Integer[result1.size()];
			Integer[] fullresultvalue = new Integer[result1.size()];
			
//			從DB取出的資料塞到JSON裡
			int count1 = 0;
			for(OrdersChartVO oc : result1){
				
//				放入陣列
				fullMonthOrDay[count1] = oc.getValue();
				fullresultvalue[count1] = (int)oc.getCount();
				count1++;

//				X軸放入JSON
				jalabels.add(oc.getValue());
			}
			
//			塞入第二份資料
			int count2 = 0;
			for(OrdersChartVO oc : result2){
				
//				放入陣列
				monthOrDay[count2] = oc.getValue();
				
//				放入最初的Integer陣列
				originvalue[count2] = (int)oc.getCount();
				count2++;
			}
			
//			比較資料存入數字
			for(int x = 0; x < result1.size(); x++){
				if(fullMonthOrDay[x].equals(monthOrDay[x])){
					resultvalue[x] = originvalue[x];
				}else{
					resultvalue[x] = 0;
				}
			}
			
//			放成JSON物件
			jaseries.add(fullresultvalue);
			jaseries.add(resultvalue);
			jo.put("labels", jalabels);
			jo.put("series", jaseries);
			
//			拋出前端
			out.println(jo);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
