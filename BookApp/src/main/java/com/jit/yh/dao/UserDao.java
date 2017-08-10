package com.jit.yh.dao;

import org.apache.ibatis.annotations.Param;

import com.jit.yh.bean.UserInfo;

public interface UserDao {
	public UserInfo getUserInfo(int id);
	public UserInfo checkUser(@Param(value="username") String username, @Param(value="password") String password);
}
