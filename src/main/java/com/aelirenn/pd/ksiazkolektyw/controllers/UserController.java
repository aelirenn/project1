package com.aelirenn.pd.ksiazkolektyw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aelirenn.pd.ksiazkolektyw.services.ShelfService;

@Controller
public class UserController {

	@Autowired
	private ShelfService shelfService;
	
	@RequestMapping(value="/users/shelfs", method=RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("userShelfs", shelfService.getShelfsForUsers());
		return "users";
	}
	
}
