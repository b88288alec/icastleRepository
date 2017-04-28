package com.icastle.Comments.main;

import java.util.List;

import com.icastle.Comments.model.CommentDAO;
import com.icastle.Comments.model.CommentVO;

public class Comment_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommentDAO comm = new CommentDAO();
		CommentVO comt = new CommentVO();
		
		
		
//		comt.setOrderId(1);
//		comt.setHotelId(1);
//		comt.setServiceScore(5);
//		comt.setQualityScore(1);
//		comt.setSceneScore(5);
//		comt.setComment("飯店還可以，品質再加油");	
//		comt = comm.comtIns(comt);
//		System.out.println(comt.getAvgScore());
//		System.out.println(comt.getServiceScore());
//		System.out.println(comt.getQualityScore());
//		System.out.println(comt.getSceneScore());
//		System.out.println(comt.getComment());
//		
//		comt.setOrderId(2);
//		comt.setHotelId(1);
//		comt.setServiceScore(4);
//		comt.setQualityScore(1);
//		comt.setSceneScore(3);
//		comt.setComment("飯店很有事");	
//		comt = comm.comtIns(comt);
//		System.out.println(comt.getAvgScore());
//		System.out.println(comt.getServiceScore());
//		System.out.println(comt.getQualityScore());
//		System.out.println(comt.getSceneScore());
//		System.out.println(comt.getComment());
//		
//		comt.setOrderId(3);
//		comt.setHotelId(1);
//		comt.setServiceScore(1);
//		comt.setQualityScore(1);
//		comt.setSceneScore(3);
//		comt.setComment("飯店沒倒閉很厲害");	
//		comt = comm.comtIns(comt);
//		System.out.println(comt.getAvgScore());
//		System.out.println(comt.getServiceScore());
//		System.out.println(comt.getQualityScore());
//		System.out.println(comt.getSceneScore());
//		System.out.println(comt.getComment());
//		
//		comt.setOrderId(4);
//		comt.setHotelId(2);
//		comt.setServiceScore(1);
//		comt.setQualityScore(1);
//		comt.setSceneScore(1);
//		comt.setComment("痾...飯店不予置評");	
//		comt = comm.comtIns(comt);
//		System.out.println(comt.getAvgScore());
//		System.out.println(comt.getServiceScore());
//		System.out.println(comt.getQualityScore());
//		System.out.println(comt.getSceneScore());
//		System.out.println(comt.getComment());
//		
//		comt.setOrderId(5);
//		comt.setHotelId(2);
//		comt.setServiceScore(5);
//		comt.setQualityScore(5);
//		comt.setSceneScore(5);
//		comt.setComment("不愧是五星級");	
//		comt = comm.comtIns(comt);
//		System.out.println(comt.getAvgScore());
//		System.out.println(comt.getServiceScore());
//		System.out.println(comt.getQualityScore());
//		System.out.println(comt.getSceneScore());
//		System.out.println(comt.getComment());
		
//		List<CommentVO> listCom =comm.hotelComtSearch(1);
//		for(int i=0;i<listCom.size();i++){
//			CommentVO c = (CommentVO)(listCom.get(i));
//			System.out.println("訂單編號 : "+c.getOrderId());
//			System.out.println("飯店編號 : "+c.getHotelId());
//			System.out.println("平均評分 : "+c.getAvgScore());
//			System.out.println("品質評分 : "+c.getQualityScore());
//			System.out.println("風景評分 : "+c.getSceneScore());
//			System.out.println("服務評分 : "+c.getServiceScore());
//			System.out.println("按讚人數 : "+c.getGood());
//			System.out.println("會員評論 : "+c.getComment());
//			System.out.println("----------------------------------");
//		}
//		
        comm.response(23,"感謝您的回覆");
		System.out.println("業者回覆:");
		System.out.println(comt.getResponse());
		
		
		
		
		
		

		

		

	}

}
