package com.jit.yh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.jit.yh.bean.BookInfo;
import com.jit.yh.dao.BookDao;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;
	

	@RequestMapping("/listbooks")
	public ModelAndView listBooks() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listbooks");
		List<BookInfo> l = bookDao.getAllBook();
		mv.addObject("books",l);
		return mv;
	}
	
	@RequestMapping(value="/savebook")
	public String insertBook(Integer id, String name, String author, Double price, String publisher) {
		BookInfo info = new BookInfo();
		info.setAuthor(author);
		info.setName(name);
		info.setPrice(price);
		info.setPublisher(publisher);
		if(id!=null) {
			info.setId(id);
			bookDao.updateBook(info);
		}else {
			bookDao.insertBook(info);
		}
		return "redirect:/listbooks";
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.GET)
	public String addBook() {
		return "addbook";
	}
	
	@RequestMapping(value="/editbook/{id}")
	public ModelAndView editBook(@PathVariable(value="id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addbook");
		BookInfo book = bookDao.getBook(id);
		mv.addObject("book",book);
		return mv;
	}
	
	@RequestMapping(value="/deletebook/{id}")
	public String deleteInfo(@PathVariable(value="id") Integer id) {
		if(id!=null) {
			bookDao.deleteBook(id);
		}
		return "redirect:/listbooks";
	}
	@RequestMapping(value="/main")
	public String backToMain() {
		return "main";
	}
	@RequestMapping(value="/logout")
	public String logout() {
		return "login";
		
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}


	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
