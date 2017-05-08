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



@WebServlet("/MemberInformationCentre.do")
public class MemberInformationCentre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersService membersService = new MembersService();
		MembersVO membersvo =membersService.findByPrimaryKey("Sally@gmail.com");
		HttpSession session = request.getSession();
		session.setAttribute("membersKey", membersvo);
		
/*動態寫法 先暫時註解
 		HttpSession session = request.getSession();
		
		//拿到LoginOK物件
		MembersVO membervo = (MembersVO)session.getAttribute("LoginOK");
		
		if (membervo == null)
			System.out.println("尚未登入");
		
		MembersService membersService = new MembersService();
//		MembersVO membersvo =membersService.findByPrimaryKey(membersvo.getEmail());
		session.setAttribute("membersKey", membervo);
 */		
	//----------------顯示訂單歷史資料------------------
		OrdersService ordersService = new OrdersService();
		List<OrdersVO> list = ordersService.search_By_MemberId(1);//membersvo.getmemberId()
		request.setAttribute("ordersKey", list);
	
		RequestDispatcher rd = request.getRequestDispatcher("members/MemberCentre.jsp");
		rd.forward(request, response);
		

			
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //編碼
		
		HttpSession session = request.getSession();
		MembersVO vo = (MembersVO)session.getAttribute("membersKey");
		
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
		System.out.println(gender);
		Date dt = null;
		
		//將bdate轉型態
		try {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
			long dtlong = sdf.parse(bdate).getTime();
			dt = new Date(dtlong);
			
			/*相同於上面寫法*/
//			java.util.Date log =sdf.parse(bdate);
//			long ss= log.getTime();
//			Date sqldate = new Date(dtlong);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MembersService membersService = new MembersService();
		membersService.update(email, pw, name, gender, dt, addr, tel, personId, country, passport, vo.getMemberId());
	}

}
