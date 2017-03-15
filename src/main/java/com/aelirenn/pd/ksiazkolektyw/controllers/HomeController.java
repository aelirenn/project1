package com.aelirenn.pd.ksiazkolektyw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelirenn.pd.ksiazkolektyw.services.BookService;

@Controller
public class HomeController {

@Autowired
private BookService bookService;

	@RequestMapping("/")
	public String goHome(Model model) {
		
		model.addAttribute("books", this.bookService.findLast3());
		return "home";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin() {
		return "login";
	}
}
