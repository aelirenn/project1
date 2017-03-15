package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.BookOnShelf;

@Repository
public interface BookOnShelfRepository extends JpaRepository<BookOnShelf, Long>{
	
	public List<BookOnShelf> findByShelfId(Long shelfId);
	
	public BookOnShelf findByBookBookIdAndShelfId(Long bookId, Long shelfId);
	
	public List<BookOnShelf> findByBookBookId(Long bookId);

}
