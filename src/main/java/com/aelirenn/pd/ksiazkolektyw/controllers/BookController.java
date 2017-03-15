package com.aelirenn.pd.ksiazkolektyw.controllers;

import java.util.Optional;

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
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;
import com.aelirenn.pd.ksiazkolektyw.services.BookOnShelfService;
import com.aelirenn.pd.ksiazkolektyw.services.BookService;
import com.aelirenn.pd.ksiazkolektyw.services.BorrowedBookService;
import com.aelirenn.pd.ksiazkolektyw.services.ShelfService;
import com.aelirenn.pd.ksiazkolektyw.services.UserService;


@Controller
@SessionAttributes("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookOnShelfService BBOService;
	
	@Autowired
	private ShelfService shelfService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BorrowedBookService borrowedBookService;
	
	@RequestMapping(value="/book/add", method=RequestMethod.GET)
	public String addBook (@ModelAttribute Book book) {
		return "book_add";
	}
	
	@RequestMapping(value="/book/save") 
	public String saveBook(@ModelAttribute Book book, SessionStatus status, Model model) {
		Book newBook = bookService.saveBook(book);
		Long bookId= newBook.getBookId();
		status.setComplete();
		return findBook(model, bookId, status);
	}

	@RequestMapping(value="/book/find", method=RequestMethod.GET)
	public String findBooks(Model model) {
		model.addAttribute("books", this.bookService.findAll());
		return "books";
	}
	
	@RequestMapping(value="/book/find/title", method=RequestMethod.GET)
	public String findBookByTitle(@RequestParam String searchText, Model model) {
		model.addAttribute("books", this.bookService.findByTitle(searchText));
		return "books";
	}
	
	@RequestMapping(value="book/{bookId}", method=RequestMethod.GET)
	public String findBook(Model model, @PathVariable Long bookId, SessionStatus status) {
		model.addAttribute("book", this.bookService.find(bookId));
		Optional<UserDao> user = Optional.ofNullable(userService.getLoggedUser());
		if(user.isPresent()){
		model.addAttribute("shelfs", this.shelfService.getShelfs(userService.getLoggedUserId()));
		model.addAttribute("info", userService.getInfoForBook(bookId));
		}
		model.addAttribute("bookOnShelf", new BookOnShelf());
		return "book";
	}
	
	@RequestMapping(value="book/{bookId}/borrow", method=RequestMethod.GET)
	public String borrowBook(Model model, @PathVariable Long bookId, @ModelAttribute Book book) {
		model.addAttribute("book", this.bookService.find(bookId));
		model.addAttribute("borrowedBook", new BorrowedBook());
		model.addAttribute("users", this.userService.getUsersWithoutMe());
		return "book_borrow";
	}
	
	@RequestMapping(value="/book/add/preview", method=RequestMethod.POST)
	public String approveBook(@ModelAttribute Book book	) {
		return "book_review";
	}
	
	@RequestMapping(value="/book/addtoshelf", method=RequestMethod.POST)
	public String addBookToShelf(@ModelAttribute BookOnShelf bookOnShelf, @ModelAttribute UserDao user, @ModelAttribute Book book, Model model, SessionStatus status) {

		BookOnShelf temp = BBOService.findByBookAndShelfId(book.getBookId(), bookOnShelf.getShelfId());
		if (temp == null) {
			BBOService.addBookOnShelf(bookOnShelf);
				
				switch(shelfService.getShelfById(bookOnShelf.getShelfId()).getShelfType()) {
				case "m" :
					return "redirect:/shelf/my";
				case "tr" :
					return "redirect:/shelf/toread";
				case "tb" :
					return "redirect:/shelf/tobuy";
				case "b" :
					return "redirect:/shelf/borrowed";
				default:
					return "home";
		}
		}

		else return "home";
		
	}
	
	@RequestMapping(value="book/borrow", method=RequestMethod.POST)
	public String borrowBook(@ModelAttribute BorrowedBook borrowedBook, @RequestParam Long userId, @ModelAttribute Book book, Model model, SessionStatus status) {
		borrowedBook.setOwner(userService.getLoggedUser());
		borrowedBook.setBorrower(userService.getUser(userId));
		borrowedBook.setBook(book);
		borrowedBookService.addBorrowedBook(borrowedBook);
		
		return "redirect:/shelf/borrowed";
	}
	
	@ModelAttribute("book")
	Book getBook() {
		return new Book();
	}
	
}
