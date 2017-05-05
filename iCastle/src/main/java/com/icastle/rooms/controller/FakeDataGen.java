package com.icastle.rooms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;
import com.icastle.roomtype.model.RoomTypeVO;

@WebServlet("/rooms/FakeDataGen.do")
public class FakeDataGen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		HttpSession session = request.getSession();
		List<RoomTypeVO> list = (List<RoomTypeVO>)session.getAttribute("RoomTypeVOList");
		List<RoomsVO> listForInsert = new ArrayList<RoomsVO>();
		List<StringBuffer> listStringBuffer = new ArrayList<StringBuffer>();

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), (Integer.parseInt(month) - 1), 1);
		
		

		for (RoomTypeVO typeVO : list) {
			
			for (int i = 1; i <= cal.getActualMaximum(cal.DATE); i++) {
				String insert = "insert into Rooms(roomTypeId, hotelId, roomDate, RoomTypeName, peopleNum, bookedNum, roomNumber, price, breakfast, dinner, afternoonTea, bedAddable, pricePerPerson, remark) values(";
				StringBuffer sbuf = new StringBuffer(insert);
				RoomsVO vo = new RoomsVO();
				vo.setRoomTypeId(typeVO.getRoomTypeId());
				
				sbuf.append(typeVO.getRoomTypeId().toString() + ",");
				
				vo.setHotelId(typeVO.getHotelId());
				
				sbuf.append(typeVO.getHotelId().toString() + ",");
				
				Calendar cal2 = Calendar.getInstance();
				cal2.set(Integer.parseInt(year), (Integer.parseInt(month) - 1), i);
				vo.setRoomDate(new Date(cal2.getTimeInMillis()));
				
				sbuf.append("'" + vo.getRoomDate().toString() + "',");
				
				vo.setRoomTypeName(typeVO.getRoomTypeName());
				
				sbuf.append("N'"+typeVO.getRoomTypeName().toString() + "',");
				
				vo.setPeopleNum(typeVO.getPeopleNum());
				
				sbuf.append(typeVO.getPeopleNum().toString() + ",");
				
				vo.setBookedNum(0);
				
				sbuf.append(vo.getBookedNum().toString() + ",");
				
				vo.setRoomNumber(typeVO.getRoomNumber());
				
				sbuf.append(typeVO.getRoomNumber().toString() + ",");
				
				int week = cal2.get(Calendar.DAY_OF_WEEK);
				if(week == 6 || week == 7 || week == 1){
					vo.setPrice(typeVO.getHolidayPrice());
					sbuf.append(typeVO.getHolidayPrice().toString() + ",");
				}else{
					vo.setPrice(typeVO.getWeekdaysPrice());
					sbuf.append(typeVO.getWeekdaysPrice().toString() + ",");
				}
				
				vo.setBreakfast(typeVO.getBreakfast());
				
				sbuf.append("'" + typeVO.getBreakfast().toString() + "',");
				
				vo.setDinner(typeVO.getDinner());
				
				sbuf.append("'" + typeVO.getDinner().toString() + "',");
				
				vo.setAfternoonTea(typeVO.getAfternoonTea());
				
				sbuf.append("'" + typeVO.getAfternoonTea() + "',");
				
				vo.setBedAddable(typeVO.getBedAddable());
				
				sbuf.append("'" + typeVO.getBedAddable().toString() + "',");
				
				vo.setPricePerPerson(typeVO.getPricePerPerson());
				
				sbuf.append(typeVO.getPricePerPerson().toString() + ",");
				
				vo.setRemark(typeVO.getRemark());
				
				sbuf.append("N'" + typeVO.getRemark().toString() + "')");
				
				listForInsert.add(vo);
				listStringBuffer.add(sbuf);
			}
		}

		RoomsService roms = new RoomsService();
		Integer count = roms.insertRooms(listForInsert);
		System.out.println("總共新增" + count + "筆");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		for(StringBuffer sbuf : listStringBuffer){
			
			out.println(sbuf);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
