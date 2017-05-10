package com.icastle.Comments.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.icastle.Comments.model.CommentService;
import com.icastle.Comments.model.CommentVO;
import com.icastle.commentphotos.model.CommentPhotosService;

/**
 * Servlet implementation class CommentCheck
 */
@WebServlet("/comment/CommentCheck")
public class CommentCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int value = Integer.parseInt(request.getParameter("ButtonCheck"));
		
		CommentVO comtVO = new CommentVO();
		CommentService comtService = new CommentService();
		CommentPhotosService comtPhotosService = new CommentPhotosService();
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<Integer> listId = new ArrayList<Integer>();
			
		comtVO =comtService.findByCommentId(value);
		listId = comtPhotosService.findByIds(value);
		
				
		map.put("orderId",comtVO.getOrderId().toString());
		map.put("email",comtVO.getEmail().toString());
		map.put("avgScore",comtVO.getAvgScore().toString());
		map.put("serviceScore",comtVO.getServiceScore().toString());
		map.put("qualityScore",comtVO.getQualityScore().toString());
		map.put("sceneScore",comtVO.getSceneScore().toString());
		map.put("comment",comtVO.getComment().toString());
		map.put("commentTime",comtVO.getCommentTime().toString());
        map.put("ids",listId);
        
        
		
		JSONObject ObjectToJSON = new JSONObject(map);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(ObjectToJSON);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
		
		
		

			
			
		
		
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
