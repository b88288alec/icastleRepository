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
import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;
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
		String roomTypeId[] = request.getParameterValues("roomTypeId");
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
		String countId[] = request.getParameterValues("countId");
		String RegisterPath = request.getServletPath();
		
		Map<String,String> error = new HashMap<String,String>();
		if(roomTypeId == null){
			error.put("none", "沒有要新增的房型");
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("/hotelcenter/ShowRoomType.do");
			rd.forward(request, response);
			return;
		}
		
		
		List<String> bedAddablesList = new ArrayList<String>();
		List<String[]> mealsList = new ArrayList<String[]>();
		for(int i = 0; i < countId.length; i++){
			String bedAddables = request.getParameter("bedAddable"+Integer.parseInt(countId[i]));
			bedAddablesList.add(bedAddables);
			String meals[] = request.getParameterValues("meals"+Integer.parseInt(countId[i]));
			mealsList.add(meals);
		}
		
		
		List<RoomTypeVO> list = new ArrayList<RoomTypeVO>();
		List<RoomsVO> updateRoomsList = new ArrayList<RoomsVO>();
		
		for(int i = 0; i < roomTypeId.length; i++){
			System.out.println(roomTypeId.length);
			RoomTypeVO vo = new RoomTypeVO();
			Boolean updateRooms = false;
			if(!roomTypeId[i].equals("")){
				vo.setRoomTypeId(Integer.parseInt(roomTypeId[i]));
				updateRooms = true;
			}
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
			
			if(updateRooms){
				RoomsVO roomvo = new RoomsVO();
				roomvo.setRoomTypeId(Integer.parseInt(roomTypeId[i]));
				roomvo.setRoomTypeName(roomTypeName[i]);
				roomvo.setRoomNumber(Integer.parseInt(roomNumber[i]));
				if(isbreakfast==true)
					roomvo.setBreakfast(true);
				else
					roomvo.setBreakfast(false);
				
				if(isafternoontea==true)
					roomvo.setAfternoonTea(true);
				else
					roomvo.setAfternoonTea(false);
				
				if(isdinner==true)
					roomvo.setDinner(true);
				else
					roomvo.setDinner(false);
				roomvo.setBedAddable(Boolean.valueOf(bedAddablesList.get(i)));
				roomvo.setPricePerPerson(Integer.parseInt((pricePerPerson[i].equals(""))? "0" : pricePerPerson[i]));
				roomvo.setRemark(remark[i]);
				updateRoomsList.add(roomvo);
				updateRooms = false;
			}
		}
		
		RoomTypeService rots = new RoomTypeService();
		Integer updatecount = rots.addOrUpdateRoomType(list);
		Integer updatecountRooms = 0;
		if(updateRoomsList.size() != 0){
			RoomsService roms = new RoomsService();
			updatecountRooms = roms.updateDetail(updateRoomsList);
		}
		
		session.setAttribute("RoomTypeVOList", list);
		request.setAttribute("RegisterPath", RegisterPath);
		request.setAttribute("updatecount", updatecount);
		request.setAttribute("updatecountRooms", updatecountRooms);
		RequestDispatcher rd = request.getRequestDispatcher("/hotelcenter/ShowRoomType.do");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
