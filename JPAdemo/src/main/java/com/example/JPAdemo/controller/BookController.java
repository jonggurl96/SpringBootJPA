package com.example.JPAdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAdemo.domain.Book;
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
	public ResponseEntity<Book> registBook(@RequestBody String title) {
		ResponseEntity<Book> entity = null;
		try {
			entity = new ResponseEntity<>(service.registBook(title), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
