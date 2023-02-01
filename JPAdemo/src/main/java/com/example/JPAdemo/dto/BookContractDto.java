package com.example.JPAdemo.dto;

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

}
