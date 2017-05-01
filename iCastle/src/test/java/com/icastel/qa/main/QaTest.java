package com.icastel.qa.main;

import java.util.List;

import com.icastle.followers.model.FollowersVO;
import com.icastle.qa.model.QaJDBCDAO;
import com.icastle.qa.model.QaVO;

public class QaTest {

	public static void main(String[] args) {
		
//      新增QA		
		QaJDBCDAO qjo = new QaJDBCDAO();
//		QaVO qv = new QaVO();
//		qv.setQuestion("這問題要怎麼解決呢?");
//		qv.setAnswer("讓我來告訴你如何解決吧!");
//		qjo.insert(qv);
//		System.out.println("新增成功");
		
//      更新QA		
//	    QaVO qv2 = new QaVO();
//	    qv2.setQuestion("qqqqqq");
//	    qv2.setAnswer("qqqqq");
//	    qv2.setId(1);
//	    qjo.update(qv2);
//	    System.out.println("更新成功");		
		
//      刪除QA
//        qjo.delete(1);
//		System.out.println("刪除成功");		
		
		
//		查詢
		List<QaVO> list = qjo.getAll();
		for (QaVO aQa : list) {
			System.out.println(aQa.getQuestion() + ",");
			System.out.println(aQa.getAnswer() + ",");
			System.out.println();
		
		
	}

	}
	
}
