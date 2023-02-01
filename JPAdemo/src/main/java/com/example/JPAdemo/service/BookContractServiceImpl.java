package com.example.JPAdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JPAdemo.converter.BookContractDtoConverter;
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
		return BookContractDtoConverter.toDto(
				repository.save(BookContractDtoConverter.toEntity(dto)));
	}

	@Override
	public BookContractDto getOne(BookContractDto dto) throws Exception {
		return BookContractDtoConverter.toDto(
				repository.findById(BookContractDtoConverter.toEntityKey(dto)).get());
	}

	@Override
	public List<BookContractDto> getAll() throws Exception {
		List<BookContractDto> dtos = new ArrayList<BookContractDto>();
		for(BookContract bc : repository.findAll()) {
			dtos.add(BookContractDtoConverter.toDto(bc));
		}
		return dtos;
	}

	@Override
	public void breakIt(BookContractDto dto) throws Exception {
		repository.deleteById(BookContractDtoConverter.toEntityKey(dto));
	}

	@Override
	public BookContractDto renewal(BookContractDto dto) throws Exception {
		// TODO Auto-generated method stub
		return BookContractDtoConverter.toDto(
				repository.save(BookContractDtoConverter.toEntity(dto)));
	}

}
