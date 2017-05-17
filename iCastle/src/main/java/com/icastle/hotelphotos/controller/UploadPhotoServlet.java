package com.icastle.hotelphotos.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.*;

import com.icastle.hotelphotos.model.*;
import com.icastle.hotels.model.HotelVO;

@WebServlet("/hotelcenter/UploadPhoto.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HotelVO hotelvo = (HotelVO)session.getAttribute("HotelLoginOK");
		List<HotelPhotosVO> photovos = (List<HotelPhotosVO>)session.getAttribute("photovos");
		List<Integer> deleteList = new ArrayList<Integer>();
		int originpage = (Integer)session.getAttribute("originpage");
		request.setCharacterEncoding("UTF-8");
		
		String type = "";
		long size = 0; 
		InputStream is = null;
		Map<Integer, HotelPhotosVO> insertMap = new HashMap<Integer, HotelPhotosVO>();
		
		try {
			Collection<Part> parts = request.getParts();
			System.out.println("parts.size= "+parts.size());
			if (parts != null) {   // 如果這是一個上傳資料的表單
				int count = 0;
				HotelPhotosVO photovo = null;
				boolean isfile = false;
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName); 
					
					if (p.getContentType() == null) {
					//contentType!=null為字串
						System.out.println("fldName= "+ fldName);
						value = value.trim();
						
						if (fldName.equalsIgnoreCase("delete") || type.equals("delete")){
						//delete
							type="delete";
							if (fldName.startsWith("imgdescription")){
								int index = Integer.parseInt(fldName.substring(14));
								photovo = photovos.get(index-1);
								deleteList.add(photovo.getId());
								type="";
							}
						
						} else if (fldName.equalsIgnoreCase("update") || type.equals("update")){
						//update	
							type = "update";
							if (fldName.startsWith("imgdescription")){
							//update的imgdescription
								int index = Integer.parseInt(fldName.substring(14));
								photovo = photovos.get(index-1);
								photovo.setPohtoDescription(value); 
								photovo.setPhotoOrder(++count);
							} else if (fldName.startsWith("imgroomTypeId")) {
							//update的imgroomTypeId
								System.out.println("value = " + value);
								Integer roomTypeId = (value.equals("無")) ? null : Integer.parseInt(value) ;
								photovo.setRoomTypeId(roomTypeId);
								type="";
							}
							
						} else if (fldName.equalsIgnoreCase("insert") || type.equals("insert")){
							type = "insert";
							if (fldName.startsWith("imgdescription")){
							//insert的imgdescription
								photovo = new HotelPhotosVO();
								photovo.setHotelId(hotelvo.getHotelId());	//hotevo.getHotelId()
								photovo.setPohtoDescription(value);
								photovo.setPhotoOrder(++count);
							} else if (fldName.startsWith("imgroomTypeId")) {
							//insert的imgroomTypeId
								Integer roomTypeId = (value.equals("無")) ? null : Integer.parseInt(value) ;
								photovo.setRoomTypeId(roomTypeId);
								int index = Integer.parseInt(fldName.substring(13));
								insertMap.put(index, photovo);
								type="";
							}
						} 						
					}else{
					//contentType!=null為圖片
						if (!isfile){
						//set count=originpage when starting to read image
							count = originpage;
							isfile = true;
						}
						size = p.getSize();
						is = p.getInputStream();
						System.out.println("圖片size= " + size);
						if (size > 0){
							byte[] bytes = new byte[(int)size];
							is.read(bytes);
							photovo = insertMap.get(++count);
							System.out.println("count = " + count);
							photovo.setPhoto(bytes);
						}
					}
				}//for (Part p : parts)結束
			} else {
				//part==null 空的
				System.out.println("part=null"); 
			}
			
			//將圖片從map轉移到list
			Set<Integer> keys = insertMap.keySet();
			List<HotelPhotosVO> insertphotovos = new ArrayList<HotelPhotosVO>();
			for (Integer key : keys){
				insertphotovos.add( insertMap.get(key) );
			} 
			
			//呼叫model修改圖片
			HotelPhotosService photoServ = new HotelPhotosService();
			photoServ.updatePhoto(photovos);
			
			//呼叫model刪除圖片
			photoServ.deletePhoto(deleteList);
			
			//呼叫model新增圖片
			photoServ.addPhoto(insertphotovos);
			
//			HotelPhotosVO photovo = new HotelPhotosVO();
//			photovo.setHotelId(3);
//			photovo.setPhotoOrder(2);
//			photovo.setPhoto(bytes);
//			photovo.setRoomTypeId(null);
//			photovo.setPohtoDescription("飯店的一樓入口圖");
//			List<HotelPhotosVO> photos = new ArrayList<HotelPhotosVO>();
//			photos.add(photovo);
			
			//刪除不會再用到的session物件
			session.removeAttribute("photovos");
			session.removeAttribute("originpage");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowHotelPhoto.do");
			rd.forward(request, response);
			return;
			
		} catch (Exception e){
			e.printStackTrace();
		}//try catch結束
		
		
		
		
//		long size = 0;
//		InputStream is = null;
//		byte[] bytes = null;
//		String img1 = request.getParameter("img1");
//		System.out.println(img1);
//		bytes = Base64.decodeBase64(img1);
//		
//		HotelPhotosService photoServ = new HotelPhotosService();
//		HotelPhotosVO photovo = new HotelPhotosVO();
//		photovo.setHotelId(3);
//		photovo.setPhotoOrder(2);
//		photovo.setPhoto(bytes);
//		photovo.setRoomTypeId(null);
//		photovo.setPohtoDescription("飯店的一樓入口圖");
//		List<HotelPhotosVO> photos = new ArrayList<HotelPhotosVO>();
//		photos.add(photovo);
//		photoServ.addPhoto(photos);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
