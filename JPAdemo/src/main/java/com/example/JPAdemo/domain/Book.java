package com.example.JPAdemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@EqualsAndHashCode
@Table(name="book")
@SequenceGenerator(
		name = "BOOKSEQ",
		sequenceName = "book_seq",
		initialValue = 1,
		allocationSize = 1)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKSEQ")
	private long id;
	
	@Column(nullable = false)
	private String title;

}
