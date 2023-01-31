package com.example.JPAdemo.dto;

import com.example.JPAdemo.domain.BookStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookStoreDto {

	private long id;
	private String name;
	
	// @Entity -> Dto
	public BookStoreDto(BookStore bookStore) {
		this.id = bookStore.getId();
		this.name = bookStore.getName();
	}
	
	// Dto -> @Entity
	public BookStore toEntity() {
		return BookStore.builder().id(id).name(name).build();
	}
}
