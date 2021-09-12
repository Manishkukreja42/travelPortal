package com.nagarro.travelPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelPortal.model.States;
import com.nagarro.travelPortal.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	StateService service;
	
	@GetMapping("/get/{country}")
	public List<String> fetchStates(@PathVariable("country") String country)
	{
		return service.findByCountry(country);
	}

}
