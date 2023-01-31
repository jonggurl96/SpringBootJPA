package com.example.JPAdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAdemo.domain.BookContract;
import com.example.JPAdemo.domain.BookContractId;

public interface BookContractRepository extends JpaRepository<BookContract, BookContractId> {

}
