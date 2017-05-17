package com.icastle.hotels.main;

import java.util.*;

import com.icastle.hotels.model.HotelService;
import com.icastle.hotels.model.HotelVO;

public class CompareTo {

	public static void main(String[] args){
		
		//查詢所有飯店
		HotelService hotelServ = new HotelService();
		List<HotelVO> hotels = hotelServ.getAll();
		
		for (HotelVO hotel : hotels)
			System.out.println(hotel.getHotelName());
		
		System.out.println();
		
		if (hotels.size() > 0) {
			Collections.sort(hotels, new Comparator<HotelVO>() {
				@Override
				public int compare(final HotelVO hotel1, final HotelVO hotel2) {
					return hotel1.getHot().compareTo(hotel2.getHot());
				}
			});
		}
		Collections.reverse(hotels);
		
		for (HotelVO hotel : hotels)
			System.out.println(hotel.getHotelName());
	}
}
