package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.domain.BookStore;
import com.example.JPAdemo.dto.BookStoreDto;

public interface BookStoreService {

	public BookStore buildBookStore(BookStoreDto dto) throws Exception;
	
	public BookStore getABookStore(long id) throws Exception;
	
	public List<BookStoreDto> getBookStores() throws Exception;
	
	public BookStore remodeling(BookStoreDto dto) throws Exception;
	
	public void closeBookStore(BookStoreDto dto) throws Exception;
}
