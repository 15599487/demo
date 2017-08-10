package com.jit.yh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.yh.bean.UserInfo;
import com.jit.yh.dao.UserDao;
import com.jit.yh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserInfo getUserInfo(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserInfo(id);
	}

	public UserInfo checkUser(String username, String password) {
		return userDao.checkUser(username, password);
	}
}
