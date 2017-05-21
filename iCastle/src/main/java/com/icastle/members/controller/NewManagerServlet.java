package com.icastle.members.controller;

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

import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;
import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

@WebServlet("/manager/NewManagerServlet")
public class NewManagerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
    	MembersVO managerData = (MembersVO)session.getAttribute("ManagerLoginOK");
		
		try{
			JSONObject jo = new JSONObject();
			Integer memberId = new Integer(req.getParameter("memberId").substring(3));
			Boolean manager = Boolean.valueOf(req.getParameter("manager"));
			String membername = req.getParameter("membername");
			String action = req.getParameter("action");
			
			MembersService ms = new MembersService();
			ms.setManager(memberId, manager);
			
//			存入歷史紀錄
			if(manager){
				String content = managerData.getName() + " 把會員 " + membername + " 升格為管理員";
				RecordVO record = new RecordVO();
		    	record.setId(("m" + managerData.getMemberId()));
		    	record.setName(managerData.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("會員相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
			}else{
				String content = managerData.getName() + " 把管理員 " + membername + " 取消管理員權限";
				RecordVO record = new RecordVO();
		    	record.setId(("m" + managerData.getMemberId()));
		    	record.setName(managerData.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("會員相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
			}
			
			if("forManagerPage".equalsIgnoreCase(action)){
				RequestDispatcher rd = req.getRequestDispatcher("ManagerPageServlet");
				rd.forward(req, res);
				return;
			}else{

				jo.put("success", "success");
				out.println(jo);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
