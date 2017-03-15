package com.aelirenn.pd.ksiazkolektyw.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aelirenn.pd.ksiazkolektyw.model.entities.BookOnShelf;
import com.aelirenn.pd.ksiazkolektyw.model.entities.Shelf;
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShelfService shelfService;
	
	@Autowired
	private BookOnShelfService	BOSService;

	public UserDao getUser(Long userId){
		return userRepository.findByUserId(userId);
	}
	
	public List<UserDao> getUsers() {
		return userRepository.findAll();
	}
	
	public UserDao getUserByLogin(String login){
		return userRepository.findByLogin(login);
	}
	
	public Map<Long, String> getUsersWithoutMe() {
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		List<UserDao> users = getUsers();
		users.remove(getLoggedUser());
		for (UserDao u : users) {
			map.put(u.getUserId(), (u.getFirstName() + " " + u.getSurname()));
		}
		return map;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userRepository.findByLogin(username);
		return new User(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
	}
	
	public Long getLoggedUserId() {
		return getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getUserId();
	}
	
	public UserDao getLoggedUser(){
		return getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public String getInfoForBook(Long bookId) {
		StringBuilder info = new StringBuilder();
		UserDao user = getLoggedUser();
		List<Shelf> shelfs = shelfService.getShelfForUser(user.getUserId());
		for (Shelf s : shelfs) {
			BookOnShelf book = BOSService.findByBookAndShelfId(bookId, s.getShelfId());
				if (book!=null) {
					info.append("Masz tê ksi¹¿kê na pó³ce: ");
					switch (s.getShelfType()) {
					case "m" : info.append("moje."); break;
					case "tr" : info.append("Chcê przeczytaæ"); break;
					case "tb" : info.append("Chcê kupiæ"); break;
						}
					}
			}
		
		return info.toString();
	}
		
	
	
}

