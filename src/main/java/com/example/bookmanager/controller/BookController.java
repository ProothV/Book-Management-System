package com.example.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookmanager.service.BookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.bookmanager.entity.Book;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Display a list of all books
    @GetMapping
    public String listbooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    // Display a form to create a new book
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/create";
    }

    // Handle the submission of the create or edit form
    @PostMapping
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "books/create";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Display a form to edit an existing book
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));
        model.addAttribute("book", book);
        return "books/edit";
    }

    // Handle the submission of the edit form
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        book.setId(id); // Ensure the ID is set for the update
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Handle the deletion of a book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
