package com.icastle.record.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@WebServlet("/ToPDF")
public class ToPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		System.out.println(context.getRealPath("/recordPDF"));

		Document document = new Document(PageSize.A4.rotate());
		try {
			FileOutputStream fos = new FileOutputStream(new File(context.getRealPath("/recordPDF") + "\\test.pdf"));
			PdfWriter.getInstance(document, fos);
			document.open();
			BaseFont bfChinese = BaseFont.createFont("C:\\windows\\fonts\\msjh.ttc,0", BaseFont.IDENTITY_H,
					BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100f);
			table.setPaddingTop(2);
			table.setSpacingAfter(2);
			PdfPCell roomTypeName = new PdfPCell(new Phrase("雅緻雙人房（無窗）", FontChinese));
			PdfPCell peopleNum = new PdfPCell(new Phrase("2人", FontChinese));
			PdfPCell price = new PdfPCell(new Phrase("2000", FontChinese));
			PdfPCell meals = new PdfPCell(new Phrase("早餐", FontChinese));
			PdfPCell cell = new PdfPCell(new Phrase("2017-05-24 14:54", FontChinese));
//			table.addCell(roomTypeName);
//			table.addCell(peopleNum);
			table.addCell(price);
//			table.addCell(meals);
			table.addCell(cell);
			document.add(new Phrase("Hello world\n"));
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
		InputStream is = new FileInputStream(context.getRealPath("/recordPDF") + "\\test.pdf");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[512];
		int length = 0;
		while ((length = is.read(buf)) != -1) {
			baos.write(buf, 0, length);
		}
		byte[] data = baos.toByteArray();
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		out.write(data);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
