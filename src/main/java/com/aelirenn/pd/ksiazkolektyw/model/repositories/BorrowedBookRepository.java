package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.BorrowedBook;
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;

@Repository
public interface BorrowedBookRepository extends	 JpaRepository<BorrowedBook, Long>{

	List<BorrowedBook> findByOwnerUserId(Long userId);
	
	List<BorrowedBook> findByBorrowerUserId(Long userId);
	
	BorrowedBook findByBorrowedBookIdAndOwner(Long bookId, UserDao owner);
	
	BorrowedBook findByBorrowedBookId(Long bookId);
}
