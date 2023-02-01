package com.example.JPAdemo.converter;

import com.example.JPAdemo.domain.BookStore;
import com.example.JPAdemo.dto.BookStoreDto;

public class BookStoreDtoConverter {

	public static BookStoreDto toDto(BookStore bs) {
		return new BookStoreDto(bs.getId(), bs.getName());
	}
	
	public static BookStore toEntity(BookStoreDto dto) {
		return BookStore.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
