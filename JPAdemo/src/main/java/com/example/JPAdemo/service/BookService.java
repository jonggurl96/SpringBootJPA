package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.domain.Book;

public interface BookService {

	public long countAll() throws Exception;
	
	public Book registBook(String title) throws Exception;
	
	public Book chooseBook(long id) throws Exception;
	
	public void burnBook(long id) throws Exception;
	
	public Book republishBook(long id, String title) throws Exception;
	
	public List<Book> bookList() throws Exception;
}
