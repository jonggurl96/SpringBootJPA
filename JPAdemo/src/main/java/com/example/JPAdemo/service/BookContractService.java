package com.example.JPAdemo.service;

import java.util.List;

import com.example.JPAdemo.dto.BookContractDto;

public interface BookContractService {

	public BookContractDto make(BookContractDto dto) throws Exception;
	
	public BookContractDto getOne(BookContractDto dto) throws Exception;
	
	public List<BookContractDto> getAll() throws Exception;
	
	public void breakIt(BookContractDto dto) throws Exception;
	
	public BookContractDto renewal(BookContractDto dto) throws Exception;
}
