package com.icastle.Comments.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.Comments.model.CommentService;

/**
 * Servlet implementation class Response
 */
@WebServlet("/comment/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int commentId = Integer.parseInt(request.getParameter("hiddeninput"));
		String hostResponse = request.getParameter("textareavalue");
		
//		System.out.println(commentId);
//		System.out.println(hostResponse);
		
	    Map<String,String> ErrorMessage = new HashMap<String,String>();
		
		if(hostResponse.isEmpty()!=true ){
						
			ErrorMessage.put("NoEmpty","請輸入文字");						
		}
		
		
		CommentService  comtService = new CommentService();
		java.sql.Date d = comtService.getCurrentDate();
		comtService.response(commentId,d,hostResponse);
		
		request.setAttribute("error",ErrorMessage);
        RequestDispatcher rd = request.getRequestDispatcher("HostComment");
        rd.forward(request, response);
		

	}

}
