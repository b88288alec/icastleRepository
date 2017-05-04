package com.icastle.roomtype.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/roomtype/RegisterRoomType.do")
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
		String pricePerPerson[] = request.getParameterValues("pricePerPerson");
		String remark[] = request.getParameterValues("remark");
		Integer times = Integer.parseInt((request.getParameter("times").equals(""))? "0" : request.getParameter("times"));
		
		List<String> bedAddablesList = new ArrayList<String>();
		List<String[]> mealsList = new ArrayList<String[]>();
		if(times == 0){
			String bedAddables = request.getParameter("bedAddable0");
			bedAddablesList.add(bedAddables);
			String meals[] = request.getParameterValues("meals0");
			mealsList.add(meals);
		}else{
			for(int i = 0; i <= times; i++){
				String bedAddables = request.getParameter("bedAddable"+i);
				bedAddablesList.add(bedAddables);
				String meals[] = request.getParameterValues("meals"+i);
				mealsList.add(meals);
			}
		}
		
		
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		
		for(int i = 0; i <= times; i++){
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
			
			Boolean isbreakfast = false;
			Boolean isdinner = false;
			Boolean isafternoontea = false;
			for(int j = 0; j < mealsList.get(i).length; j++){
				String meals[] = mealsList.get(i);
				if(meals[j].equals("0")){
					isbreakfast = true;
				}
				if(meals[j].equals("1")){
					isafternoontea = true;
				}
				if(meals[j].equals("2")){
					isdinner  = true;
				}
				
			}
			if(isbreakfast==true)
				vo.setBreakfast(true);
			else
				vo.setBreakfast(false);
			
			if(isafternoontea==true)
				vo.setAfternoonTea(true);
			else
				vo.setAfternoonTea(false);
			
			if(isdinner==true)
				vo.setDinner(true);
			else
				vo.setDinner(false);
			
			vo.setBedAddable(Boolean.valueOf(bedAddablesList.get(i)));
			vo.setPricePerPerson(Integer.parseInt(pricePerPerson[i]));
			vo.setRemark(remark[i]);
			list.add(vo);
		}
		
		RoomTypeService rots = new RoomTypeService();
		Integer count = rots.addOrUpdateRoomType(list);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("RoomTypeVOList", list);
		RequestDispatcher rd = request.getRequestDispatcher("../rooms/FakeDataGen.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("../rooms/SetRoomPrice");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
