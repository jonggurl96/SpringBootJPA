package com.example.JPAdemo.dto;

import com.example.JPAdemo.domain.BookContract;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookContractDto {

	private BookDto book;
	private BookStoreDto bookStore;
	private int price;
	
	// @Entity -> to Dto
	public BookContractDto(BookContract bc) {
		this.book = new BookDto(bc.getBook());
		this.bookStore = new BookStoreDto(bc.getBookStore());
		this.price = bc.getPrice();
	}
	
	// Dto -> @Entity
	public BookContract toEntity() {
		return BookContract.builder()
				.book(book.toEntity())
				.bookStore(bookStore.toEntity())
				.price(price)
				.build();
	}
}
