package com.example.JPAdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAdemo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
