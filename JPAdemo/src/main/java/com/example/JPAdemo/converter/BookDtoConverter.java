package com.example.JPAdemo.converter;

import com.example.JPAdemo.domain.Book;
import com.example.JPAdemo.dto.BookDto;

public class BookDtoConverter {

	public static BookDto toDto(Book book) {
		return new BookDto(book.getId(), book.getTitle());
	}
	
	public static Book toEntity(BookDto dto) {
		return Book.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.build();
	}
}
