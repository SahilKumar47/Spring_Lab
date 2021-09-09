package com.training.model.service;

import java.util.List;

import com.training.model.entities.Book;
import com.training.model.persistance.BookDao;
import com.training.model.persistance.BookDaoImpl;

public class BookServiceImpl implements BookService {
	private BookDao dao = new BookDaoImpl();

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
