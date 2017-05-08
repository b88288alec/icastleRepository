package com.icastle.hotelphotos.main;

import java.util.*;

import com.icastle.hotelphotos.model.*;

public class HotelPhotosTest {

	public static void main(String[] args) {
		
		//批次新增飯店照片
//		HotelPhotosService dao = new HotelPhotosService();
//		HotelPhotosVO photovo = new HotelPhotosVO();
//		photovo.setHotelId(1);
//		photovo.setPhotoOrder(2);
//		photovo.setPohtoDescription("漂亮的照片");
//		HotelPhotosVO photovo2 = new HotelPhotosVO();
//		photovo2.setHotelId(1);
//		photovo2.setPhotoOrder(3);
//		photovo2.setPohtoDescription("漂亮的照片2");
//		List<HotelPhotosVO> photovos = new ArrayList<HotelPhotosVO>();
//		photovos.add(photovo);
//		photovos.add(photovo2);
//		int count = dao.addPhoto(photovos);
//		System.out.println(count);
		
		//批次修改圖片
//		HotelPhotosService dao = new HotelPhotosService();
//		
//		HotelPhotosVO photovo = new HotelPhotosVO();
//		photovo.setId(2);
//		photovo.setHotelId(1);
//		photovo.setPhotoOrder(2);
//		photovo.setPohtoDescription("漂亮的照片555");
//		
//		HotelPhotosVO photovo2 = new HotelPhotosVO();
//		photovo2.setId(4);
//		photovo2.setHotelId(1);
//		photovo2.setPhotoOrder(3);
//		photovo2.setPohtoDescription("漂亮的照片666");
//		
//		List<HotelPhotosVO> photovos = new ArrayList<HotelPhotosVO>();
//		photovos.add(photovo);
//		photovos.add(photovo2);
//		int count = dao.updatePhoto(photovos);
//		System.out.println(count);
		
		//根據id查詢單筆
//		HotelPhotosService dao = new HotelPhotosService();
//		HotelPhotosVO photo = dao.findByPrimaryKey(1);
//		System.out.println(photo.getId());
//		System.out.println(photo.getHotelId());
//		System.out.println(photo.getPhotoOrder());
//		System.out.println(photo.getPhoto());
//		System.out.println(photo.getRoomTypeId());
//		System.out.println(photo.getPohtoDescription());
		
		//查詢飯店的第一張照片
//		HotelPhotosService dao = new HotelPhotosService();
//		HotelPhotosVO photo = dao.findByHotelIdTop1(5);
//		System.out.println(photo.getId());
//		System.out.println(photo.getHotelId());
//		System.out.println(photo.getPhotoOrder());
//		System.out.println(photo.getPhoto());
//		System.out.println(photo.getRoomTypeId());
//		System.out.println(photo.getPohtoDescription());
		
		//根據hotelId查詢該飯店所有照片
//		HotelPhotosService dao = new HotelPhotosService();
//		List<HotelPhotosVO> photovos = dao.findByHotelId(3);
//		for (HotelPhotosVO photo : photovos){
//			System.out.println(photo.getId());
//			System.out.println(photo.getHotelId());
//			System.out.println(photo.getPhotoOrder());
//			System.out.println(photo.getPhoto());
//			System.out.println(photo.getRoomTypeId());
//			System.out.println(photo.getPohtoDescription());
//			System.out.println("--------------------------");
//		}
		
		//根據roomTypeId查詢該房型所有照片
//		HotelPhotosService dao = new HotelPhotosService();
//		List<HotelPhotosVO> photovos = dao.findByRoomTypeId(1);
//		for (HotelPhotosVO photo : photovos){
//			System.out.println(photo.getId());
//			System.out.println(photo.getHotelId());
//			System.out.println(photo.getPhotoOrder());
//			System.out.println(photo.getPhoto());
//			System.out.println(photo.getRoomTypeId());
//			System.out.println(photo.getPohtoDescription());
//			System.out.println("--------------------------");
//		}
		
		//刪除圖片
		HotelPhotosService dao = new HotelPhotosService();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(27);
		ids.add(28);
		int count = dao.deletePhoto(ids);
		System.out.println(count);
		
	}

}
