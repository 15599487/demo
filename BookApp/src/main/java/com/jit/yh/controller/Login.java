package com.jit.yh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import com.jit.yh.service.UserService;

@Controller
public class Login {
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView userLogin(String username, String password) {
		ModelAndView mv = new ModelAndView();
		if (userService.checkUser(username, password) != null) {
		//if (userService.getUserInfo(1) != null) {
			mv.setViewName("main");
		}else {
			mv.setViewName("login");
			mv.addObject("msg", "用户名或密码错误！");
		}
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
