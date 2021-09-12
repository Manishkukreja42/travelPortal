package com.nagarro.travelPortal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.nagarro.travelPortal.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	public Optional<Admin> findAdminByEmail(Admin admin);

	public Admin findByEmail(String email);
	
	public Admin findByEmailAndPassword(String email,String password);

}
