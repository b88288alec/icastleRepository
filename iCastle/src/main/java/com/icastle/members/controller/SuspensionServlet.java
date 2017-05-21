package com.icastle.members.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/manager/SuspensionServlet")
public class SuspensionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
    	MembersVO manager = (MembersVO)session.getAttribute("ManagerLoginOK");
		
		try{
			JSONObject jo = new JSONObject();
			Integer memberId = new Integer(req.getParameter("memberId").substring(3));
			Boolean suspension = Boolean.valueOf(req.getParameter("suspension"));
			String membername = req.getParameter("membername");
			
			MembersService ms = new MembersService();
			ms.suspension(memberId, suspension);
			
//			存入歷史紀錄
			if(suspension){
				String content = manager.getName() + " 把會員 " + membername + " 停權";
				RecordVO record = new RecordVO();
		    	record.setId(("m" + manager.getMemberId()));
		    	record.setName(manager.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("會員相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
			}else{
				String content = manager.getName() + " 把會員 " + membername + " 恢復使用權限";
				RecordVO record = new RecordVO();
		    	record.setId(("m" + manager.getMemberId()));
		    	record.setName(manager.getName());
		    	record.setManagerRecord(content);
		    	record.setClassification("會員相關");
		    	
		    	RecordService rs = new RecordService();
		    	rs.managerRecord(record);
			}
			
			jo.put("success", "success");
			out.println(jo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
