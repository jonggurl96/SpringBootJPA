package com.example.JPAdemo.service;

import com.example.JPAdemo.domain.Book;

public interface BookService {

	public long countAll() throws Exception;
	
	public Book registBook(String title) throws Exception;
}
