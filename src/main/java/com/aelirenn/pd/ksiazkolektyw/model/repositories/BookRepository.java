package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.Book;

@Repository
public interface BookRepository extends	 JpaRepository<Book, Long> {
	
	public Book findByBookId(Long bookId);
	
	public List<Book> findFirst3ByOrderByBookIdDesc();
	
	public List<Book> findByTitle(String title);
	
	
}
