package com.icastle.commentphotos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.commentphotos.model.CommentPhotosService;
import com.icastle.commentphotos.model.CommentPhotosVO;

/**
 * Servlet implementation class CommentPhotosServlet
 */
@WebServlet("/comment/CommentPhotosServlet")
public class CommentPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentPhotosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		int idInt = Integer.parseInt(id);
	
		CommentPhotosService comtPhotoService = new CommentPhotosService();
	    CommentPhotosVO photo;
	    
	    photo = comtPhotoService.findById(idInt);
		byte[] photoByte = photo.getPhoto();
		ServletOutputStream sops =response.getOutputStream();
		sops.write(photoByte);
		
//		request.setAttribute("ShowPhoto",id);
		


	
//		RequestDispatcher rd = request.getRequestDispatcher("HotelComment.jsp");
//		rd.forward(request,response);
//		PrintWriter out = response.getWriter();
//		out.print();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
