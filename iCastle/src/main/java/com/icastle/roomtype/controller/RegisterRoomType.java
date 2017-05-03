package com.icastle.roomtype.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/RegisterRoomType.do")
public class RegisterRoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String hotelId[] = request.getParameterValues("hotelId");
		String roomTypeName[] = request.getParameterValues("roomTypeName");
		String peopleNum[] = request.getParameterValues("peopleNum");
		String roomNumber[] = request.getParameterValues("roomNumber");
		String weekdaysPrice[] = request.getParameterValues("weekdaysPrice");
		String holidayPrice[] = request.getParameterValues("holidayPrice");
		String seasonPrice[] = request.getParameterValues("seasonPrice");
		String customizedPrice[] = request.getParameterValues("customizedPrice");
		String customizedName[] = request.getParameterValues("customizedName");
		String breakfast[] = request.getParameterValues("breakfast");
		String afternoonTea[] = request.getParameterValues("afternoonTea");
		String dinner[] = request.getParameterValues("dinner");
		String bedAddable[] = request.getParameterValues("bedAddable");
		String pricePerPerson[] = request.getParameterValues("pricePerPerson");
		String remark[] = request.getParameterValues("remark");
		
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		
		for(int i = 0; i < roomTypeName.length; i++){
			RoomTypeVO vo = new RoomTypeVO();
			vo.setHotelId(Integer.parseInt(hotelId[i]));
			vo.setRoomTypeName(roomTypeName[i]);
			vo.setPeopleNum(Integer.parseInt(peopleNum[i]));
			vo.setRoomNumber(Integer.parseInt(roomNumber[i]));
			vo.setWeekdaysPrice(Integer.parseInt(weekdaysPrice[i]));
			vo.setHolidayPrice(Integer.parseInt(holidayPrice[i]));
			vo.setSeasonPrice(Integer.parseInt(seasonPrice[i]));
			vo.setCustomizedPrice(Integer.parseInt(customizedPrice[i]));
			vo.setCustomizedName(customizedName[i]);
			vo.setBreakfast(Boolean.valueOf(breakfast[i]));
			vo.setAfternoonTea(Boolean.valueOf(afternoonTea[i]));
			vo.setDinner(Boolean.valueOf(dinner[i]));
			vo.setBedAddable(Boolean.valueOf(bedAddable[i]));
			vo.setPricePerPerson(Integer.parseInt(pricePerPerson[i]));
			vo.setRemark(remark[i]);
			list.add(vo);
		}
		
		RoomTypeService rots = new RoomTypeService();
		Integer count = rots.addOrUpdateRoomType(list);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
