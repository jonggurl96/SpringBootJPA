package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.domain.BookContract;

public interface BookContractService {

	public BookContract make(long book, long bookstore, int price) throws Exception;
	
	public BookContract getOne(long book, long bookstore) throws Exception;
	
	public List<BookContract> getAll() throws Exception;
	
	public void breakIt(long book, long bookstore) throws Exception;
	
	public BookContract renewal(long book, long bookstore, int price) throws Exception;
}
