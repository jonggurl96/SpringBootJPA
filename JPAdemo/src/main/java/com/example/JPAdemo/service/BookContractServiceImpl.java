package com.example.JPAdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.dto.BookContractDto;
import com.example.JPAdemo.repository.BookContractRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookContractServiceImpl implements BookContractService {
	
	private final BookContractRepository repository;

	@Override
	public BookContractDto make(BookContractDto dto) throws Exception {
		return new BookContractDto(repository.save(dto.toEntity()));
	}

	@Override
	public BookContractDto getOne(BookContractDto dto) throws Exception {
		return new BookContractDto(
				repository.findById(dto.toEntryKey()).get());
	}

	@Override
	public List<BookContractDto> getAll() throws Exception {
		List<BookContractDto> dtos = new ArrayList<BookContractDto>();
		for(BookContract bc : repository.findAll()) {
			dtos.add(new BookContractDto(bc));
		}
		return dtos;
	}

	@Override
	public void breakIt(BookContractDto dto) throws Exception {
		repository.deleteById(dto.toEntryKey());
	}

	@Override
	public BookContractDto renewal(BookContractDto dto) throws Exception {
		// TODO Auto-generated method stub
		return new BookContractDto(repository.save(dto.toEntity()));
	}

}
