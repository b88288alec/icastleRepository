package com.icastle.record.controller;

import java.awt.Color;
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

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
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
			Table table = new Table(3);
			table.setBorderWidth(1);
			table.setBorderColor(new Color(0, 0, 255));
//			table.setPadding(5);
//			table.setSpacing(5);
			Cell cell = new Cell("header");
			cell.setHeader(true);
			cell.setColspan(3);
			table.addCell(cell);
			table.endHeaders();
			cell = new Cell("example cell with colspan 1 and rowspan 2");
			cell.setRowspan(2);
			cell.setBorderColor(new Color(255, 0, 0));
			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("cell test1");
			cell = new Cell("big cell");
			cell.setRowspan(2);
			cell.setColspan(2);
			table.addCell(cell);
			table.addCell("cell test2");
			document.add(new Paragraph("Hello World"));
			document.add(table);
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
