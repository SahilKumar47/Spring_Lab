package com.training.controller;

import java.util.List;

import com.training.model.entities.Book;
import com.training.model.service.BookService;
import com.training.model.service.BookServiceImpl;

public class Main {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		List<Book> list = bookService.getAllBooks();
		list.forEach(b -> System.out.println(b));
	}
}
