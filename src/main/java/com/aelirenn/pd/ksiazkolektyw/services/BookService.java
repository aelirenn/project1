package com.aelirenn.pd.ksiazkolektyw.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aelirenn.pd.ksiazkolektyw.model.entities.Author;
import com.aelirenn.pd.ksiazkolektyw.model.entities.Book;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.AuthorRepository;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.BookRepository;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book find(Long bookId) {
		return bookRepository.findByBookId(bookId);
	}
	
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}
	
	public List<Book> findLast3() {
		return bookRepository.findFirst3ByOrderByBookIdDesc();
	}

	public Book saveBook(Book book) {
		Author author = authorRepository.findByFirstNameAndSurname(book.getAuthor().getFirstName(), book.getAuthor().getSurname());
		if (author == null) {
		author = authorRepository.saveAndFlush(book.getAuthor());
		}
		return bookRepository.saveAndFlush(book);
		
	}
	
}
