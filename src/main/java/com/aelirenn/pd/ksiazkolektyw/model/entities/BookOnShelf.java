package com.aelirenn.pd.ksiazkolektyw.model.entities;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="books_on_shelf")
public class BookOnShelf {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_book_on_shelf")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;
	
	@Column(name="id_shelf")
	private Long shelfId;
	
	@Transient
	private List<UserDao> owners = new ArrayList<>();

	@Transient
	private Long bookId;
	
	public BookOnShelf() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}
	

	public List<UserDao> getOwners() {
		return owners;
	}

	public void setOwner(List<UserDao> owners) {
		this.owners = owners;
	}

	public List<UserDao> addOwner(UserDao owner) {
		this.owners.add(owner);
		return owners;
		
	}
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId() {
		this.bookId = this.book.getBookId();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shelfId == null) ? 0 : shelfId.hashCode());
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
		BookOnShelf other = (BookOnShelf) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shelfId == null) {
			if (other.shelfId != null)
				return false;
		} else if (!shelfId.equals(other.shelfId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookOnShelf [book=" + book + ", shelfId=" + shelfId + "]";
	}
	
	

}
