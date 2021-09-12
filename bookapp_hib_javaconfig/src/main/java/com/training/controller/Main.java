package com.training.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.AppConfig;
import com.training.model.entities.Book;
import com.training.model.service.BookService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService = ctx.getBean("bookService", BookService.class);
		// add Book
		Book book = new Book("1D2", "java in action", "sfwef", 4560);
		bookService.addBook(book);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b -> System.out.println(b));
//		// update book
//		bookService.updateBook(1, 2500);
//		System.out.println("-------------------------------");
//		List<Book> remainingBooks = bookService.getAllBooks();
//		remainingBooks.forEach(b -> System.out.println(b));
//		// delete query
//		bookService.deleteBook(2);
//		System.out.println("-----------------------------");
//		List<Book> remainingBook = bookService.getAllBooks();
//		remainingBook.forEach(b -> System.out.println(b));

	}
}
