package com.icastle.Comments.controller;

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

import com.icastle.Comments.model.CommentService;
import com.icastle.Comments.model.CommentVO;
import com.icastle.Comments.model.NameEmailTime;
import com.icastle.commentphotos.model.CommentPhotosService;
import com.icastle.commentphotos.model.CommentPhotosVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class HotelCommentUnderHotelInf
 */
@WebServlet("/comment/HotelCommentUnderHotelInf")
public class HotelCommentUnderHotelInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelCommentUnderHotelInf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer hotelId = (Integer)session.getAttribute("hotelId");
//		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		CommentService comtService = new CommentService();
		List<CommentVO> comtList = comtService.hotelComtSearch(hotelId);
		MembersService memberService = new MembersService();
		MembersVO membersVO = new MembersVO();
		CommentPhotosService comtPhotoService = new CommentPhotosService();
		CommentPhotosVO comtPhotoVO = new CommentPhotosVO();
		List<Integer> ids = new ArrayList<Integer>();
		NameEmailTime NET;
		List<NameEmailTime> NETList = new  ArrayList<NameEmailTime>();
		
		for(CommentVO comt:comtList){
			NET = new NameEmailTime();
			
			membersVO = memberService.findByPrimaryKey(comt.getEmail());
			NET.setName(membersVO.getName());
			NET.setEmail(comt.getEmail());
			NET.setAvgScore(comt.getAvgScore());
			NET.setQualityScore(comt.getQualityScore());
			NET.setSceneScore(comt.getSceneScore());
			NET.setServiceScore(comt.getServiceScore());
			NET.setQualityScore(comt.getQualityScore());
			NET.setComment(comt.getComment());
			NET.setCommentTime(comt.getCommentTime());
			NET.setResponse(comt.getResponse());
			NET.setResponseTime(comt.getResponseTime());
			NET.setCommentId(comt.getCommentId());
			ids = comtPhotoService.findByIds(comt.getCommentId());
			NET.setIds(ids);
			NETList.add(NET);
			
		}
			
		request.setAttribute("NETList",NETList);
		RequestDispatcher rd = request.getRequestDispatcher("../hotel/hotel.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
//		request.setAttribute("commentList",comtList);
//		RequestDispatcher rd = request.getRequestDispatcher("Test2.jsp");
//		rd.forward(request, response);
//		
		
		
               
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
