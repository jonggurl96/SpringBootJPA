package com.example.JPAdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAdemo.converter.BookDtoConverter;
import com.example.JPAdemo.dto.BookDto;
import com.example.JPAdemo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jpa/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		ResponseEntity<Long> entity = null;
		logger.info("book service count() ......");
		
		try {
			entity = new ResponseEntity<>(service.countAll(), HttpStatus.OK);
			logger.info("success");
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	@PostMapping("/regist")
	public ResponseEntity<BookDto> registBook(@RequestBody BookDto dto) {
		ResponseEntity<BookDto> entity = null;
		try {
			dto = BookDtoConverter.toDto(service.registBook(dto));
			entity = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<BookDto> republishBook(@RequestBody BookDto dto) {
		ResponseEntity<BookDto> entity = null;
		logger.info("update: " + dto);
		try {
			dto = BookDtoConverter.toDto(service.republishBook(dto));
			entity = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> burnBook(@RequestBody String id) {
		ResponseEntity<String> entity = null;
		logger.info("delete: " + id);
		try {
			service.burnBook(Long.parseLong(id));
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDto> chooseBook(@PathVariable("bookId") long id) {
		ResponseEntity<BookDto> entity = null;
		logger.info("select: " + id);
		try {
			BookDto dto = BookDtoConverter.toDto(service.chooseBook(id));
			entity = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return entity;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookDto>> allBooks() {
		ResponseEntity<List<BookDto>> entity = null;
		logger.info("search every book");
		try {
			entity = new ResponseEntity<>(service.bookList(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
