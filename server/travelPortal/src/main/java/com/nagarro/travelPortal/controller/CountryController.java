package com.nagarro.travelPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelPortal.model.Country;
import com.nagarro.travelPortal.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService service;
	
	@GetMapping("/get")
	public List<String> get() {
		return service.fetchCountries();
	}
	

}
