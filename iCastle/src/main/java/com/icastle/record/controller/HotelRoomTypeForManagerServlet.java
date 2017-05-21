package com.icastle.record.controller;

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

import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;
import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/manager/HotelRoomTypeForManagerServlet")
public class HotelRoomTypeForManagerServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("hotelname");
		
		try{
			RecordService rs = new RecordService();
			List<RecordVO> records = rs.search_records_by_name(name, "0", "h%");
			
			if(!records.isEmpty()){
				Integer hotelId = new Integer(records.get(0).getId().substring(1));
				
				RoomTypeService rots = new RoomTypeService();
				List<RoomTypeVO> roomTypeList = rots.findRoomTypeByHotelId(hotelId);
				
				JSONObject result = new JSONObject();
				
				JSONArray ja = new JSONArray();
				for(RoomTypeVO rtvo : roomTypeList){
					JSONObject jo = new JSONObject();
					jo.put("rtid", String.valueOf(rtvo.getRoomTypeId()));
					jo.put("rtn", rtvo.getRoomTypeName());
					
					ja.add(jo);
				}
				
				JSONArray jsonArray = new JSONArray();
				for(RecordVO recVO : records){
					JSONArray injsonArray = new JSONArray();
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("recordTime", String.valueOf(recVO.getRecordTime()));
					jsonObj.put("name", recVO.getName());
					jsonObj.put("roomTypeName", recVO.getRoomTypeName());
					jsonObj.put("peopleNum", String.valueOf(recVO.getPeopleNum()));
					jsonObj.put("roomNumber", String.valueOf(recVO.getRoomNumber()));
					jsonObj.put("weekdaysPrice", String.valueOf(recVO.getWeekdaysPrice()));
					jsonObj.put("holidayPrice", String.valueOf(recVO.getHolidayPrice()));
					jsonObj.put("seasonPrice", String.valueOf(recVO.getSeasonPrice()));
					jsonObj.put("customizedPrice", String.valueOf(recVO.getCustomizedPrice()));
					jsonObj.put("customizedName", String.valueOf(recVO.getCustomizedName()));
					jsonObj.put("breakfast", String.valueOf(recVO.getBreakfast()));
					jsonObj.put("afternoonTea", String.valueOf(recVO.getAfternoonTea()));
					jsonObj.put("dinner", String.valueOf(recVO.getDinner()));
					jsonObj.put("bedAddable", String.valueOf(recVO.getBedAddable()));
					jsonObj.put("PrcePerPerson", String.valueOf(recVO.getPricePerPerson()));
					jsonObj.put("remark", String.valueOf(recVO.getRemark()));
					injsonArray.add(jsonObj);
					jsonArray.add(injsonArray);
				}
				
				result.put("hiddenid", hotelId);
				result.put("roomTypeAll", ja);
				result.put("hotelRecord", jsonArray);
				
				out.println(result);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
