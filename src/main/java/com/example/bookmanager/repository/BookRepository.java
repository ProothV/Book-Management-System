package com.example.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanager.entity.Book;

public interface BookRepository extends  JpaRepository<Book, Long> {
    // Additional query methods can be defined here if needed

}
