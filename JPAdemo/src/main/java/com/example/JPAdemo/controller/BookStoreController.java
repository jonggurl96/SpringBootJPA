package com.example.JPAdemo.controller;

import java.util.List;
import java.util.Map;

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

import com.example.JPAdemo.domain.BookStore;
import com.example.JPAdemo.service.BookStoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jpa/bookstore")
@RequiredArgsConstructor
public class BookStoreController {

	private final BookStoreService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	
	@PostMapping("/build")
	public ResponseEntity<BookStore> newStore(@RequestBody String name) {
		ResponseEntity<BookStore> entity = null;
		logger.info("new store: " + name);
		try {
			entity = new ResponseEntity<>(service.buildBookStore(name), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookStore> getOneStore(@PathVariable("id") long id) {
		ResponseEntity<BookStore> entity = null;
		logger.info("get one store: " + id);
		try {
			entity = new ResponseEntity<>(service.getABookStore(id), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookStore>> getStores() {
		ResponseEntity<List<BookStore>> entity = null;
		logger.info("get all stores......");
		try {
			entity = new ResponseEntity<>(service.getBookStores(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PutMapping("/remodel")
	public ResponseEntity<BookStore> getOneStore(@RequestBody Map<String, String> map) {
		ResponseEntity<BookStore> entity = null;
		long id = Long.parseLong(map.get("id"));
		String name = map.get("name");
		logger.info("store remodeling: " + id + ", " + name);
		try {
			entity = new ResponseEntity<>(service.remodeling(id, name), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@DeleteMapping("/burn")
	public ResponseEntity<String> burnStore(@RequestBody String sid) {
		ResponseEntity<String> entity = null;
		long id = Long.parseLong(sid);
		logger.info("burning store id: " + id);
		try {
			service.closeBookStore(id);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
