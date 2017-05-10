package com.icastle.hotelInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelInfo.modle.InfoJDBCDAO;
import com.icastle.hotelInfo.modle.InfoService;
import com.icastle.hotelInfo.modle.InfoVO;


@WebServlet("/HotelInfoJNDITest")
public class HotelInfoJNDITest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HotelInfoJNDITest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ------------飯店頁面時查詢--------------- */
//		InfoJDBCDAO dao = new InfoJDBCDAO();
//
//		InfoVO infoVO = dao.findByHotelId(1);
//
//		System.out.println(infoVO.getRegisterName());
//		System.out.println(infoVO.getTel());
//		System.out.println(infoVO.getTransport());
//		System.out.println(infoVO.getWebsite());
//		System.out.println(infoVO.getHotelProfile());
//		System.out.println(infoVO.getCheckin());
//		System.out.println(infoVO.getCheckout());
//		System.out.println(infoVO.getGuestPolicies());
//		System.out.println(infoVO.getCancelPolicies());
//		System.out.println(infoVO.isRoomWifi());
//		System.out.println(infoVO.isHallWifi());
//		System.out.println(infoVO.isInternet());
//		System.out.println(infoVO.isMineralWater());
//		System.out.println(infoVO.isToiletUtensils());
//		System.out.println(infoVO.isHairDryer());
//		System.out.println(infoVO.isTv());
//		System.out.println(infoVO.isGameRoom());
//		System.out.println(infoVO.isGym());
//		System.out.println(infoVO.isSpa());
//		System.out.println(infoVO.isSwimPool());

/* ------------飯店註冊--------------- */
//		 InfoJDBCDAO dao =new InfoJDBCDAO();
//		 InfoVO infoVO = new InfoVO();
//		
//		 infoVO.setHotelId(1);
//		 infoVO.setRegisterName("噴火龍");
//		 infoVO.setTel("+886-7-6568158");
//		 infoVO.setTransport("火龍果單程約15.5公里；行駛時間尖峰約35分鐘，離峰約25分鐘。(單程票價$34)");//交通資訊
//		 infoVO.setWebsite("http://www.edaroyal.com.tw/dispPageBox/CPNHP.aspx?ddsPageID=EDACHHP");
//		 infoVO.setHotelProfile("環抱觀音山綿延綠意明媚風光，是全台唯一結合休閒度假飯店、大型購物商場、"
//		 + "主題遊樂園和藝術生態於一體的多元化渡假休閒勝地。");
//		 infoVO.setCheckin("08:00");
//		 infoVO.setCheckout("12:00");
//		 infoVO.setGuestPolicies("入住須知需前一晚預定，當日預定需下午兩點前");//入住須知
//		 infoVO.setCancelPolicies("取消規定需指定入住前三小時以電話來電取消");//取消規定
//		 infoVO.setRoomWifi(true);
//		 infoVO.setHairDryer(true);
//		 infoVO.setInternet(true);
//		 infoVO.setMineralWater(true);
//		 infoVO.setToiletUtensils(true);
//		 infoVO.setHairDryer(true);
//		 infoVO.setTv(true);
//		 infoVO.setGameRoom(true);
//		 infoVO.setGym(true);
//		 infoVO.setSpa(true);
//		 infoVO.setSwimPool(true);
//		
//		 dao.insert(infoVO);
/* ------------飯店頁面更新--------------- */		
		
		InfoService dao = new InfoService();
		InfoVO infoVO = new InfoVO();
		infoVO.setHotelId(1);
		infoVO.setRegisterName("傑尼尼");
		infoVO.setTel("02-2222-3333");
		infoVO.setTransport("行駛時間尖峰約35分鐘，離峰約25分鐘。(單程票價$34)");
		infoVO.setWebsite("http://www.edaroyal.com.tw/dispPageBox/CPNHP.aspx?ddsPageID=EDACHHP");
		infoVO.setHotelProfile("休閒度假飯店、大型購物商場");
		infoVO.setCheckin("08:00");
		infoVO.setCheckout("12:00");
		infoVO.setGuestPolicies("入住須知需前一晚預定，當日預定需下午兩點前");
		infoVO.setCancelPolicies("取消規定需指定入住前三小時以電話來電取消");
		infoVO.setRoomWifi(false);
		infoVO.setHairDryer(false);
		infoVO.setInternet(true);
		infoVO.setMineralWater(true);
		infoVO.setToiletUtensils(false);
		infoVO.setHairDryer(true);
		infoVO.setTv(true);
		infoVO.setGameRoom(true);
		infoVO.setGym(false);
		infoVO.setSpa(false);
		infoVO.setSwimPool(false);

		System.out.println("修改");
		dao.update(infoVO);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
