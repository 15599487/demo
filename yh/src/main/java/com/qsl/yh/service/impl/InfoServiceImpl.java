package  com.qsl.yh.service.impl;

import com.qsl.yh.service.InfoService;

public class InfoServiceImpl implements InfoService {
	private String msg;
	
	
	
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}

}
