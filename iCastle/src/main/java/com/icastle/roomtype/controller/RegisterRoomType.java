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
import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;
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
		
		//判斷是否有更改資料
		Map<String,String> error = new HashMap<String,String>();
		if(roomTypeId == null){
			error.put("none", "沒有要新增的房型");
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("/hotelcenter/ShowRoomType.do");
			rd.forward(request, response);
			return;
		}
		
		//動態取得供餐及可否加床的資料
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
		List<RecordVO> recordList = new ArrayList<RecordVO>();
		
		//將收到的資料包裝為vo放入list準備寫入資料庫
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
			vo.setCustomizedPrice((customizedPrice[i].equals(""))?null:Integer.parseInt(customizedPrice[i]));
			vo.setCustomizedName((customizedName[i].equals(""))?null:customizedName[i]);
			
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
			vo.setRemark((remark[i].equals(""))?null:remark[i]);
			list.add(vo);
			
			//如果更新現有房型資料，連動更新今日之後的rooms資料
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
				roomvo.setRemark((remark[i].equals(""))?null:remark[i]);
				updateRoomsList.add(roomvo);
				updateRooms = false;
			}
		}
		
		
		
		RoomTypeService rots = new RoomTypeService();
		List<RoomTypeVO> histroy = rots.findRoomTypeByHotelId(hotelId);
		
		//將修改前的房型資料，存入record
		for(RoomTypeVO roomTypeVO : histroy){
			for(int i = 0; i < roomTypeId.length; i++){
				if(Integer.parseInt((roomTypeId[i].equals(""))? "0" : roomTypeId[i]) == roomTypeVO.getRoomTypeId()){
					RecordVO recordvo = new RecordVO();
					recordvo.setId("H" + hotelId);
					recordvo.setName(hotelvo.getHotelName());
					recordvo.setRoomTypeId(roomTypeVO.getRoomTypeId());
					recordvo.setRoomTypeName(roomTypeVO.getRoomTypeName());
					recordvo.setPeopleNum(roomTypeVO.getPeopleNum());
					recordvo.setRoomNumber(roomTypeVO.getRoomNumber());
					recordvo.setWeekdaysPrice(roomTypeVO.getWeekdaysPrice());
					recordvo.setHolidayPrice(roomTypeVO.getHolidayPrice());
					recordvo.setSeasonPrice(roomTypeVO.getSeasonPrice());
					recordvo.setCustomizedPrice(roomTypeVO.getCustomizedPrice());
					recordvo.setCustomizedName(roomTypeVO.getCustomizedName());
					recordvo.setBreakfast(roomTypeVO.getBreakfast());
					recordvo.setAfternoonTea(roomTypeVO.getAfternoonTea());
					recordvo.setDinner(roomTypeVO.getDinner());
					recordvo.setBedAddable(roomTypeVO.getBedAddable());
					recordvo.setPricePerPerson(roomTypeVO.getPricePerPerson());
					recordvo.setRemark(roomTypeVO.getRemark());
					recordvo.setManagerRecord(null);
					recordList.add(recordvo);
				}
			}
		}
		
		Integer updatecount = rots.addOrUpdateRoomType(list);
		RecordService recs = new RecordService();
		recs.hotelRecord(recordList);
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
