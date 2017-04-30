package com.icastle.hotelphotos.controller;

import java.io.*;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelphotos.model.*;


@WebServlet("/ShowPhoto.do")
public class ShowPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		//從資料庫取得二進制資料
		HotelPhotosService dao = new HotelPhotosService();
		HotelPhotosVO photo = dao.findByHotelIdTop1(id);		
		byte[] buffer = photo.getPhoto();
		
		//將二進制資料寫出到網頁
		InputStream is = new ByteArrayInputStream(buffer);
		String mimeType = URLConnection.guessContentTypeFromStream(is);
		System.out.println(mimeType);
		response.setContentType(mimeType);
		OutputStream os = response.getOutputStream();
		os.write(buffer);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
