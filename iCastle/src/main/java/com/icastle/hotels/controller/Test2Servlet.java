package com.icastle.hotels.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view/Test2Servlet")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test2Servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomNum = request.getParameter("roomNum");
		String bedAdding = request.getParameter("bedAdding");
		System.out.println(roomNum);
		System.out.println(bedAdding);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
