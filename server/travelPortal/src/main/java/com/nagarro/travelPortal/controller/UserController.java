package com.nagarro.travelPortal.controller;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.nagarro.travelPortal.PdfExporter;
import com.nagarro.travelPortal.model.Cities;
import com.nagarro.travelPortal.model.TicketRequest;
import com.nagarro.travelPortal.model.User;
import com.nagarro.travelPortal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	UserService service;
	
	@Autowired
	public UserController(UserService user)
	{
		this.service=user;
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		
		User findUser=service.fetchUserByEmail(user.getEmail());
		if(findUser!=null)
			throw new Exception("User with the email id already exists");
		User newUser= service.saveUser(user);
		
		return newUser;
	}
	@PostMapping("/generateTicket")
	public TicketRequest generateTicket(@RequestBody TicketRequest ticket)
	{
		return service.generateTicket(ticket);
	}
	@PostMapping("/FindTicket")
	public List<TicketRequest> findTicket(@RequestBody TicketRequest ticket)
	{
		return service.findTicket(ticket);
	}
	
	@GetMapping("/FindTicketByPriority")
	public List<TicketRequest> findTicketByPriority()
	{
		return service.findTicketByPriority();
	}
	
	
	@PostMapping("/ticketAccepted")
	public TicketRequest acceptTicket(@RequestBody TicketRequest ticket)
	{
		return service.acceptTicket(ticket);
	}
	@PostMapping("/ticketRejected")
	public TicketRequest rejectTicket(@RequestBody TicketRequest ticket)
	{
		return service.rejectTicket(ticket);
	}
	@PutMapping("/ticketReSubmitted")
	public TicketRequest reSubmitTicket(@RequestBody TicketRequest ticket)
	{
		return service.resubmitTicket(ticket);
	}
	
	@GetMapping("/cities")
	public List<Cities> findCities() {
		return service.findCities();
	}
	
	@PutMapping("/editTicket")
	public TicketRequest editTicket(@RequestBody TicketRequest ticket)
	{
		return service.generateTicket(ticket);
	}
	
	
	
	
	@PostMapping("/pdf")
    public void exportToPDF(@RequestBody User user, HttpServletResponse response) throws DocumentException, IOException {
		System.out.println("i m in pdf");
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
//        List<User> listUsers = service.listAll();
         
       PdfExporter exporter = new PdfExporter(user);
        exporter.export(response);
         
    }
//	@PostMapping("/pdf")
//	public ResponseEntity<InputStreamResource> getPdf(@RequestBody User user) throws FileNotFoundException
//	{
//		
//		ByteArrayInputStream bais=service.pdfCreation(user);
//		HttpHeaders headers=new HttpHeaders();
//		headers.add("Content-Disposition","inline; filename=user.pdf");
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
//	}
	
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		
		User fetchUser=service.fetchUserByEmailAndPass(user.getEmail(), user.getPassword());
		if(fetchUser==null)
			throw new Exception("Wrong credentials");
		
		return fetchUser;
	}
	
	@PostMapping("/forgetPassword")
	public User forget(@RequestBody User user) throws Exception
	{
		User fetchUser=service.fetchUserByEmail(user.getEmail());
		if(fetchUser==null)
			throw new Exception("E-mail not found");
		
		String body="your email id is "+fetchUser.getEmail()+" and your password is "+fetchUser.getPassword();
		service.sendmail(user.getEmail(), body, "Login Credentials");
		return  fetchUser;
	}

}
