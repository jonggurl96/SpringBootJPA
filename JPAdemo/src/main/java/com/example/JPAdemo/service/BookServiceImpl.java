package com.example.JPAdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.Book;
import com.example.JPAdemo.dto.BookDto;
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
	public Book registBook(BookDto dto) throws Exception {
		return bookRepository.save(dto.toEntity());
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
	public Book republishBook(BookDto dto) throws Exception {
		return bookRepository.save(dto.toEntity());
	}

	@Override
	public List<BookDto> bookList() throws Exception {
		List<BookDto> dtos = new ArrayList<BookDto>();
		for(Book book : bookRepository.findAll()) {
			dtos.add(new BookDto(book));
		}
		return dtos;
	}
	
}
