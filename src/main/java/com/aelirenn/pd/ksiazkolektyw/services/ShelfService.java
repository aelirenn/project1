package com.aelirenn.pd.ksiazkolektyw.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelirenn.pd.ksiazkolektyw.model.ShelfEnum;
import com.aelirenn.pd.ksiazkolektyw.model.UserShelfs;
import com.aelirenn.pd.ksiazkolektyw.model.entities.Book;
import com.aelirenn.pd.ksiazkolektyw.model.entities.Shelf;
import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.ShelfRepository;
import com.aelirenn.pd.ksiazkolektyw.model.repositories.UserRepository;

@Service
public class ShelfService {
	
	@Autowired
	private ShelfRepository shelfRepository;
	
	@Autowired
	private UserRepository userRepository;

	public boolean borrowBook(Book book, Long userId) {
		return true;
	}
	
	public List<String> getShelfNames() {
		return Arrays.asList(ShelfEnum.values())
				.stream()
				.map(s -> s.getName())
				.collect(Collectors.toList());
	}

	public List<Shelf> getShelfForUser(Long id) {
		return shelfRepository.findShelfsByUserUserId(id);
	}
	
	public Map<Long, String> getShelfs(Long userId) {
		
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		List<Shelf> shelfs = getShelfForUser(userId);
		
		for (Shelf s : shelfs) {
			System.out.println(s.getShelfType());
			if (!(s.getShelfType().equals("b"))) {
			map.put(s.getShelfId(), ShelfEnum.getNameFromType(s.getShelfType()));
			}
		}
		return map;	
	}

	public Long getShelfId(Long userId, String shelfType) {
		return shelfRepository.findShelfByUserUserIdAndShelfType(userId, shelfType).getShelfId();
	}
	
	public Shelf getShelfById(Long shelfId) {
		return shelfRepository.findShelfByShelfId(shelfId);
	}

	public List<UserShelfs> getShelfsForUsers() {
		List<UserShelfs> userShelfsList = new ArrayList<>();
		List<UserDao> users = userRepository.findAll();
		
		for (UserDao u: users) {
			userShelfsList.add(createUserShelfs(u,shelfRepository.findShelfsByUserUserId(u.getUserId()) ));
		}
		return userShelfsList;
	}
	
	private UserShelfs createUserShelfs(UserDao user, List<Shelf> shelfs) {
		UserShelfs userShelfs = new UserShelfs();
		userShelfs.setUserName(user.getFirstName()+" "+user.getSurname());
		for (Shelf s : shelfs) {
			switch(s.getShelfType()) {
			case "m" : userShelfs.setMyShelfId(s.getShelfId());
			case "tr" : userShelfs.setToReadShelfId(s.getShelfId());
			case "tb" : userShelfs.setToBuyShelfId(s.getShelfId());
			case "b" : userShelfs.setBorrowedShelfId(s.getShelfId());
			}
		}
		return userShelfs;
	}
	
}
