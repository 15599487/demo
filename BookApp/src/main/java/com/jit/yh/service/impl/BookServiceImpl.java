package com.jit.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.yh.bean.BookInfo;
import com.jit.yh.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public BookInfo getBook(int id) {
		// TODO Auto-generated method stub
		return bookService.getBook(id);
	}

	@Override
	public List<BookInfo> getAllBook() {
		// TODO Auto-generated method stub
		return bookService.getAllBook();
	 
	}

	@Override
	public int insertBook(BookInfo book) {
		// TODO Auto-generated method stub
		
		return bookService.insertBook(book);
	}

	@Override
	public int updateBook(BookInfo book) {
		// TODO Auto-generated method stub
		return bookService.updateBook(book);
	}

	@Override
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookService.deleteBook(id);
	}

}
