package com.icastle.roomtype.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelVO;
import com.icastle.roomtype.model.RoomTypeService;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/hotelcenter/roomtype/RegisterRoomType.do")
public class RegisterRoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		Integer hotelId = hotelvo.getHotelId();
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
		String timestr = request.getParameter("times");
		String RegisterPath = request.getServletPath();
		Integer times = 0;
		
		Map<String,String> error = new HashMap<String,String>();
		if(timestr.equals("")){
			error.put("none", "沒有要新增的房型");
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("/hotelcenter/ShowRoomType.do");
			rd.forward(request, response);
			return;
		}else{
			times = Integer.parseInt(timestr) - 1;
		}
		
		Integer count = Integer.parseInt(request.getParameter("count"));
		
		List<String> bedAddablesList = new ArrayList<String>();
		List<String[]> mealsList = new ArrayList<String[]>();
		if(count == 0){
			String bedAddables = request.getParameter("bedAddable0");
			bedAddablesList.add(bedAddables);
			String meals[] = request.getParameterValues("meals0");
			mealsList.add(meals);
		}else{
			for(int i = 0; i <= times; i++){
				count--;
				String bedAddables = request.getParameter("bedAddable"+count);
				bedAddablesList.add(bedAddables);
				String meals[] = request.getParameterValues("meals"+count);
				mealsList.add(meals);
			}
		}
		
		
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		
		for(int i = 0; i <= times; i++){
			RoomTypeVO vo = new RoomTypeVO();
			vo.setHotelId(hotelId);
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
			vo.setPricePerPerson(Integer.parseInt((pricePerPerson[i].equals(""))? "0" : pricePerPerson[i]));
			vo.setRemark(remark[i]);
			list.add(vo);
		}
		
		RoomTypeService rots = new RoomTypeService();
		Integer updatecount = rots.addOrUpdateRoomType(list);
		
		session.setAttribute("RoomTypeVOList", list);
		request.setAttribute("RegisterPath", RegisterPath);
		request.setAttribute("updatecount", updatecount);
		RequestDispatcher rd = request.getRequestDispatcher("/hotelcenter/ShowRoomType.do");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
