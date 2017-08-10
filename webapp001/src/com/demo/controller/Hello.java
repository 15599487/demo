package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello {
	@RequestMapping(value="/test1/{XX}", method=RequestMethod.GET)
	public String Test(int TT, @PathVariable(value="XX") int xx) {
		System.out.println(TT+":"+xx);
		return "test";
	}

}
