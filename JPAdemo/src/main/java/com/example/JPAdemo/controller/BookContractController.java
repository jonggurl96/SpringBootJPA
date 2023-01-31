package com.example.JPAdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAdemo.dto.BookContractDto;
import com.example.JPAdemo.service.BookContractService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jpa/bookcontract")
@RequiredArgsConstructor
public class BookContractController {

	private final BookContractService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BookContractController.class);
	
	@PostMapping("/make")
	public ResponseEntity<BookContractDto> makeContract(@RequestBody BookContractDto dto) {
		ResponseEntity<BookContractDto> entity = null;
		long bid = dto.getBookId();
		long bsid = dto.getBookStoreId();
		int price = dto.getPrice();
		logger.info("make contract book: " + bid + " and store: " + bsid + ", price: " + price);
		try {
			entity = new ResponseEntity<>(service.make(dto), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PostMapping("/one")
	public ResponseEntity<BookContractDto> getOne(
			@RequestBody BookContractDto dto) {
		ResponseEntity<BookContractDto> entity = null;
		logger.info("search a contract: " + dto.getBookId() + ", " + dto.getBookStoreId());
		try {
			entity = new ResponseEntity<>(service.getOne(dto), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookContractDto>> getAll() {
		ResponseEntity<List<BookContractDto>> entity = null;
		logger.info("search all contracts......");
		try {
			entity = new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> remove(@RequestBody BookContractDto dto) {
		ResponseEntity<String> entity = null;
		logger.info("delete contract......: " + dto.getBookId() + ", " + dto.getBookStoreId());
		try {
			service.breakIt(dto);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PutMapping("/renew")
	public ResponseEntity<BookContractDto> renew(@RequestBody BookContractDto dto) {
		ResponseEntity<BookContractDto> entity = null;
		logger.info("delete contract......: " + dto.getBookId() + ", " + dto.getBookStoreId());
		try {
			entity = new ResponseEntity<>(service.renewal(dto), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
