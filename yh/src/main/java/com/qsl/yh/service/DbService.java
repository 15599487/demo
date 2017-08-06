package com.qsl.yh.service;

import java.util.List;

import com.qsl.yh.bean.Info;

 

public interface DbService {
	
	public void showMsg();
	
	//db
	public int insert(Info info);
	
	public int delete(int id);
	
	public int update(Info info);
	
	public List<Info> getInfo(int id);
	
}
