package com.example.JPAdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.BookStore;
import com.example.JPAdemo.repository.BookStoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {
	
	private final BookStoreRepository repository;

	@Override
	public BookStore buildBookStore(String name) throws Exception {
		BookStore bs = BookStore.builder()
				.name(name).build();
		return repository.save(bs);
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
	public BookStore remodeling(long id, String name) throws Exception {
		BookStore bs = BookStore.builder()
				.id(id).name(name).build();
		return repository.save(bs);
	}

	@Override
	public void closeBookStore(long id) throws Exception {
		repository.deleteById(id);
	}

}
