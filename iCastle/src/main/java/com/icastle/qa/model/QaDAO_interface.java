package com.icastle.qa.model;

import java.util.List;

public interface QaDAO_interface {

	public void insert(QaVO qaVO);  //新增QA
	public void update(QaVO qaVO);  //更新QA
	public void delete(Integer id); //刪除QA
	public List<QaVO> getAll();     //查詢QA
	
	
}
