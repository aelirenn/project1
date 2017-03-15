package com.aelirenn.pd.ksiazkolektyw.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aelirenn.pd.ksiazkolektyw.model.repositories.BookOnShelfRepository;
import com.aelirenn.pd.ksiazkolektyw.model.entities.BookOnShelf;

@Component
public class BookOnShelfService {
	
	@Autowired
	private BookOnShelfRepository BOSRepository;


	public BookOnShelf addBookOnShelf(BookOnShelf book) {
		return BOSRepository.saveAndFlush(book);		
	}
	
	public BookOnShelf findByBookAndShelfId(Long bookId, Long shelfId) {
		return BOSRepository.findByBookBookIdAndShelfId(bookId, shelfId);
	}

	public void deleteBookFromShelf(BookOnShelf bookOnShelf) {
		BOSRepository.delete(bookOnShelf);
	}
	
	public List<BookOnShelf> findByBookId(Long bookId) {
		return BOSRepository.findByBookBookId(bookId);
	}

	public List<BookOnShelf> findBooksOnShelf(Long shelfId) {
		return BOSRepository.findByShelfId(shelfId);
	}


}
