package com.icastle.qa.model;

import java.util.List;

public class QaService {

	QaDAO_interface dao = null;
	
//	public QaService(){
//		dao = new QaJNDIDAO();
//	}
	public QaService(){
		dao = new QaHibernateDAO();
	}

// 新增QA
	public void insert(String question, String answer){
		
		QaVO qaVO = new QaVO();
		qaVO.setQuestion(question);
		qaVO.setAnswer(answer);
		dao.insert(qaVO);
		
	}
// 更新QA
	public void update(String question, String answer, Integer id){
		
		QaVO qaVO = new QaVO();
		qaVO.setQuestion(question);
		qaVO.setAnswer(answer);
		qaVO.setId(id);
		dao.update(qaVO);

	}
// 刪除QA	
	public void delete(Integer id){
		QaVO qaVO = new QaVO();
		qaVO.setId(id);
		dao.delete(id);
	}
// 查詢QA
	public List<QaVO> getAll(){
		return dao.getAll();
	}

}
