package com.example.bookmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanager.entity.Book;
import com.example.bookmanager.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    // public Book updateBook(Long id, Book bookDetails) {
    //     return bookRepository.findById(id)
    //             .map(book -> {
    //                 book.setTitle(bookDetails.getTitle());
    //                 book.setAuthor(bookDetails.getAuthor());
    //                 book.setIsbn(bookDetails.getIsbn());
    //                 return bookRepository.save(book);
    //             })
    //             .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    // }



}
