package com.nagarro.travelPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelPortal.model.Country;
import com.nagarro.travelPortal.model.States;
import com.nagarro.travelPortal.repo.CountryRepo;

@Service
public class CountryService {

	CountryRepo repo;
	
	@Autowired
	public CountryService(CountryRepo repo) {
		this.repo=repo;
	}
	
	public List<String> fetchCountries(){
		List<Country> list=new ArrayList<>(); 
		list=repo.findAll();
		
		List<String> newList=new ArrayList<String>();
		
		for(int i=0;i<list.size();i++)
		{
			newList.add(list.get(i).getCountry());
		}
		
		return newList;
	}

}
