package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.domain.BookStore;

public interface BookStoreService {

	public BookStore buildBookStore(String name) throws Exception;
	
	public BookStore getABookStore(long id) throws Exception;
	
	public List<BookStore> getBookStores() throws Exception;
	
	public BookStore remodeling(long id, String name) throws Exception;
	
	public void closeBookStore(long id) throws Exception;
}
