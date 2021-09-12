package com.training.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.model.entities.Book;
import com.training.model.exception.BookNotFoundException;

@Repository
@Primary
public class BookDaoImplHib implements BookDao {
	private SessionFactory sessionFactory;

	@Autowired
	public BookDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		getSession().persist(book);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
	}

	@Override
	public void updateBook(int id, int price) {
		Book book = getBookById(id);
		book.setPrice(price);
		getSession().merge(book);
	}

	@Override
	public Book getBookById(int id) {
		Book book = getSession().find(Book.class, id);
		if(book == null)
			throw new BookNotFoundException("account with id " + id + " not found");
		return book;
	}

}
