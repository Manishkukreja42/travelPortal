package com.nagarro.travelPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelPortal.model.Admin;
import com.nagarro.travelPortal.model.States;

public interface StateRepo extends JpaRepository<States, Integer> {
	
	public List<States> findByCountry(String country);

}
