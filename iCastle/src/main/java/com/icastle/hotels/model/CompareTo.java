package com.icastle.hotels.model;

import java.util.*;

public class CompareTo {

	public static void main(){
		
		List<HotelVO> hotels = new ArrayList<HotelVO>();
		
		HotelVO hotel1 = new HotelVO();
		hotel1.setHotelId(1);
		hotel1.setHotelName("一號");
		hotels.add(hotel1);

		HotelVO hotel3 = new HotelVO();
		hotel3.setHotelId(3);
		hotel3.setHotelName("三號");
		hotels.add(hotel3);
		
		HotelVO hotel2 = new HotelVO();
		hotel2.setHotelId(2);
		hotel2.setHotelName("二號");
		hotels.add(hotel2);
		
		for (HotelVO hotel : hotels)
			System.out.println(hotel.getHotelName());
		
		System.out.println();
		
		if (hotels.size() > 0) {
			Collections.sort(hotels, new Comparator<HotelVO>() {
				@Override
				public int compare(final HotelVO hotel1, final HotelVO hotel2) {
					return hotel1.getHotelId().compareTo(hotel2.getHotelId());
				}
			});
		}
		
		for (HotelVO hotel : hotels)
			System.out.println(hotel.getHotelName());
	}
}
