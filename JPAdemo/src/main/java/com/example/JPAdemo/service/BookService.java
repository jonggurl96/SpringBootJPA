package com.example.JPAdemo.service;

import java.util.List;
import java.util.Optional;

import com.example.JPAdemo.domain.Book;

public interface BookService {

	public long countAll() throws Exception;
	
	public Book registBook(String title) throws Exception;
	
	public Optional<Book> chooseBook(long id) throws Exception;
	
	public void burnBook(long id) throws Exception;
	
	public Book republishBook(Book book) throws Exception;
	
	public List<Book> bookList() throws Exception;
}
