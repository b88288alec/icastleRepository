package com.icastle.members.controller;

import java.io.IOException;
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

@WebServlet("/members/MemberForSearchNewOrdersServlet")
public class MemberForSearchNewOrdersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		try{
			MembersVO member = (MembersVO)session.getAttribute("MemberLoginOK");
			OrdersService os = new OrdersService();
			List<OrdersVO> orders = os.search_new_orders_by_memberId(member.getMemberId());
			
			req.setAttribute("orders", orders);
			RequestDispatcher rd = req.getRequestDispatcher("member_orders.jsp");
			rd.forward(req, res);
			return;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
