package com.icastle.hotelphotos.controller;

import java.io.*;
import java.net.URLConnection;
import java.util.List;

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

    /*
     *	將HotelPhotos的照片讀出並秀在網頁上
     *  根據id查詢飯店                  http://localhost:8081/iCastle/ShowPhoto.do?id=4
     *  查詢某家飯店的第一張照片  http://localhost:8081/iCastle/ShowPhoto.do?id=4&type=hotelid
     *  查詢某房型第一張照片         http://localhost:8081/iCastle/ShowPhoto.do?id=4&type=roomtypeid
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		
		//從資料庫取得二進制資料
		HotelPhotosService dao = new HotelPhotosService();
		HotelPhotosVO photo = null;
		if ("hotelid".equalsIgnoreCase(type))
			photo = dao.findByHotelIdTop1(id);
		else if ("roomtypeid".equalsIgnoreCase(type)){
			List<HotelPhotosVO> photos = dao.findByRoomTypeId(id);
			if (photos.size() != 0)
				photo = dao.findByRoomTypeId(id).get(0);
			else
				photo = dao.findByPrimaryKey(5);
		} else 
			photo = dao.findByPrimaryKey(id);
		
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
