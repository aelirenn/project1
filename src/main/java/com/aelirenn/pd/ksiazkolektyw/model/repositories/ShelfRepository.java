package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
	
	public List<Shelf> findShelfsByUserUserId(Long userId);
	
	public Shelf findShelfByUserUserIdAndShelfType(Long userId, String shelfType);
	
	public Shelf findShelfByShelfId(Long shefId);
}
