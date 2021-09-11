package com.training.model.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.model.entities.Book;

@Repository
@Primary
public class BookDaoImplJdbc implements BookDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BookDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
     
	@Override        
	public List<Book> getAllBooks() {
		String FIND_ALL = "select * from books";

		return jdbcTemplate.query(FIND_ALL, new BookRowMapper());
	}

	@Override
	public Book addBook(Book book) {
		String ADD_BOOK = "insert into books(isbn, title, author, price) values(?, ?, ?, ?);";
		jdbcTemplate.update(ADD_BOOK,
				new Object[] { book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice() });
		return book;
	}

	@Override
	public void deleteBook(int id) {
		String DELETE_QUERY = "delete from books where id=?";
		jdbcTemplate.update(DELETE_QUERY, id);
	}

	@Override
	public void updateBook(int id, int price) {
		String UPDATE_QUERY = "update books set price =? where id=?";
		jdbcTemplate.update(UPDATE_QUERY, new Object[] { price, id });
	}

	@Override
	public Book getBookById(int id){
		String FIND_BYID = "select * from books where id=?";
		return jdbcTemplate.queryForObject(FIND_BYID, new BookRowMapper(), id);
	}

}
