package com.icastle.record.main;

import java.util.List;

import com.icastle.record.model.RecordService;
import com.icastle.record.model.RecordVO;

public class RecordTest {

	public static void main(String[] args) {
		RecordService rs = new RecordService();
//		List<RecordVO> records = rs.search_records_by_id(1);
//		for(RecordVO record : records){
//			System.out.println(record.getId());
//			System.out.println(record.getManagerRecord());
//		}
		
		List<RecordVO> records = rs.search_records_by_name("博士");
		for(RecordVO record : records){
			System.out.println(record.getId());
			System.out.println(record.getManagerRecord());
		}
	}

}
