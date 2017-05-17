package com.icastle.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.qa.model.QaService;
import com.icastle.qa.model.QaVO;

@WebServlet("/manager/DeleteQAServlet")
public class DeleteQAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		
		try{
			QaService qs = new QaService();
			
			String del[] = req.getParameterValues("del");
			for(String id : del){
				qs.delete(new Integer(id));
			}
			
			List<QaVO> QA = qs.getAll();
			req.setAttribute("QA", QA);
			
			RequestDispatcher rd = req.getRequestDispatcher("QA.jsp");
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
