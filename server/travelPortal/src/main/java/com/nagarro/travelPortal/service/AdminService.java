package com.nagarro.travelPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelPortal.exception.UserNotFoundException;
import com.nagarro.travelPortal.model.Admin;
import com.nagarro.travelPortal.repo.AdminRepo;
import com.nagarro.travelPortal.repo.TicketRepo;

//import tech.getarrays.employeemanager.exception.UserNotFoundException;

@Service
public class AdminService {
	
	AdminRepo repo;
	
	
	@Autowired
	public AdminService(AdminRepo adminRepo)
	{
		this.repo=adminRepo;
	}
	
	public Admin saveAdmin(Admin admin)
	{
		
		return repo.save(admin);
	}
	
	public Admin fetchAdminByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	public Admin fetchAdminByEmailAndPass(String email,String pass)
	{
		return repo.findByEmailAndPassword(email, pass);
	}
	
	public Admin getAdmin(int id)
	{
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User doesnt exist in system"));
	}
	
//	public Admin getAdmin(Admin admin)
//	{
//		Admin findAdmin=repo.findAdminByEmail(admin).orElseThrow(() -> new UserNotFoundException("User doesnt exist in system"));
//		if(admin.getPassword().equals(findAdmin.getPassword()))
//			return findAdmin;
//		return new UserNotFoundException("password doesnt match");
//		
//	}

}
