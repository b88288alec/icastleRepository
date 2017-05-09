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
import com.icastle.hotels.model.HotelVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class HostComment
 */
@WebServlet("/comment/HostComment")
public class HostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			CommentService comtService = new CommentService(); 			
			List<CommentVO> comtList= comtService.hotelComtSearch(1);
			MembersService memService = new MembersService();
			MembersVO memberVO = new MembersVO();	
			List<NameEmailTime> NETList = new ArrayList<NameEmailTime>();
			NameEmailTime NET=null;
			int i = 1;
					    
			for(CommentVO c :comtList){	
				NET = new NameEmailTime();
								
				memberVO = memService.findByPrimaryKey(c.getEmail());
				NET.setName(memberVO.getName());
				NET.setEmail(c.getEmail());
				NET.setCommentId(c.getCommentId());
				NET.setCommentTime(c.getCommentTime());
				NET.setId(i);
				NETList.add(NET);
				i++;

			}

				
			request.setAttribute("commentData",NETList);			
			RequestDispatcher rd = request.getRequestDispatcher("HotelCommentList.jsp");
			rd.forward(request, response);
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
