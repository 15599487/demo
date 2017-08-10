package com.jit.yh.service;

import com.jit.yh.bean.UserInfo;

public interface UserService {
	public UserInfo getUserInfo(int id);
	public UserInfo checkUser(String username, String password);
}
