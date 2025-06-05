package com.example.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagerApplication.class, args);
	}
	// This is the main entry point for the Spring Boot application.
	//last i updated pom.xml which vaidation-starter dependancy was i forgotten to add
	// this project is about a simple book management system which includes features like adding, updating, and deleting books, as well as searching for books by various criteria.
	// The application uses Spring Data JPA for database interactions and Thymeleaf for rendering HTML views.
	// The application is structured with a controller for handling HTTP requests, a service for business logic, and a repository for data access.
	// The application also includes a simple HTML template for displaying the list of books and a form for adding new books.
	// the application also includes error handling  for cases and validation for the book entity. where you cant submit
	// you cant add null values for the book entity fields like title, author, and isbn.


}
