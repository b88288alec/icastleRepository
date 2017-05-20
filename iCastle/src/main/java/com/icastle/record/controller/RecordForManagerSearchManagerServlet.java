package com.icastle.record.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

@WebServlet("/manager/RecordForManagerSearchManagerServlet")
public class RecordForManagerSearchManagerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setHeader("content-type", "application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		
		try{
			String name = req.getParameter("email");
			String regex = "^[0-9]*$";
			List<RecordVO> result = null;
			
			RecordService rs = new RecordService();
			if(name.matches(regex) && name != ""){
				result = rs.search_manager_records_by_id(name);
			}else{
				result = rs.search_records_by_name(name);
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			
			JSONArray ja = new JSONArray();
			for(RecordVO record : result){
				JSONObject jo = new JSONObject();
				jo.put("id", record.getId());
				jo.put("name", record.getName());
				String time = sdf.format(record.getRecordTime());
				jo.put("recordTime", time);
				jo.put("managerRecord", record.getManagerRecord());
				
				ja.add(jo);
			}
			
			out.println(ja);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
