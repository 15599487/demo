package com.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.Info;
import com.demo.service.DbService;

@Controller
public class ListInfo {
	
	@Autowired
	private DbService dbs;
	
	
	public DbService getDbs() {
		return dbs;
	}


	public void setDbs(DbService dbs) {
		this.dbs = dbs;
	}

	@RequestMapping("/listinfo")
	public ModelAndView  getAllInfos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listinfo");
		if(dbs==null) System.out.println("xxxx");
		List<Info> l = dbs.getInfo(0);
		mv.addObject("infos",l);
		return mv;
	}
	
	@RequestMapping(value="/saveinfo")
	public String insertInfo(@RequestParam(value="id") Integer id, String name, String intro) {
		Info info = new Info();
		info.setName(name);
		info.setIntro(intro);
		if(id!=null) {
			info.setId(id);
			dbs.update(info);
		}else {
			dbs.insert(info);
		}
		return "redirect:/listinfo";
	}
	
	@RequestMapping(value="/addinfo", method=RequestMethod.GET)
	public String addInfo() {
		return "addinfo";
	}
	@RequestMapping(value="/editinfo/{id}", method=RequestMethod.GET)
	public ModelAndView editInfo(@PathVariable(value="id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addinfo");
		List<Info> l = dbs.getInfo(id);
		mv.addObject("info",l.get(0));
		return mv;
	}
	@RequestMapping(value="/deleteinfo/{id}")
	public String deleteInfo(@PathVariable(value="id") Integer id) {
		if(id!=null) {
			dbs.delete(id);
		}
		return "redirect:/listinfo";
	}
}
