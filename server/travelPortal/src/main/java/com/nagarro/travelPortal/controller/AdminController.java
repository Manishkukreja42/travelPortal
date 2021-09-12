package com.nagarro.travelPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelPortal.model.Admin;
import com.nagarro.travelPortal.service.AdminService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	AdminService service;
	
	@Autowired
	public AdminController(AdminService adminService) {
		service=adminService;
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) throws Exception
	{
		String tempEmailId=admin.getEmail();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Admin adminobj=service.fetchAdminByEmail(tempEmailId);
			if(adminobj !=null) {
				throw new Exception("E-mail already exists");
			}
		}
		Admin newAdmin=service.saveAdmin(admin);
		return new ResponseEntity<>(newAdmin,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin ) throws Exception
	{
		String tempEmail=admin.getEmail();
		String tempPass=admin.getPassword();
		Admin findAdmin=null;
		if(tempEmail!=null && tempPass !=null) {
			 findAdmin=service.fetchAdminByEmailAndPass(tempEmail, tempPass);
		}
		if(findAdmin==null)
		{
			throw new Exception("Bad Credentials");
		}
		return findAdmin;
	}
	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Admin> addEmployee(@PathVariable("id") int id){
//		Admin admin=service.getAdmin(id);
//		return new ResponseEntity<>(admin,HttpStatus.CREATED);
//	}
	

}
