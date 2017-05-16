package com.icastle.Comments.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.Comments.model.CommentService;
import com.icastle.Comments.model.CommentVO;
import com.icastle.Comments.model.NameEmailTime;
import com.icastle.hotels.model.HotelVO;
import com.icastle.members.model.MembersService;
import com.icastle.members.model.MembersVO;

/**
 * Servlet implementation class HostComment
 */
@WebServlet("/hotelcenter/HostComment")
public class HostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    Integer page = 0;		    
		    
		    if(request.getAttribute("servletPath")==null){
		    	
		    	 page= Integer.parseInt(request.getParameter("page"));	
//		    	 System.out.println("查詢字串後的page");
		    	
		    }else{
		    	
		    	 page = (Integer)request.getAttribute("page");
//		    	 System.out.println("response.java的page屬性字串");
		    }
		    
		    
		    HttpSession session = request.getSession();
	        HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
	        
	        int hotelId = hotelvo.getHotelId();
			CommentService comtService = new CommentService(); 			
			List<CommentVO> comtList= comtService.hotelComtSearch(hotelId);
			MembersService memService = new MembersService();
			MembersVO memberVO = new MembersVO();	
			List<NameEmailTime> NETList = new ArrayList<NameEmailTime>();
			NameEmailTime NET=null;
			CommentVO comtVO = new CommentVO();
			
			String servletPath = request.getServletPath();
//			System.out.println(servletPath);

			List<CommentVO> comtListRemoveResponse= new ArrayList<CommentVO>();
			
			
//			System.out.println("還未刪掉已回覆的評論長度"+comtList.size());
			//過濾集合裡已經回覆的評論
			for(int index = 0; index < comtList.size(); index++){
				CommentVO comtVO2 = new CommentVO();
				comtVO2 = comtList.get(index);
	
				
				if(comtVO2.getResponse()==null){
					
//					將未回覆的評論塞到另一個ArrayList集合裡
					comtListRemoveResponse.add(comtVO2);
					
					System.out.println("comtVO2 : "+comtVO2.getCommentId());
					

//					System.out.println("去掉已經回覆的comment集合長度:"+comtListRemoveResponse.size());
//					System.out.println("comtVO2的response內容"+comtVO2.getResponse());
								
				}
							
				
			}
			
			//取得已經去掉已經回覆的list長度
			int total = comtListRemoveResponse.size();
			System.out.println("取得已經去掉已經回覆的list長度"+total);
			
			//全部的Comment數量減掉按到最後一頁的前一頁為止的Comment數量
			int z = 0;
			if(page==1){
				if(total>=5){
					z = 5;					
				}else{
					z = total;
				}

			}else{
				 z = total-(page-1)*5;  
			}
			
			
			//當頁，Comment集合的起始索引位置
			int firstData = page*5-5;
			
			//當頁，Comment集合的結束索引位置
			int FinalData = page*5;
			
            
			if(z >= 5) {
				
				for(int i1 = firstData; i1<FinalData; i1++){
				
					
					NET = new NameEmailTime();
//					System.out.println(i1);
					comtVO =  comtListRemoveResponse.get(i1);
					memberVO = memService.findByPrimaryKey(comtVO.getEmail());
					NET.setName(memberVO.getName());
					NET.setEmail(comtVO.getEmail());
					NET.setCommentId(comtVO.getCommentId());
					NET.setCommentTime(comtVO.getCommentTime());
					NET.setResponse(comtVO.getResponse());
	

					
					NETList.add(NET);					
					

								
				}
						    
				
			}else{
				
				int b = (firstData + z);
				for(int i1 = firstData; i1<b; i1++){

//					System.out.println("(firstData + z)" + (firstData + z));

					
					NET = new NameEmailTime();
					
					comtVO = comtListRemoveResponse.get(i1);
					memberVO = memService.findByPrimaryKey(comtVO.getEmail());
					NET.setName(memberVO.getName());
					NET.setEmail(comtVO.getEmail());
					NET.setCommentId(comtVO.getCommentId());
					NET.setCommentTime(comtVO.getCommentTime());
					NET.setResponse(comtVO.getResponse());				
//					System.out.println(i);
					NETList.add(NET);					

								
				}
				
				
			}
			
//			for(int i1 = firstData; i1<FinalData; i1++){
//				
//				NET = new NameEmailTime();
//				System.out.println(i1);
//				comtVO = comtList.get(i1);
//				memberVO = memService.findByPrimaryKey(comtVO.getEmail());
//				NET.setName(memberVO.getName());
//				NET.setEmail(comtVO.getEmail());
//				NET.setCommentId(comtVO.getCommentId());
//				NET.setCommentTime(comtVO.getCommentTime());
//				NET.setResponse(comtVO.getResponse());
//				NET.setId(i);
//				NETList.add(NET);					
//				i++;
//							
//			}
//					    
//			for(CommentVO c :comtList){
//
//					
//					NET = new NameEmailTime();
//					
//					memberVO = memService.findByPrimaryKey(c.getEmail());
//					NET.setName(memberVO.getName());
//					NET.setEmail(c.getEmail());
//					NET.setCommentId(c.getCommentId());
//					NET.setCommentTime(c.getCommentTime());
//					NET.setResponse(c.getResponse());
//					NET.setId(i);
//					NETList.add(NET);					
//					i++;
//					
//								
//			
//
//			}
			
            request.setAttribute("page",page);
			request.setAttribute("commentData",NETList);
			request.setAttribute("DataNumbers",comtListRemoveResponse.size());
			


			RequestDispatcher rd = request.getRequestDispatcher("HotelCommentManager.jsp");
			rd.forward(request, response);
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
