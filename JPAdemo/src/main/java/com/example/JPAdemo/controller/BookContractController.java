package com.example.JPAdemo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.service.BookContractService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jpa/bookcontract")
@RequiredArgsConstructor
public class BookContractController {

	private final BookContractService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BookContractController.class);
	
	@PostMapping("/make")
	public ResponseEntity<BookContract> makeContract(@RequestBody Map<String, String> map) {
		ResponseEntity<BookContract> entity = null;
		long bid = Long.parseLong(map.get("book"));
		long bsid = Long.parseLong(map.get("bs"));
		int price = Integer.parseInt(map.get("price"));
		logger.info("make contract book: " + bid + " and store: " + bsid + ", price: " + price);
		try {
			entity = new ResponseEntity<>(service.make(bid, bsid, price), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/{bid}/{bsid}")
	public ResponseEntity<BookContract> getOne(
			@PathVariable("bid") long bid,
			@PathVariable("bsid") long bsid) {
		ResponseEntity<BookContract> entity = null;
		logger.info("search a contract: " + bid + ", " + bsid);
		try {
			entity = new ResponseEntity<>(service.getOne(bid, bsid), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookContract>> getAll() {
		ResponseEntity<List<BookContract>> entity = null;
		logger.info("search all contracts......");
		try {
			entity = new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
