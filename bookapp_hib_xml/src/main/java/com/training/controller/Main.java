package com.training.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.training.model.entities.Book;
import com.training.model.service.BookService;
import com.training.model.service.BookServiceImpl;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		BookService bookService = ctx.getBean("bookService", BookService.class);
		// add Book
//		Book book = new Book("23C", "headfirst", "abc", 1600);
//		bookService.addBook(book);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b -> System.out.println(b));
		//update book
		bookService.updateBook(1, 2500);
		System.out.println("-------------------------------");
		List<Book> remainingBooks = bookService.getAllBooks();
		remainingBooks.forEach(b -> System.out.println(b));
		// delete query
		bookService.deleteBook(2);
		System.out.println("-----------------------------");
		List<Book> remainingBook = bookService.getAllBooks();
		remainingBook.forEach(b -> System.out.println(b));

	}
}
