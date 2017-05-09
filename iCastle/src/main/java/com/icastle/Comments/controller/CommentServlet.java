package com.icastle.Comments.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentService;
import com.icastle.Comments.model.CommentVO;
import com.icastle.Orders.model.OrdersVO;
import com.icastle.commentphotos.model.CommentPhotosService;
import com.icastle.commentphotos.model.CommentPhotosVO;
import com.icastle.commentphotos.model.OrdersJDBCTest;
import com.icastle.hotels.model.HotelVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment/CommentServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String orderId = request.getParameter("orderId");
		String hotelId = request.getParameter("hotelId");
		String service = request.getParameter("service");
		String quality = request.getParameter("quality");
		String scene = request.getParameter("scene");
		String comment = request.getParameter("comment");
		
		Collection<Part> p=request.getParts();
//		Part photo = request.getPart("uploadphoto");
//		Part photo;
		
//		photo.containsAll(photo);
//		System.out.println(photo);

//		Collection<Part> photos=request.getParts();
		
//		int orderIdInt = Integer.parseInt(orderId);
//		int hotelIdInt = Integer.parseInt(hotelId);
		int serviceInt = Integer.parseInt(service);
		int qualityInt = Integer.parseInt(quality);
		int sceneInt = Integer.parseInt(scene);
	
		Map<String,String> ErrorMessage = new HashMap<String,String>();
		CommentVO comt;
		
		if(serviceInt == 0 ){
			ErrorMessage.put("serviceKey","至少點擊一顆星");
		}
		
		if(qualityInt == 0 ){
			ErrorMessage.put("qualityKey","至少點擊一顆星");			
		}
		
		if(sceneInt == 0 ){
			ErrorMessage.put("sceneKey","至少點擊一顆星");		
		}
		
		if(comment.trim().length()<10){
			ErrorMessage.put("commentKey","文字內容至少要十個字以上");
			ErrorMessage.put("comment",comment);
		}
		
		if(ErrorMessage.size()>0){
			request.setAttribute("error",ErrorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("Comment.jsp");
			rd.forward(request,response);
			return;
		}

		CommentService comtService = new CommentService();
		java.sql.Date d = comtService.getCurrentDate();
		
				
		comt = new CommentVO();
		comt.setOrderId(2);
		comt.setHotelId(1);
		comt.setEmail("def@gmail.com");
		comt.setServiceScore(serviceInt);
		comt.setSceneScore(sceneInt);
		comt.setQualityScore(qualityInt);
		comt.setComment(comment);
		comt.setCommentTime(d);
		comtService.comtIns(comt);	
		
		comt = comtService.findByOrderId(comt.getOrderId());

//		    List<CommentPhotosVO> comtphotos = new ArrayList<CommentPhotosVO>();
		    CommentPhotosService comtPhotoService = new CommentPhotosService();
		
			
			for(Part part : p){
//				System.out.println(part);
//				System.out.println(part.getName());
//				System.out.println(part.getHeader(part.getName()));
				
				if(part.getName().equals("uploadphoto")){
					
//					CommentPhotosVO comtphotoVO = new CommentPhotosVO();				
		
					InputStream ips = part.getInputStream();
//					Integer lenInt = new Integer(ips.available());
					long lenLong = part.getSize();
					
					comtPhotoService.uploadCommentPhoto(comt.getCommentId(),ips,lenLong);
					
					
					
				}
				

				
			}
				
			
			
		
		request.setAttribute("comment", comt);
		RequestDispatcher rd = request.getRequestDispatcher("HotelComment.jsp");
		rd.forward(request,response);
		return;
	}

}
