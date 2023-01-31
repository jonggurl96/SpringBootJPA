package com.example.JPAdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.domain.BookContractId;
import com.example.JPAdemo.repository.BookContractRepository;
import com.example.JPAdemo.repository.BookRepository;
import com.example.JPAdemo.repository.BookStoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookContractServiceImpl implements BookContractService {
	
	private final BookContractRepository repository;
	private final BookRepository br;
	private final BookStoreRepository bsr;

	@Override
	public BookContract make(long book, long bookstore, int price) throws Exception {
		BookContract con = BookContract.builder()
				.book(br.findById(book).get())
				.bookStore(bsr.findById(bookstore).get())
				.price(price)
				.build();
		return repository.save(con);
	}

	@Override
	public BookContract getOne(long book, long bookstore) throws Exception {
		return repository.findById(new BookContractId(book, bookstore)).get();
	}

	@Override
	public List<BookContract> getAll() throws Exception {
		return repository.findAll();
	}

	@Override
	public void breakIt(long book, long bookstore) throws Exception {
		repository.deleteById(new BookContractId(book, bookstore));
	}

	@Override
	public BookContract renewal(long book, long bookstore, int price) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
