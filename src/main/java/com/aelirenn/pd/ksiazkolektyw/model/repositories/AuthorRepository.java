package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	public Author findByFirstNameAndSurname(String firstName, String surname);
}
