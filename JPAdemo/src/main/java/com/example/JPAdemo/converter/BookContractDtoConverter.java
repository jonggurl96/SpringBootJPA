package com.example.JPAdemo.converter;

import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.domain.BookContractId;
import com.example.JPAdemo.dto.BookContractDto;

public class BookContractDtoConverter {

	public static BookContractDto toDto(BookContract bc) {
		return new BookContractDto(
				BookDtoConverter.toDto(bc.getBook()),
				BookStoreDtoConverter.toDto(bc.getBookStore()),
				bc.getPrice());
	}
	
	public static BookContract toEntity(BookContractDto dto) {
		return BookContract.builder()
				.book(BookDtoConverter.toEntity(dto.getBook()))
				.bookStore(BookStoreDtoConverter.toEntity(dto.getBookStore()))
				.price(dto.getPrice())
				.build();
	}
	
	public static BookContractId toEntityKey(BookContractDto dto) {
		return new BookContractId(dto.getBook().getId(), dto.getBookStore().getId());
	}
}
