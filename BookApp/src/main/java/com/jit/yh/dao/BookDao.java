package com.jit.yh.dao;

import java.util.List;

import com.jit.yh.bean.BookInfo;

public interface BookDao {
	public BookInfo getBook(int id);
	public List<BookInfo> getAllBook();
	public int insertBook(BookInfo book);
	public int updateBook(BookInfo book);
	public int deleteBook(int id);
}
