package com.aelirenn.pd.ksiazkolektyw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.aelirenn.pd.ksiazkolektyw.model.entities.Book;
import com.aelirenn.pd.ksiazkolektyw.model.entities.BookOnShelf;
import com.aelirenn.pd.ksiazkolektyw.model.entities.BorrowedBook;
import com.aelirenn.pd.ksiazkolektyw.model.entities.Shelf;
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;
import com.aelirenn.pd.ksiazkolektyw.services.BookOnShelfService;
import com.aelirenn.pd.ksiazkolektyw.services.BorrowedBookService;
import com.aelirenn.pd.ksiazkolektyw.services.ShelfService;
import com.aelirenn.pd.ksiazkolektyw.services.UserService;

@SessionAttributes("shelf")
@Controller
public class ShelfController {

	
	@Autowired
	private ShelfService shelfService;
	
	@Autowired
	private BookOnShelfService BOSService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BorrowedBookService borrowedBookService;
	
	@RequestMapping(value="/shelf/my", method=RequestMethod.GET)
	public String getMyShelf(Model model, SessionStatus status) {
		Long shelfId = 	shelfService.getShelfId(userService.getLoggedUserId(), "m");
		model.addAttribute("shelf", shelfService.getShelfById(shelfId));
		model.addAttribute("books", this.getBooksForShelf(this.BOSService.findBooksOnShelf(shelfId)) );
		return "shelf_my";
	}
	
	@RequestMapping(value="/shelf/toread", method=RequestMethod.GET)
	public String getToReadShelf(Model model, SessionStatus status) {
		Long shelfId = 	shelfService.getShelfId(userService.getLoggedUserId(), "tr");
		List<BookOnShelf> booksOnShelf = checkOwners(this.BOSService.findBooksOnShelf(shelfId));
		model.addAttribute("shelf", shelfService.getShelfById(shelfId));
		model.addAttribute("books", booksOnShelf);
		return "shelf_toread";
	}
	
	@RequestMapping(value="/shelf/tobuy", method=RequestMethod.GET)
	public String getToBuyShelf(Model model, SessionStatus status) {
		Long shelfId = 	shelfService.getShelfId(userService.getLoggedUserId(), "tb");
		model.addAttribute("shelf", shelfService.getShelfById(shelfId));
		model.addAttribute("books", this.getBooksForShelf(this.BOSService.findBooksOnShelf(shelfId)) );
		return "shelf_tobuy";
	}
	
	@RequestMapping(value="/shelf/borrowed", method=RequestMethod.GET)
	public String getBorrowedShelf(Model model, SessionStatus status) {
		Long shelfId = 	shelfService.getShelfId(userService.getLoggedUserId(),"b");
		model.addAttribute("shelf", shelfService.getShelfById(shelfId));
		model.addAttribute("borrowedBooks", this.borrowedBookService.getAllBorrowedBooksForUser(userService.getLoggedUserId()));
		return "shelf_borrowed";
	}

	@RequestMapping(value="/shelf/borrowed", method=RequestMethod.POST)
	public String borrowBook(Model model, Long userId, Book book) {
		model.addAttribute("books", this.shelfService.borrowBook(book,userId));
		
		return "shelf_borrowed";
	}
	
	@RequestMapping(value="/shelf/update", method=RequestMethod.POST)
	public String updateShelf(Model model, @RequestParam Long bookId, SessionStatus status, @ModelAttribute Shelf shelf) {
		Long shelfId = shelf.getShelfId();
		BOSService.deleteBookFromShelf(BOSService.findByBookAndShelfId(bookId, shelfId));
		status.setComplete();
		switch(shelfService.getShelfById(shelfId).getShelfType()) {
		case "m" :
			return "redirect:/shelf/my";
		case "tr" :
			return "redirect:/shelf/toread";
		case "tb" :
			return "redirect:/shelf/tobuy";
		default:
			return "home";
		}
	}
	
	@RequestMapping(value="/shelf/update/borrowed", method=RequestMethod.POST)
	public String updateBorrowedShelf(Model model, @RequestParam Long borrowedBookId, SessionStatus status, @ModelAttribute Shelf shelf) {
		BorrowedBook bbok = borrowedBookService.findByBook(borrowedBookId);
		if (bbok.getOwner().equals(userService.getLoggedUser())) {
		borrowedBookService.deleteBorrowedBookFromShelf(bbok);
		}
		status.setComplete();
			return "redirect:/shelf/borrowed";

	}

	@RequestMapping(value="/shelf/{shelfId}", method=RequestMethod.GET)
	public String getBooksForShelf(Model model, @PathVariable Long shelfId) {
		if (shelfService.getShelfById(shelfId).getShelfType().equals("b")) {
			Shelf shelf = shelfService.getShelfById(shelfId);
			UserDao user = shelf.getUser();
			model.addAttribute("books", this.borrowedBookService.getAllBorrowedBooksForUser(user.getUserId()));
			model.addAttribute("info", getInfoForShelf(shelfId));
			return "shelf_b";
		}
		else {
		model.addAttribute("books", this.getBooksForShelf(this.BOSService.findBooksOnShelf(shelfId)) );
		model.addAttribute("info", getInfoForShelf(shelfId));
		return "shelf";
		}
	}
	
	private String getInfoForShelf(Long shelfId) {
		Shelf shelf = shelfService.getShelfById(shelfId);
		StringBuilder info = new StringBuilder()
				.append(shelf.getUser().getFirstName())
				.append(" ")
				.append(shelf.getUser().getSurname())
				.append(" : Pó³ka ");
		switch (shelf.getShelfType()) {
		case "m" : info.append("Posiada"); break;
		case "tr" : info.append("Chce przeczytaæ"); break;
		case "tb" : info.append("Chce kupiæ"); break;
		case "b" : info.append("Po¿ycza"); break;
		}
		return info.toString();
	}

	@ModelAttribute("book")
	public Book getBook() {
		return new Book();
	}

	@ModelAttribute("shelf")
	public Shelf getShelf() {
		return new Shelf();
	}
	
	@ModelAttribute("bookOnShelf")
	public BookOnShelf getBookOnShelf() {
		return new BookOnShelf();
	}
	
	@ModelAttribute("borrowedBook")
	public BorrowedBook getBorrowedBook() {
		return new BorrowedBook();
	}
	
	private List<BookOnShelf> checkOwners(List<BookOnShelf> booksOnShelf) {
		for (BookOnShelf b: booksOnShelf) {
			List<BookOnShelf> list = BOSService.findByBookId(b.getId());
			for (BookOnShelf boo : list) {
				Long shelf_id = boo.getShelfId();
				if (("m").equals(shelfService.getShelfById(shelf_id).getShelfType())) {
					b.addOwner((shelfService.getShelfById(shelf_id)).getUser());
				}
			}
		}
		return booksOnShelf;
		//return getBooksForShelf(booksOnShelf);
	}
	
	private List<Book> getBooksForShelf(List<BookOnShelf> booksOnShelf) {
	List<Book> books = new ArrayList<>();
	for (BookOnShelf b: booksOnShelf) {
		books.add(b.getBook());
	}
	 return books;
	}

}
