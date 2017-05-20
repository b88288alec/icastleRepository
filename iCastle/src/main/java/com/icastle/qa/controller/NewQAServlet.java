package com.icastle.qa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.icastle.members.model.MembersVO;
import com.icastle.qa.model.QaService;
import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

@WebServlet("/manager/NewQAServlet")
public class NewQAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		HttpSession session = req.getSession();
    	MembersVO manager = (MembersVO)session.getAttribute("ManagerLoginOK");
		
		try{
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			
			QaService qs = new QaService();
			qs.insert(question, answer);
			
			String content = manager.getName() + " 新增了一則QA";
			RecordVO record = new RecordVO();
	    	record.setId(("m" + manager.getMemberId()));
	    	record.setName(manager.getName());
	    	record.setManagerRecord(content);
	    	
	    	RecordService rs = new RecordService();
	    	rs.managerRecord(record);
			
			RequestDispatcher rd = req.getRequestDispatcher("SearchQAServlet");
			rd.forward(req, res);
			return;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
