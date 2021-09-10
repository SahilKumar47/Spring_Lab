package com.training.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
		//delete 
		bookService.deleteBook(1);
		
	}
}
