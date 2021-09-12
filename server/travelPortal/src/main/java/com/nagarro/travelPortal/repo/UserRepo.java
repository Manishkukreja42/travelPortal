package com.nagarro.travelPortal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelPortal.model.Admin;
import com.nagarro.travelPortal.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
//	public Optional<User> findAdminByEmail(User user);

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);

}
