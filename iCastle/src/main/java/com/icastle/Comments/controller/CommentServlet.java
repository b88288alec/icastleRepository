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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentService;
import com.icastle.Comments.model.CommentVO;
import com.icastle.Comments.model.OrderAndResponse;
import com.icastle.Orders.model.OrdersService;
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService comtService = new CommentService();
		HttpSession session = request.getSession();
		MembersVO membersvo = (MembersVO)session.getAttribute("MemberLoginOK");
		List<CommentVO> comtList=comtService.findByEmail(membersvo.getEmail());
		System.out.println("test" + comtList);
		request.setAttribute("ordersKey", request.getAttribute("ordersKey"));
		if(comtList.size() == 0){
			request.setAttribute("nocomment", false);
		}else{
			request.setAttribute("nocomment", true);
			request.setAttribute("alreadycomment", comtList);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("../members/member_historical_order.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MembersVO membersvo = (MembersVO)session.getAttribute("MemberLoginOK");
		
		String orderId = request.getParameter("orderId");
		String hotelId = request.getParameter("hotelId");
		String service = request.getParameter("service");
		String quality = request.getParameter("quality");
		String scene = request.getParameter("scene");
		String comment = request.getParameter("comment");

		
		Collection<Part> p=request.getParts();
        int orderIdInt = Integer.parseInt(orderId);
        int hotelIdInt = Integer.parseInt(hotelId);
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
		comt.setOrderId(orderIdInt);
		comt.setHotelId(hotelIdInt);
		comt.setEmail(membersvo.getEmail());
		comt.setServiceScore(serviceInt);
		comt.setSceneScore(sceneInt);
		comt.setQualityScore(qualityInt);
		comt.setComment(comment);
		comt.setCommentTime(d);
		comtService.comtIns(comt);	
		
		comt = comtService.findByOrderId(comt.getOrderId());

		    CommentPhotosService comtPhotoService = new CommentPhotosService();
		
			
			for(Part part : p){

				
				if(part.getName().equals("uploadphoto")){
					
					
					InputStream ips = part.getInputStream();

					long lenLong = part.getSize();
					
					comtPhotoService.uploadCommentPhoto(comt.getCommentId(),ips,lenLong);
									
					
				}
			
			}
			
//			CommentService cs = new CommentService();
			OrdersService ordersService = new OrdersService();
			List<OrdersVO> list = ordersService.search_By_MemberId(membersvo.getMemberId());
			
			for(OrdersVO order:list){
				order.getOrderId();
//				System.out.println("所有訂單"+order.getOrderId());
			}
			
			
//			CommentVO vo = new CommentVO();
//			List<OrderAndResponse> oarList = new ArrayList<OrderAndResponse>();
			
	
			
//			for(OrdersVO result:list){
//				OrderAndResponse oar = new OrderAndResponse();
//				oar.setOrderId(result.getOrderId());
//				oar.setHotelId(result.getHotelId());
//				oar.setMemberId(result.getMemberId()); 
//				oar.setRoomId(result.getRoomId());
//			    oar.setHotelId(result.getHotelId()); 
//			    oar.setRoomTypeId(result.getRoomTypeId());
//			    oar.setRoomTypeName(result.getRoomTypeName());
//				oar.setCheckinDay(result.getCheckinDay());
//				oar.setCheckoutDay(result.getCheckoutDay());
//				oar.setRoomCount(result.getRoomCount());
//				oar.setPeopleNum(result.getPeopleNum());
//				oar.setBreakfast(result.getBreakfast());
//				oar.setDinner(result.getDinner());
//				oar.setAfternoonTea(result.getAfternoonTea());
//				oar.setPrice(result.getPrice()); 
//				oar.setReservationer(result.getReservationer());
//				oar.setBdate(result.getBdate());
//				oar.setTel(result.getTel());
//				oar.setEmail(result.getEmail());
//				oar.setAddr(result.getAddr());
//				oar.setPersonId(result.getPersonId());
//				oar.setCountry(result.getCountry());
//				oar.setPassport(result.getPassport());
//				oar.setBedAdding(result.getBedAdding());
//				oar.setPricePerPerson(result.getPricePerPerson());
//				oar.setCustomerRemark(result.getCustomerRemark());
//				oar.setHotelRemark(result.getHotelRemark());
//				oar.setMemo(result.getMemo());
//				oar.setOrderState(result.getOrderState());
//				vo = comtService.findResponseByOrderId(result.getOrderId());
//				oar.setResponse(vo.getResponse());
//				oarList.add(oar);
//							
//				
//			}
			
			request.setAttribute("ordersKey", list);
			doGet(request, response);
//			RequestDispatcher rd = request.getRequestDispatcher("/members/member_historical_order.jsp");//!!!!
//			rd.forward(request, response);
			
			
				
			
			
		
//		request.setAttribute("comment", comt);
//		RequestDispatcher rd = request.getRequestDispatcher("../members/MemberInformationCentre.do");
//		rd.forward(request,response);
//		return;
	}

}
