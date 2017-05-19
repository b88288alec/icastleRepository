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
			String rti = req.getParameter("roomTypeId");
			String m = req.getParameter("month");
			String s = req.getParameter("state");
			
//			對取到的參數做處理
			Integer roomTypeId = (!"null".equals(rti))?new Integer(rti) : null;
			Boolean state = (!"null".equals(s))?new Boolean(s) : null;
			Integer year1 = new Integer(2016);
			Integer year2 = new Integer(2017);
			Integer month = (!"null".equals(m))?new Integer(m) : null;
			
//			準備JSON格式
			JSONObject jo = new JSONObject();
			JSONArray jalabels = new JSONArray();
			JSONArray jaseries = new JSONArray();
			
//			查DB
			OrdersService os = new OrdersService();
			result1 = os.search_Line_Chart(hotelId, year1, roomTypeId, month, state);
			result2 = os.search_Line_Chart(hotelId, year2, roomTypeId, month, state);
			
//			準備陣列做資料對應
			JSONObject jo1 = new JSONObject();
			JSONObject jo2 = new JSONObject();
			JSONArray originvalue = new JSONArray();
			JSONArray resultvalue = new JSONArray();
			JSONArray fullresultvalue = new JSONArray();
			int num1 = result1.size();
			int num2 = result2.size();

//			判斷是否有查到資料
			if(num1 != 0 || num2 != 0){
//				判斷兩個參數數目是否相等
				if(num1 == num2){
//					取得陣列名稱
					String[] fullMonthOrDay = new String[num1];
					String[] monthOrDay = new String[num2];
					
//					從DB取出的資料塞到JSON裡
					int count1 = 0;
					for(OrdersChartVO oc : result1){
//						放入陣列
						fullMonthOrDay[count1] = oc.getValue();
						fullresultvalue.add((int)oc.getCount());
						count1++;
						
//						X軸放入JSON
						jalabels.add(oc.getValue());
					}
					
//					塞入第二份資料
					for(OrdersChartVO oc : result2){
//						放入最後的Integer陣列
						resultvalue.add((int)oc.getCount());
					}
					
//					兩份資料塞成物件
					jo1.put("name", String.valueOf(year1)+"年");
					jo1.put("data", fullresultvalue);
					jo2.put("name", String.valueOf(year2)+"年");
					jo2.put("data", resultvalue);
					
				}else{
					if(num1 > num2){
//						取得陣列名稱
						String[] fullMonthOrDay = new String[num1];
						String[] monthOrDay = new String[num2];
						
//						從DB取出的資料塞到JSON裡
						int count1 = 0;
						for(OrdersChartVO oc : result1){
//							放入陣列
							fullMonthOrDay[count1] = oc.getValue();
							fullresultvalue.add((int)oc.getCount());
							count1++;
							
//							X軸放入JSON
							jalabels.add(oc.getValue());
							
						}
						
//						判斷弟二份資料是否有值
						if(num2 != 0){
//							塞入第二份資料
							int count2 = 0;
							for(OrdersChartVO oc : result2){
//								放入陣列
								monthOrDay[count2] = oc.getValue();
									
//								放入最初的Integer陣列
								originvalue.add((int)oc.getCount());
								count2++;
							}
								
//							比較資料存入數字
							int y = 0;
							for(int x = 0; x < num1; x++){
								if(y < num2 && fullMonthOrDay[x].equals(monthOrDay[y])){
									resultvalue.add(originvalue.get(y));
									y++;
								}else{
									resultvalue.add(0);
								}
							}
						}else{
							for(int x = 0; x < num1; x++){
								resultvalue.add(0);
							}
						}
						
//						兩份資料塞成物件
						jo1.put("name", String.valueOf(year1)+"年");
						jo1.put("data", fullresultvalue);
						jo2.put("name", String.valueOf(year2)+"年");
						jo2.put("data", resultvalue);
						
					}else{
//						取得陣列名稱
						String[] fullMonthOrDay = new String[num2];
						String[] monthOrDay = new String[num1];
						
//						從DB取出的資料塞到JSON裡
						int count1 = 0;
						for(OrdersChartVO oc : result2){
							
//							放入陣列
							fullMonthOrDay[count1] = oc.getValue();
							fullresultvalue.add((int)oc.getCount());
							count1++;
							
//							X軸放入JSON
							jalabels.add(oc.getValue());
						}
						
//						判斷第二份資料是否有值
						if(num1 != 0){
//							塞入第二份資料
							int count2 = 0;
							for(OrdersChartVO oc : result1){
//								放入陣列
								monthOrDay[count2] = oc.getValue();
								
//								放入最初的Integer陣列
								originvalue.add((int)oc.getCount());
								count2++;
							}
							
//							比較資料存入數字
							int y = 0;
							for(int x = 0; x < num2; x++){
								if(y < num1 && fullMonthOrDay[x].equals(monthOrDay[y])){
									resultvalue.add(originvalue.get(y));
									y++;
								}else{
									resultvalue.add(0);
								}
							}
						}else{
							for(int x = 0; x < num2; x++){
								resultvalue.add(0);
							}
						}
						
//						兩份資料塞成物件
						jo1.put("name", String.valueOf(year2)+"年");
						jo1.put("data", fullresultvalue);
						jo2.put("name", String.valueOf(year1)+"年");
						jo2.put("data", resultvalue);
						
					}
					
				}
				
			}else{
				jalabels.add("");
				resultvalue.add(0);
				fullresultvalue.add(0);
				
//				兩份資料塞成物件
				jo1.put("name", String.valueOf(year1)+"年");
				jo1.put("data", fullresultvalue);
				jo2.put("name", String.valueOf(year2)+"年");
				jo2.put("data", resultvalue);
				
			}
			
//			放成JSON物件
			jaseries.add(jo1);
			jaseries.add(jo2);
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
