package com.icastle.Orders.main;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tuple.GeneratedValueGeneration;

import com.icastle.members.model.MembersDAO_interface;
import com.icastle.members.model.MembersJDBCDAO;
import com.icastle.members.model.MembersJNDIDAO;
import com.icastle.members.model.MembersVO;
import com.icastle.rooms.model.RoomsService;
import com.icastle.rooms.model.RoomsVO;

import hibernate.util.HibernateUtil;

public class FakeData  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		req.setCharacterEncoding("utf-8");
//			取出旅客資料
			MembersDAO_interface mdao = new MembersJDBCDAO();
			List<MembersVO> mlist = mdao.getAll();
			Map<Integer, StringBuffer> customer = new LinkedHashMap<Integer, StringBuffer>();
			for(MembersVO member: mlist){
				if(!member.isManager()){
					StringBuffer sb = new StringBuffer();
					sb.append("'" + member.getName() + "'" + ",");
					sb.append("'" + member.getBdate() + "'" + ",");
					sb.append("'" + member.getTel() + "'" + ",");
					sb.append("'" + member.getEmail() + "'" + ",");
					sb.append("'" + member.getAddr() + "'" + ",");
					sb.append("'" + member.getPersonId() + "'" + ",");
					sb.append("'" + member.getCountry() + "'" + ",");
					sb.append("'" + member.getPassport() + "'" + ",");
					sb.append("'" + "false" + "'" + ",");
					
					customer.put(member.getMemberId(), sb);
				}
			}
			
//			System.out.println(new GregorianCalendar(2016, 0, 1).getTime());
//			System.out.println((int)(Math.random()*5.0));
			
//			System.out.println(new GregorianCalendar().getTimeInMillis());
//			System.out.println(new java.sql.Date(new GregorianCalendar().getTimeInMillis()));
//			System.out.println(new GregorianCalendar().getTimeInMillis() / (long)(Math.random()*2.0+1));
//			System.out.println(new java.sql.Date(new GregorianCalendar().getTimeInMillis() - (long)(Math.random()*31536000000.0)));
			
//			取出房型資料
			RoomsService rs = new RoomsService();
//			房型編號取出不同房型
			for(int j = 2; j <= 5; j++){
//				一年12個月，照淡旺季準備輸入訂單
				for(int i = 0; i < 12; i++){
					java.sql.Date start = new java.sql.Date(new GregorianCalendar(2016, i, 1).getTimeInMillis());
					java.sql.Date end = null;
					
					switch(i){
					case 3:
					case 5:
					case 8:
					case 10:
						end = new java.sql.Date(new GregorianCalendar(2016, i, 30).getTimeInMillis());
						break;
					case 1:
						end = new java.sql.Date(new GregorianCalendar(2016, i, 29).getTimeInMillis());
						break;
					default:
						end = new java.sql.Date(new GregorianCalendar(2016, i, 31).getTimeInMillis());
						break;
					}
					
//					房間偏好機率
					double popular = 0.0;
					if(j == 3 || j == 4){
						popular = 2.0;
					}else{
						popular = 0.5;
					}
					
					List<RoomsVO> rooms = rs.getRoomsByMonth(1, j, start, end);
//					System.out.println(rooms.size());
					RoomsVO roomData = rooms.get(0);
					
//					訂單飯店資料-1
					StringBuffer rdsb1 = new StringBuffer();
					rdsb1.append("'" + roomData.getRoomId() + "'" + ",");
					rdsb1.append("'" + "1" + "'" + ",");
					rdsb1.append("'" + "德立莊酒店 (Hotel Midtown Richardson)" + "'" + ",");
					rdsb1.append("'" + roomData.getRoomTypeId() + "'" + ",");
					rdsb1.append("'" + roomData.getRoomTypeName() + "'" + ",");
					
//					rdsb.append("'" + roomData.getRoomDate() + "'" + ",");
//					rdsb.append("'" + new java.sql.Date(roomData.getRoomDate().getTime() + 86400000) + "'" + ",");
					
//					訂單飯店資料-2
					StringBuffer rdsb2 = new StringBuffer();
					rdsb2.append("'" + "1" + "'" + ",");
					rdsb2.append("'" + roomData.getPeopleNum() + "'" + ",");
					rdsb2.append("'" + roomData.isBreakfast() + "'" + ",");
					rdsb2.append("'" + roomData.isDinner() + "'" + ",");
					rdsb2.append("'" + roomData.isAfternoonTea() + "'" + ",");
					rdsb2.append("'" + roomData.getPrice() + "'" + ",");
					rdsb2.append("'" + "null" + "'" + ",");
					
//					訂單備註
					StringBuffer endsb = new StringBuffer();
					endsb.append("'" + roomData.getPricePerPerson() + "'" + ",");
					endsb.append("'" + "null" + "'" + ",");
					endsb.append("'" + roomData.getRemark() + "'" + ",");
					endsb.append("'" + "null" + "'" + ",");
					endsb.append("'" + "true" + "'" + ",");
					endsb.append("null");
//					endsb.append("'" +  + "'" + ",");
					
					
					for(RoomsVO room: rooms){
						SimpleDateFormat sdf = new SimpleDateFormat("u");
						java.sql.Date checkin = roomData.getRoomDate();
						java.sql.Date checkout = new java.sql.Date(roomData.getRoomDate().getTime() + 86400000);
						
//						週末機率增加
						double week = 0.5;
						if("5".equals(sdf.format(checkin)) || "6".equals(sdf.format(checkin))){
							week = 2.0;
						}
						
//						印出指令
						for(int k = 1; k <= room.getRoomNumber(); k++){
							if(Math.random()*10.0*week*popular >= 5){
								StringBuffer result = new StringBuffer();
								result.append("insert into orders values(");
								result.append("'" + new java.sql.Date(checkin.getTime() - (long)(Math.random()*31536000000.0)) + "'" + ",");
								int memberId = 0;
								do{
									memberId = (int)(Math.random()*12.0);
								}while(memberId <= 2);
								result.append("'" + memberId + "'" + ",");
								result.append(rdsb1);
								result.append("'" + checkin + "'" + ",");
								result.append("'" + checkout + "'" + ",");
								result.append(rdsb2);
								result.append(customer.get(memberId));
								result.append(endsb);
								result.append(")");
//								result.append("'" +  + "'" + ",");
								
//								System.out.println(result);
							}
						}
					}
				}
			}
			
			
		
//		res.sendRedirect("../index.jsp");
	}

//	public static List<RoomsVO> fakeData(Integer hotelId, Date start, Date end){
//		
//		List<RoomsVO> result = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try{
//			session.beginTransaction();
//			Query query = session.createQuery("from RoomsVO where hotelId = ? and roomDate between ? and ?");
//			query.setParameter(0, hotelId);
//			query.setParameter(1, start);
//			query.setParameter(2, end);
//			result = query.list();
//			session.getTransaction().commit();
//		}catch(RuntimeException e){
//			session.getTransaction().rollback();
//			throw e;
//		}
//		
//		return result;
//	}
	
	
}
