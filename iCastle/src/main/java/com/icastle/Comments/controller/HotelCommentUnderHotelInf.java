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
		
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		CommentService comtService = new CommentService();
		List<CommentVO> comtList = comtService.hotelComtSearch(hotelId);
		MembersService memberService = new MembersService();
		MembersVO membersVO = new MembersVO();
		CommentPhotosService comtPhotoService = new CommentPhotosService();
		CommentPhotosVO comtPhotoVO = new CommentPhotosVO();
		List<Integer> ids = new ArrayList<Integer>();
		NameEmailTime NET;
		
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
			ids = comtPhotoService.findByIds(comt.getCommentId());
//			NET.set
			
		}
		
		
		
		
		
		
		
		request.setAttribute("commentList",comtList);
		RequestDispatcher rd = request.getRequestDispatcher("Test2.jsp");
		rd.forward(request, response);
		
		
		
               
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
