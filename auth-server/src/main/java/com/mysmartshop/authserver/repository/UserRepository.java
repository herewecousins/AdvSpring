package com.mysmartshop.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.mysmartshop.authserver.model.User;

public interface UserRepository extends JpaRepository <User,Long>{
	
	public User findByUsername(String username);
}
