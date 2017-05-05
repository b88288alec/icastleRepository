//package com.icastle.members.controller;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.Iterator;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageWriter;
//import javax.imageio.stream.ImageOutputStream;
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class DynamicImage
// */
//@WebServlet("/members/DynamicImage.do")
//public class DynamicImage extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DynamicImage() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        response.setContentType("image/jpeg");
//
//        BufferedImage bi = new BufferedImage(50,30,BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2d = bi.createGraphics();
//        g2d.setColor(Color.white);
//        g2d.fillRect(0, 0, 50, 30);
//        g2d.setColor(Color.black);
//        g2d.drawRect(5, 5, 40, 20);
//
//
//        StringBuilder sbl = new StringBuilder();
//        while(sbl.length() < 4){
//            sbl.append(Integer.toString((int)(Math.random() * 9)));
//        }
//
//        session.setAttribute("number", sbl.toString());
//  
//        g2d.setFont(new Font("Default",Font.BOLD,13));
//        g2d.drawString(sbl.toString(), 10, 20);
//  
//        for(int i = 0; i < 20; i++){
//            int x = (int)(Math.random() * 40) + 5;
//            int y = (int)(Math.random() * 20) + 5;
//   
//            g2d.fillOval(x, y, 1, 1);
//        }
//  
//        ServletOutputStream sos = response.getOutputStream();
//  
//        Iterator ite = ImageIO.getImageWritersByFormatName("jpeg");
//        ImageWriter iw = (ImageWriter)ite.next();
//  
//        ImageOutputStream ios = ImageIO.createImageOutputStream(sos);
//        iw.setOutput(ios);
//        iw.write(bi);
//        ios.flush();
//        sos.close();
//}
//
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
