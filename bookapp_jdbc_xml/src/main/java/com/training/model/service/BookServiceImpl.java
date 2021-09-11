package com.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.model.entities.Book;
import com.training.model.persistance.BookDao;
import com.training.model.persistance.BookDaoImpl;

@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService {
	private BookDao dao;
	
	@Autowired
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

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
	public void updateBook(int id, int price) {
		dao.updateBook(id, price);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
