package com.example.JPAdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.BookStore;
import com.example.JPAdemo.dto.BookStoreDto;
import com.example.JPAdemo.repository.BookStoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {
	
	private final BookStoreRepository repository;

	@Override
	public BookStore buildBookStore(BookStoreDto dto) throws Exception {
		return repository.save(dto.toEntity());
	}

	@Override
	public BookStore getABookStore(long id) throws Exception {
		return repository.findById(id).get();
	}

	@Override
	public List<BookStore> getBookStores() throws Exception {
		return repository.findAll();
	}

	@Override
	public BookStore remodeling(BookStoreDto dto) throws Exception {
		return repository.save(dto.toEntity());
	}

	@Override
	public void closeBookStore(BookStoreDto dto) throws Exception {
		repository.deleteById(dto.getId());
	}

}
