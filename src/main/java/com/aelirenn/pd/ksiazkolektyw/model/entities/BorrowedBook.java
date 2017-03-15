package com.aelirenn.pd.ksiazkolektyw.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="borrowed_books")
public class BorrowedBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_borrowed_books")
	private Long borrowedBookId;
	
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;

	@ManyToOne
	@JoinColumn(name="owner_id")
	private UserDao owner;
	
	@ManyToOne
	@JoinColumn(name="borrower_id")
	private UserDao borrower;
	
	@Transient
	private Long userId;

	public Long getBorrowedBookId() {
		return borrowedBookId;
	}
	public void setBorrowedBookId(Long borrowedBookId) {
		this.borrowedBookId = borrowedBookId;
	}
	public BorrowedBook() {
		
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UserDao getOwner() {
		return owner;
	}

	public void setOwner(UserDao owner) {
		this.owner = owner;
	}

	public UserDao getBorrower() {
		return borrower;
	}

	public void setBorrower(UserDao borrower) {
		this.borrower = borrower;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((borrowedBookId == null) ? 0 : borrowedBookId.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowedBook other = (BorrowedBook) obj;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (borrowedBookId == null) {
			if (other.borrowedBookId != null)
				return false;
		} else if (!borrowedBookId.equals(other.borrowedBookId))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BorrowedBook [book=" + book + ", owner=" + owner + ", Borrower=" + borrower + "]";
	}
	
	
}
