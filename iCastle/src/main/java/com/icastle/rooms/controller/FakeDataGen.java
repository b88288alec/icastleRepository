package com.icastle.rooms.controller;

import java.io.IOException;
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

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), (Integer.parseInt(month) - 1), 1);

		for (RoomTypeVO typeVO : list) {
			for (int i = 1; i <= cal.getActualMaximum(cal.DATE); i++) {
				RoomsVO vo = new RoomsVO();
				vo.setRoomTypeId(typeVO.getRoomTypeId());
				vo.setHotelId(typeVO.getHotelId());
				Calendar cal2 = Calendar.getInstance();
				cal2.set(Integer.parseInt(year), (Integer.parseInt(month) - 1), i);
				vo.setRoomDate(new Date(cal2.getTimeInMillis()));
				vo.setRoomTypeName(typeVO.getRoomTypeName());
				vo.setPeopleNum(typeVO.getPeopleNum());
				vo.setBookedNum(0);
				vo.setRoomNumber(typeVO.getRoomNumber());
				vo.setPrice(typeVO.getWeekdaysPrice());
				vo.setBreakfast(typeVO.getBreakfast());
				vo.setDinner(typeVO.getDinner());
				vo.setBedAddable(typeVO.getBedAddable());
				vo.setPricePerPerson(typeVO.getPricePerPerson());
				vo.setRemark(typeVO.getRemark());
				listForInsert.add(vo);
			}
		}

		RoomsService roms = new RoomsService();
		Integer count = roms.insertRooms(listForInsert);
		System.out.println("總共新增" + count + "筆");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
