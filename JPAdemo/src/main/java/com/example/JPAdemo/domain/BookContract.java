package com.example.JPAdemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@IdClass(BookContractId.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "BOOK_CONTRACT")
public class BookContract {

	@Id
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "BOOK_STORE_ID")
	private BookStore bookStore;
	
	@Column(name = "PRICE")
	public int price;
}
