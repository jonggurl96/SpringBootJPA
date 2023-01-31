package com.example.JPAdemo.service;

import java.util.List;

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
		return bookRepository.count();
	}

	@Override
	public Book registBook(String title) throws Exception {
		Book book = Book.builder()
				.title(title)
				.build();
		return bookRepository.save(book);
	}

	@Override
	public Book chooseBook(long id) throws Exception {
		return bookRepository.findById(id).get();
	}

	@Override
	public void burnBook(long id) throws Exception {
		bookRepository.deleteById(id);
	}

	@Override
	public Book republishBook(long id, String title) throws Exception {
		Book book = Book.builder().id(id).title(title).build();
		return bookRepository.save(book);
	}

	@Override
	public List<Book> bookList() throws Exception {
		return bookRepository.findAll();
	}
	
}
