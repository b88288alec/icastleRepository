package com.icastle.hotelInfo.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icastle.hotelInfo.modle.InfoJDBCDAO;
import com.icastle.hotelInfo.modle.InfoVO;

/**
 * Servlet implementation class HotelInfoJNDITest
 */
@WebServlet("/HotelInfoJNDITest")
public class HotelInfoJNDITest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelInfoJNDITest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			InfoJDBCDAO dao =new InfoJDBCDAO();
			
			InfoVO infoVO = dao.findByHotelId(1);		

			System.out.println(infoVO.getRegisterName());
			System.out.println(infoVO.getTel());
			System.out.println(infoVO.getTransport());
			System.out.println(infoVO.getWebsite());
			System.out.println(infoVO.getHotelProfile());
			System.out.println(infoVO.getCheckin());
			System.out.println(infoVO.getCheckout());
			System.out.println(infoVO.getGuestPolicies());
			System.out.println(infoVO.getCancelPolicies());
			System.out.println(infoVO.isRoomWifi());
			System.out.println(infoVO.isHallWifi());
			System.out.println(infoVO.isInternet());
			System.out.println(infoVO.isMineralWater());
			System.out.println(infoVO.isToiletUtensils());
			System.out.println(infoVO.isHairDryer());
			System.out.println(infoVO.isTv());
			System.out.println(infoVO.isGameRoom());
			System.out.println(infoVO.isGym());
			System.out.println(infoVO.isSpa());
			System.out.println(infoVO.isSwimPool());
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
