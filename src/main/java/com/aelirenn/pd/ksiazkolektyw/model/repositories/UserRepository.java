package com.aelirenn.pd.ksiazkolektyw.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelirenn.pd.ksiazkolektyw.model.entities.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {

	public UserDao findByUserId(Long userId);

	public UserDao findByLogin(String login);
}
