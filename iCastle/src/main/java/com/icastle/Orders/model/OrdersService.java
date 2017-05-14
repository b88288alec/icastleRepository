package com.icastle.Orders.model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.ws.RespectBinding;

import com.icastle.orderfollowers.model.OrderFollowersVO;

public class OrdersService {
	
	private OrdersDAO_interface dao = null;
	
	
	public OrdersService(){
		dao = new OrdersHibernateDAO();
	}
	
//	新增訂單
	public void newOrder(OrdersVO ordersVO){

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
		
		ordersVO.setOrderedDate(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));

		dao.insert(ordersVO);
	}
	
//	客戶修改訂單狀態
	public String customerUpdate(Integer orderId){
		OrdersVO order = dao.select_by_orderId(orderId);
		
//		更改時區變成台灣時間
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
		java.sql.Timestamp day = new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis());
		
		order.setOrderState(false);
		order.setCancelDate(day);
		
		dao.update(order);
		
//		轉換時間格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
//		回傳取消時間
		return sdf.format(day);
	}
	
//	客戶搜尋所有訂單
	public List<OrdersVO> search_By_MemberId(Integer memberId){
		List<OrdersVO> result = dao.select_by_memberId(memberId);

		return result;
	}
	
//	客戶和業者搜尋單筆訂單
	public OrdersVO search_By_OrderId(Integer orderId){
		OrdersVO result = dao.select_by_orderId(orderId);
		
		return result;
	}
	
//	業者修改訂單內容
	public void industryUpdate(Integer orderId, String memo){
		OrdersVO order = dao.select_by_orderId(orderId);
		
		order.setMemo(memo);
		
		dao.update(order);
	}

//	業者搜尋訂單
	public List<OrdersVO> search_By_HotelId(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Integer day, Boolean state){
		
		if(day == null){
			if(state == null){
				if(roomTypeId == null){
					if(month == null){
						return dao.select_by_hotelId_year(hotelId, year);
					}else{
						return dao.select_by_hotelId_month(hotelId, year, month);
					}
				}else{
					if(month == null){
						return dao.select_by_hotelId_year_roomTypeId(hotelId, roomTypeId, year);
					}else{
						return dao.select_by_hotelId_month_roomTypeId(hotelId, roomTypeId, year, month);
					}
				}
			}else{
				if(roomTypeId == null){
					if(month == null){
						return dao.select_by_hotelId_year_orderstate(hotelId, year, state);
					}else{
						return dao.select_by_hotelId_month_orderstate(hotelId, year, month, state);
					}
				}else{
					if(month == null){
						return dao.select_by_hotelId_year_roomTypeId_orderstate(hotelId, roomTypeId, year, state);
					}else{
						return dao.select_by_hotelId_month_roomTypeId_orderstate(hotelId, roomTypeId, year, month, state);
					}
				}
			}
		}else{
			if(state == null){
				if(roomTypeId == null){
					return dao.select_by_hotelId_day(hotelId, year, (month-1), day);
				}else{
					return dao.select_by_hotelId_day_roomTypeId(hotelId, roomTypeId, year, (month-1), day);
				}
			}else{
				if(roomTypeId == null){
					return dao.select_by_hotelId_day_orderstate(hotelId, year, (month-1), day, state);
				}else{
					return dao.select_by_hotelId_day_roomTypeId_orderstate(hotelId, roomTypeId, year, (month-1), day, state);
				}
			}
		}
	}
	
//	搜尋所有訂單
	public List<OrdersVO> searchAll(){
		return dao.select_all();
	}
	
//	業者搜尋訂單長條圖
	public List<OrdersChartVO> search_Chart(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Boolean state){
		
		if(year == null){
			if(roomTypeId == null){
				if(state == null){
					if(month == null){
						return dao.chart_select_by_hotelId(hotelId);
					}
				}else{
					return dao.chart_select_by_hotelId_orderstate(hotelId, state);
				}
			}else{
				if(state == null){
					return dao.chart_select_by_hotelId_roomtpyeId(hotelId, roomTypeId);
				}else{
					return dao.chart_select_by_hotelId_roomtpyeId_orderstate(hotelId, roomTypeId, state);
				}
			}
		}else{
			if(roomTypeId == null){
				if(state == null){
					if(month == null){
						return dao.chart_select_by_hotelId_year(hotelId, year);
					}else{
						return dao.chart_select_by_hotelId_year_month(hotelId, year, month);
					}
				}else{
					if(month == null){
						return dao.chart_select_by_hotelId_year_orderstate(hotelId, state, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_orderstate(hotelId, state, year, month);
					}
				}
			}else{
				if(state == null){
					if(month == null){
						return dao.chart_select_by_hotelId_year_roomtpyeId(hotelId, roomTypeId, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_roomtpyeId(hotelId, roomTypeId, year, month);
					}
				}else{
					if(month == null){
						return dao.chart_select_by_hotelId_year_roomtpyeId_orderstate(hotelId, roomTypeId, state, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_roomtpyeId_orderstate(hotelId, roomTypeId, state, year, month);
					}
				}
			}
		}
		return null;
	}
	
//	業者搜尋訂單折線圖
	public List<OrdersChartVO> search_Line_Chart(Integer hotelId, Integer year, Integer roomTypeId, Integer month, Boolean state){
		
		if(year != null){
			if(roomTypeId == null){
				if(state == null){
					if(month == null){
						return dao.chart_select_by_hotelId_year(hotelId, year);
					}else{
						return dao.chart_select_by_hotelId_year_month(hotelId, year, month);
					}
				}else{
					if(month == null){
						return dao.chart_select_by_hotelId_year_orderstate(hotelId, state, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_orderstate(hotelId, state, year, month);
					}
				}
			}else{
				if(state == null){
					if(month == null){
						return dao.chart_select_by_hotelId_year_roomtpyeId(hotelId, roomTypeId, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_roomtpyeId(hotelId, roomTypeId, year, month);
					}
				}else{
					if(month == null){
						return dao.chart_select_by_hotelId_year_roomtpyeId_orderstate(hotelId, roomTypeId, state, year);
					}else{
						return dao.chart_select_by_hotelId_year_month_roomtpyeId_orderstate(hotelId, roomTypeId, state, year, month);
					}
				}
			}
		}
		return null;
	}
	
//	業者搜尋訂單圓餅圖
	public List<OrdersChartVO> search_Pie_Chart(Integer hotelId, Integer year, Integer month, Boolean state){
		if(year == null){
			if(state == null){
				if(month == null){
					return dao.piechart_select_by_hotelId(hotelId);
				}
			}else{
				if(month == null){
					return dao.piechart_select_by_hotelId_orderstate(hotelId, state);
				}
			}
		}else{
			if(state == null){
				if(month == null){
					return dao.piechart_select_by_hotelId_year(hotelId, year);
				}else{
					return dao.piechart_select_by_hotelId_year_month(hotelId, year, month);
				}
			}else{
				if(month == null){
					return dao.piechart_select_by_hotelId_year_orderstate(hotelId, state, year);
				}else{
					return dao.piechart_select_by_hotelId_year_month_orderstate(hotelId, state, year, month);
				}
			}
		}
		return null;
	}
	
}
