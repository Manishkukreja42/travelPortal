package com.nagarro.travelPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelPortal.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{
	
	

}
