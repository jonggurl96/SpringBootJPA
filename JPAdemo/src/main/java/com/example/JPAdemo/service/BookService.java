package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.domain.Book;
import com.example.JPAdemo.dto.BookDto;

public interface BookService {

	public long countAll() throws Exception;
	
	public Book registBook(BookDto dto) throws Exception;
	
	public Book chooseBook(long id) throws Exception;
	
	public void burnBook(long id) throws Exception;
	
	public Book republishBook(BookDto dto) throws Exception;
	
	public List<BookDto> bookList() throws Exception;
}
