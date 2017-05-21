package com.icastle.record.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@WebServlet("/ToPDF")
public class ToPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		System.out.println(context.getRealPath("/recordPDF"));
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(context.getRealPath("/recordPDF") + "\\test.pdf"));
			document.open();
			document.add(new Paragraph("Hello World"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
		InputStream is = new FileInputStream(context.getRealPath("/recordPDF") + "\\test.pdf");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[512];
		int length = 0;
		while((length = is.read(buf)) != -1){
			baos.write(buf, 0, length);
		}
		byte[] data = baos.toByteArray();
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		out.write(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
