package com.icastle.hotelphotos.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/hotel/UploadPhoto.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long size = 0;
		InputStream is = null;
		try {
			Collection<Part> parts = request.getParts();
			System.out.println("parts.size= "+parts.size());
			if (parts != null) {   // 如果這是一個上傳資料的表單
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					System.out.println(value);
					
					if (p.getContentType() == null) {
					}else{
						//contentType!=null為圖片
						size = p.getSize();
						is = p.getInputStream();
						System.out.println("contentType!=null");
					}
					
				}//for (Part p : parts)結束
			} else {
				//part==null 空的
				System.out.println("part=null");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}//try catch結束
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
