package com.icastle.rooms.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.icastle.hotels.model.HotelVO;
import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;
import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/rooms/SetRoomPrice")
public class SetRoomPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		if(hotelvo == null){
			response.sendRedirect("/iCastle/hotel/loginhotel.jsp");
			return;
		}
		RoomTypeService rots = new RoomTypeService();
		List<RoomTypeVO> roomTypeList = rots.findRoomTypeByHotelId(hotelvo.getHotelId());
		
		session.setAttribute("roomTypeList", roomTypeList);
		RequestDispatcher rd = request.getRequestDispatcher("calendar.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String jsonData = request.getParameter("jsonData");
		String roomTypeId = request.getParameter("roomTypeId");
		RoomTypeVO roomTypeVO = null;
		List<RoomsVO> roomslist = new ArrayList<RoomsVO>();
		
		HttpSession session = request.getSession();
		List<RoomTypeVO> roomTypeList = (List<RoomTypeVO>)session.getAttribute("roomTypeList");
		if(roomTypeId != null){
			for(RoomTypeVO vo : roomTypeList){
				if(vo.getRoomTypeId() == Integer.parseInt(roomTypeId)){
					roomTypeVO = vo;
				}
			}
		}
		
		
		JSONParser jsonpar = new JSONParser();
		Object obj = null;
		try {
			obj = jsonpar.parse(jsonData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		JSONArray jsonArray = (JSONArray)obj;
		
		for(Object mataobj : jsonArray){
			JSONObject jsonObj = (JSONObject)mataobj;
			
			Integer roomId = null;
			String roomIdstr = (String)jsonObj.get("roomId");
			if(roomIdstr != null){
				roomId = Integer.parseInt((String)jsonObj.get("roomId"));
			}
			String datestr = (String)jsonObj.get("date");
			Integer price = Integer.parseInt((String)jsonObj.get("price"));
			long datelong = 0;
			try {
				datelong = sdf.parse(datestr).getTime();
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			RoomsVO vo = new RoomsVO();
			if(roomId != null){
				vo.setRoomId(roomId);
			}
			vo.setRoomTypeId(roomTypeVO.getRoomTypeId());
			vo.setHotelId(roomTypeVO.getHotelId());
			vo.setRoomDate(new Date(datelong));
			vo.setRoomTypeName(roomTypeVO.getRoomTypeName());
			vo.setPeopleNum(roomTypeVO.getPeopleNum());
			vo.setBookedNum(0);
			vo.setRoomNumber(roomTypeVO.getRoomNumber());
			vo.setPrice(price);
			vo.setBreakfast(roomTypeVO.getBreakfast());
			vo.setDinner(roomTypeVO.getDinner());
			vo.setAfternoonTea(roomTypeVO.getAfternoonTea());
			vo.setBedAddable(roomTypeVO.getBedAddable());
			vo.setPricePerPerson(roomTypeVO.getPricePerPerson());
			vo.setRemark(roomTypeVO.getRemark());
			roomslist.add(vo);
			System.out.println(jsonObj);
		}
		
		Collections.sort(roomslist,new Comparator<RoomsVO>(){
			public int compare(RoomsVO vo1, RoomsVO vo2){
				Long vo1date = vo1.getRoomDate().getTime();
				Long vo2date = vo2.getRoomDate().getTime();
				return vo1date.compareTo(vo2date);
			}
		});
		
		RoomsService roms = new RoomsService();
		roms.insertRooms(roomslist);
		
	}

}
