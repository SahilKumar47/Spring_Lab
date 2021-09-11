package com.training.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.training.config.AppConfig;
import com.training.model.entities.Book;
import com.training.model.service.BookService;
import com.training.model.service.BookServiceImpl;

@Component
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService = ctx.getBean("bookService", BookService.class);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b -> System.out.println(b));
		//add Book
		Book book = new Book("23C", "headfirst", "abc", 1600);
		bookService.addBook(book);
		//update book
		bookService.updateBook(5, 5000);
		System.out.println("-------------------------------");
		List<Book> remainingBooks = bookService.getAllBooks();
		remainingBooks.forEach(b -> System.out.println(b));
		// delete query
		bookService.deleteBook(3);
		System.out.println("-----------------------------");
		List<Book> remainingBook = bookService.getAllBooks();
		remainingBook.forEach(b -> System.out.println(b));
		

	}
}
