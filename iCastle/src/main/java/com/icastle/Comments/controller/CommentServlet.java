package com.icastle.Comments.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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
@WebServlet("/members/CommentServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService comtService = new CommentService();
		
		//取得session是為了拿出memberVO裡的email變數
		HttpSession session = request.getSession();
		MembersVO membersvo = (MembersVO)session.getAttribute("MemberLoginOK");
		
		//透過email帳號取得那個人的所有orderId
		List<CommentVO> comtList=comtService.findByEmail(membersvo.getEmail());
  		System.out.println("test" + comtList);
//		request.setAttribute("ordersKey", request.getAttribute("ordersKey"));
		if(comtList.size() == 0){
			//comtList裡面沒有任何CommentVO物件(orderId)時...(表示Comment table裡，這email帳號沒有訂單是下過評論的)
			request.setAttribute("nocomment", false);
		}else{
			//comtList裡面有CommentVO物件(orderId)時...(表示Comment table裡，這email帳號有訂單是已經下過評論的)
			request.setAttribute("nocomment", true);
			request.setAttribute("alreadycomment", comtList);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("../members/member_historical_order.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//取得session裡的MemberLoginOK屬性字串，目的是要取得裡面的Email
		HttpSession session = request.getSession();
		MembersVO membersvo = (MembersVO)session.getAttribute("MemberLoginOK");
		
		String orderId = request.getParameter("orderId");
		String hotelId = request.getParameter("hotelId");
		String service = request.getParameter("service");
		String quality = request.getParameter("quality");
		String scene = request.getParameter("scene");
		String comment = request.getParameter("comment");
		

		
		Collection<Part> p=request.getParts();
		
		//需要轉形成MemberVO對應的變數形態，等一下要將這些變數封裝在MemberVO物件裡
        int orderIdInt = Integer.parseInt(orderId);
        int hotelIdInt = Integer.parseInt(hotelId);
		int serviceInt = Integer.parseInt(service);
		int qualityInt = Integer.parseInt(quality);
		int sceneInt = Integer.parseInt(scene);
	
	    
		
//		Map<String,String> ErrorMessage = new HashMap<String,String>();
//		
//		
//		if(serviceInt == 0 ){
//			ErrorMessage.put("serviceKey","至少點擊一顆星");
//		}
//		
//		if(qualityInt == 0 ){
//			ErrorMessage.put("qualityKey","至少點擊一顆星");			
//		}
//		
//		if(sceneInt == 0 ){
//			ErrorMessage.put("sceneKey","至少點擊一顆星");		
//		}
//		
//		if(comment.trim().length()<10){
//			ErrorMessage.put("commentKey","文字內容至少要十個字以上");
//			ErrorMessage.put("comment",comment);
//		}
//		
//		if(ErrorMessage.size()>0){
//			request.setAttribute("error",ErrorMessage);
//			RequestDispatcher rd = request.getRequestDispatcher("");
//			rd.forward(request,response);
//			return;
//		}

		CommentService comtService = new CommentService();
		
		//取得當下時間，做為評論時間
		java.sql.Date d = comtService.getCurrentDate();
		
		//將上面從前端送來的資料封裝成名為comt的CommentVO物件
		CommentVO comt;		
		comt = new CommentVO();
		comt.setOrderId(orderIdInt);
		comt.setHotelId(hotelIdInt);	
		//session的email
		comt.setEmail(membersvo.getEmail());
		comt.setServiceScore(serviceInt);
		comt.setSceneScore(sceneInt);
		comt.setQualityScore(qualityInt);
		comt.setComment(comment);
		comt.setCommentTime(d);
		
		//將comt新增進資料庫
		comtService.comtIns(comt);	
		
		//將該筆訂單的評論從資料庫Select出來
		comt = comtService.findByOrderId(comt.getOrderId());

		CommentPhotosService comtPhotoService = new CommentPhotosService();
		
		
		
		
			 for(Part part : p){
		//會印出orderId、hotelId、service、qualityscene、scene、comment
				 System.out.println("for迴圈裡的:" + part.getName());

					
		//過濾掉非uploadphoto的part以及是uploadphoto但是長度等於0的
					if(part.getName().equals("uploadphoto")&&part.getSize()!=0){
						
						System.out.println("if裡的:" + part.getName());
						
						//目的是要取得可以放進uploadCommentPhoto的參數形態
						
					    //取得InputStream
						InputStream ips = part.getInputStream();
						
						//取得long
						long lenLong = part.getSize();
                        
						System.out.println("圖片長度"+part.getSize());
						
						//將圖片寫進資料庫
						comtPhotoService.uploadCommentPhoto(comt.getCommentId(),ips,lenLong);
										
						
					}
				
			  }
				
			
	
		

		 
			

			OrdersService ordersService = new OrdersService();
			List<OrdersVO> list = ordersService.search_history_By_MemberId(membersvo.getMemberId());
			
			for(OrdersVO order:list){
				order.getOrderId();
//				System.out.println("所有訂單"+order.getOrderId());
			}
			
//			取得當前時間來比較日期大小
			TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
			
			long commentTime = ((new java.sql.Date(new GregorianCalendar().getTimeInMillis()).getTime())-((long)24*60*60*1000*90));	
			request.setAttribute("currentTime", new java.sql.Date(new GregorianCalendar().getTimeInMillis()).getTime());
			request.setAttribute("commentTime", commentTime);
			
			request.setAttribute("ordersKey", list);
			doGet(request, response);

			
			
				
			
			
		
//		request.setAttribute("comment", comt);
//		RequestDispatcher rd = request.getRequestDispatcher("../members/MemberInformationCentre.do");
//		rd.forward(request,response);
//		return;
	}

}
