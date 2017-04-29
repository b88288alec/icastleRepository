package com.icastle.Comments.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentVO;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String orderId = request.getParameter("orderId");
		String hotelId = request.getParameter("hotelId");
		String service = request.getParameter("service");
		String quality = request.getParameter("quality");
		String scene = request.getParameter("scene");
		String comment = request.getParameter("comment");
		int orderIdInt = Integer.parseInt(orderId);
		int hotelIdInt = Integer.parseInt(hotelId);
		int serviceInt = Integer.parseInt(service);
		int qualityInt = Integer.parseInt(quality);
		int sceneInt = Integer.parseInt(scene);
		
		
		CommentDAO com = new CommentDAO();
		CommentVO comt = new CommentVO();
		comt.setOrderId(orderIdInt);
		comt.setHotelId(hotelIdInt);
		comt.setServiceScore(serviceInt);
		comt.setSceneScore(sceneInt);
		comt.setQualityScore(qualityInt);
		comt.setComment(comment);
		CommentVO comm =com.comtIns(comt);
		request.setAttribute("comment", comm);
		RequestDispatcher rd = request.getRequestDispatcher("HotelComment.jsp");
		rd.forward(request,response);

	
	}

}
