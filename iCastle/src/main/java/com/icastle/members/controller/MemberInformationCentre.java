package com.icastle.members.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.Orders.model.OrdersService;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;



@WebServlet("/members/MemberInformationCentre.do")
public class MemberInformationCentre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();	//使用HttpSession介面，取得物件
		/*取出MembersLoginServlet的登入後物件*/
		
		//拿到LoginOK物件
		MembersVO membersvo = (MembersVO)session.getAttribute("MemberLoginOK");
		System.out.println("MemberInformationCentre.do");
		System.out.println("會員編號:"+membersvo.getMemberId());
 	
	//----------------顯示訂單歷史資料------------------
		OrdersService ordersService = new OrdersService();
		List<OrdersVO> list = ordersService.search_By_MemberId(membersvo.getMemberId());
		request.setAttribute("ordersKey", list);
		
	/*下方是測試在java程式上有無撈出資料*/
//		for (OrdersVO result : list) {
//			System.out.println(result.getHotelId() + " " + result.getMemberId() + " " + result.getRoomId() + " "
//					+ result.getHotelId() + " " + result.getRoomTypeId() + " " + result.getRoomTypeName() + " "
//					+ result.getCheckinDay() + " " + result.getCheckoutDay() + " " + result.getRoomCount() + " "
//					+ result.getPeopleNum() + " " + result.getBreakfast() + " " + result.getDinner() + " "
//					+ result.getAfternoonTea() + " " + result.getPrice() + " " + result.getReservationer() + " "
//					+ result.getBdate() + " " + result.getTel() + " " + result.getEmail() + " " + result.getAddr() + " "
//					+ result.getPersonId() + " " + result.getCountry() + " " + result.getPassport() + " "
//					+ result.getBedAdding() + " " + result.getPricePerPerson() + " " + result.getCustomerRemark() + " "
//					+ result.getHotelRemark() + " " + result.getMemo() + " " + result.getOrderState());
//			System.out.println("---------------------------------------------");
//		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/members/member_historical_order.jsp");//!!!!
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //編碼
		
		HttpSession session = request.getSession();
		MembersVO vo = (MembersVO)session.getAttribute("MemberLoginOK");
		
		String name = request.getParameter("nameId");
		String gender = request.getParameter("gender");
		String bdate = request.getParameter("bdateId");
		String tel = request.getParameter("telId");
		String personId = request.getParameter("personId");
		String passport = request.getParameter("passportId");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String country = request.getParameter("country");
		String addr = request.getParameter("addr");
		String memberid = request.getParameter("member_Id");
		int memberIdInt = Integer.parseInt(memberid);
		System.out.println(gender);
		Date dt = null;
		
		
		
		
		//將bdate轉型態
		try {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			long dtlong = sdf.parse(bdate).getTime();
			dt = new Date(dtlong);
			System.out.println(dt);
			
			/*相同於上面寫法*/
//			java.util.Date log =sdf.parse(bdate);
//			long ss= log.getTime();
//			Date sqldate = new Date(dtlong);
			
			
			MembersService membersService = new MembersService();
//			更新資料庫資料
			membersService.update(email, pw, name, gender, dt, addr, tel, personId, country, passport, memberIdInt);
			
//			把更新後的資料從資料庫取出
			MembersVO result = membersService.findByPrimaryKey(email);
			
//			把更新後的資料存入session備用
			session.setAttribute("MemberLoginOK", result);
			
			/*update資料重新載入頁面*/
//			傳回前端
			RequestDispatcher rd = request.getRequestDispatcher("member_profile.jsp");
			rd.forward(request, response);
			return;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
