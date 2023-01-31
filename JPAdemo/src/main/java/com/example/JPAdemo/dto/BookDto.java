package com.example.JPAdemo.dto;

import com.example.JPAdemo.domain.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

	private long id;
	private String title;
	
	// @Entity -> Dto
	public BookDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}
	
	// Dto -> @Entity
	public Book toEntity() {
		return Book.builder().id(id).title(title).build();
	}
}
