package com.example.JPAdemo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@SequenceGenerator(
		name = "BOOK_STORE_SEQ_GEN",
		sequenceName = "BOOK_STORE_SEQ",
		initialValue = 1,
		allocationSize = 1)
@Table(name = "BOOK_STORE")
public class BookStore {
	
	@Id
	@GeneratedValue(generator = "BOOK_STORE_SEQ_GEN")
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "bookStore")
	private List<BookContract> bookContracts;
	
}
