package com.example.JPAdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAdemo.domain.BookStore;

public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

}
