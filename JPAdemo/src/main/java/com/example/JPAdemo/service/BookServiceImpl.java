package com.example.JPAdemo.service;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.Book;
import com.example.JPAdemo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;

	@Override
	public long countAll() throws Exception {
		// TODO Auto-generated method stub
		return bookRepository.count();
	}

	@Override
	public Book registBook(String title) throws Exception {
		Book book = Book.builder()
				.title(title)
				.build();
		return bookRepository.save(book);
	}

}
