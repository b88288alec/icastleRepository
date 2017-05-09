package com.icastle.Orders.model;

import java.util.List;

public interface OrdersDAO_interface {
	
//	新增訂單
	public void insert(OrdersVO ordersVO);
//	修改訂單狀態，顧客或業者用同一個方法
	public void update(OrdersVO ordersVO);
//	顧客搜尋歷史記錄
	public List<OrdersVO> select_by_memberId(Integer memberId);
//	顧客或業者搜尋單筆訂單
	public OrdersVO select_by_orderId(Integer orderId);
//	業者搜尋所有訂單
	public List<OrdersVO> select_by_hotelId_year(Integer hotelId, Integer year);
	public List<OrdersVO> select_by_hotelId_month(Integer hotelId, Integer year, Integer month);
	public List<OrdersVO> select_by_hotelId_day(Integer hotelId, Integer year, Integer month, Integer day);
	public List<OrdersVO> select_by_hotelId_year_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year);
	public List<OrdersVO> select_by_hotelId_month_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year, Integer month);
	public List<OrdersVO> select_by_hotelId_day_roomTypeId(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Integer day);
	public List<OrdersVO> select_by_hotelId_year_orderstate(Integer hotelId, Integer year, Boolean state);
	public List<OrdersVO> select_by_hotelId_month_orderstate(Integer hotelId, Integer year, Integer month, Boolean state);
	public List<OrdersVO> select_by_hotelId_day_orderstate(Integer hotelId, Integer year, Integer month, Integer day, Boolean state);
	public List<OrdersVO> select_by_hotelId_year_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year, Boolean state);
	public List<OrdersVO> select_by_hotelId_month_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Boolean state);
	public List<OrdersVO> select_by_hotelId_day_roomTypeId_orderstate(Integer hotelId, Integer roomTypeId, Integer year, Integer month, Integer day, Boolean state);
//	寫心酸的
	public List<OrdersVO> select_all();
//	業者搜尋訂單圖表
	public List<OrdersVO> chart_select_by_hotelId(Integer hotelId);
	public List<OrdersVO> chart_select_by_hotelId_year(Integer hotelId, Integer year);
	public List<OrdersVO> chart_select_by_hotelId_year_month(Integer hotelId, Integer year, Integer month);
	public List<OrdersVO> chart_select_by_hotelId_roomtpyeId(Integer hotelId, Integer roomTypeId);
	public List<OrdersVO> chart_select_by_hotelId_year_roomtpyeId(Integer hotelId, Integer roomTypeId, Integer year);
	public List<OrdersVO> chart_select_by_hotelId_year_month_roomtpyeId(Integer hotelId, Integer roomTypeId, Integer year, Integer month);
	public List<OrdersVO> chart_select_by_hotelId_orderstate(Integer hotelId, Boolean state);
	public List<OrdersVO> chart_select_by_hotelId_year_orderstate(Integer hotelId, Boolean state, Integer year);
	public List<OrdersVO> chart_select_by_hotelId_year_month_orderstate(Integer hotelId, Boolean state, Integer year, Integer month);
	public List<OrdersVO> chart_select_by_hotelId_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId, Boolean state);
	public List<OrdersVO> chart_select_by_hotelId_year_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId, Boolean state, Integer year);
	public List<OrdersVO> chart_select_by_hotelId_year_month_roomtpyeId_orderstate(Integer hotelId, Integer roomTypeId, Boolean state, Integer year, Integer month);
	
}
