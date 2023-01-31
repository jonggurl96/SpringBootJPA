package com.example.JPAdemo.dto;

import com.example.JPAdemo.domain.Book;
import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.domain.BookContractId;
import com.example.JPAdemo.domain.BookStore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookContractDto {

	private long bookId;
	private String title;
	private long bookStoreId;
	private String name;
	private int price;
	
	// @Entity -> Dto
	public BookContractDto(BookContract bc) {
		this.bookId = bc.getBook().getId();
		this.title = bc.getBook().getTitle();
		this.bookStoreId = bc.getBookStore().getId();
		this.name = bc.getBookStore().getName();
		this.price = bc.getPrice();
	}
	
	// Dto -> @Entity
	public BookContract toEntity() {
		return BookContract.builder()
				.book(Book.builder().id(bookId).title(title).build())
				.bookStore(BookStore.builder().id(bookStoreId).name(name).build())
				.price(price)
				.build();
	}
	
	// Dto -> @Entity Key
	public BookContractId toEntryKey() {
		return new BookContractId(bookId, bookStoreId);
	}
}
