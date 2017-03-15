package com.aelirenn.pd.ksiazkolektyw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aelirenn.pd.ksiazkolektyw.model.entities.BorrowedBook;
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.BorrowedBookRepository;

@Component
public class BorrowedBookService {

	@Autowired
	private BorrowedBookRepository borrowedBookRepository;
	
	public List<BorrowedBook> getAllBorrowedBooksForUser(Long userId) {
		List<BorrowedBook> books = borrowedBookRepository.findByOwnerUserId(userId);
		books.addAll(borrowedBookRepository.findByBorrowerUserId(userId));
		return books;
	}

	public BorrowedBook addBorrowedBook(BorrowedBook borrowedBook) {

		return borrowedBookRepository.saveAndFlush(borrowedBook);
	}

	public void deleteBorrowedBookFromShelf(BorrowedBook borrowedBook) {
		borrowedBookRepository.delete(borrowedBook);
		
	}

	public BorrowedBook findByBookAndOwner(Long borrowedBookId, UserDao owner) {
		return borrowedBookRepository.findByBorrowedBookIdAndOwner(borrowedBookId, owner);
	}
	
	public BorrowedBook findByBook(Long borrowedBookId) {
		return borrowedBookRepository.findByBorrowedBookId(borrowedBookId);
	}

	
	
}
