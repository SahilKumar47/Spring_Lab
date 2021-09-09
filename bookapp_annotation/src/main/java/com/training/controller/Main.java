package com.training.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.training.model.entities.Book;
import com.training.model.service.BookService;
import com.training.model.service.BookServiceImpl;

@Component
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		BookService bookService = ctx.getBean("bookService", BookServiceImpl.class);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b -> System.out.println(b));
	}
}
