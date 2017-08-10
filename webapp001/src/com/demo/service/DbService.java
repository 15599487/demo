package com.demo.service;

import java.util.List;

import com.demo.bean.Info;

public interface DbService {

public void showMsg();
	
	//db
	public int insert(Info info);
	
	public int delete(int id);
	
	public int update(Info info);
	
	public List<Info> getInfo(int id);
}
