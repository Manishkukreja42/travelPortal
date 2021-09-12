package com.nagarro.travelPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelPortal.model.States;
import com.nagarro.travelPortal.repo.StateRepo;

@Service
public class StateService {
	
	@Autowired
	StateRepo repo;
	
	public List<String> findByCountry(String country)
	{
		List<States> list= repo.findByCountry(country);
		
		List<String> newList=new ArrayList<String>();
		
		for(int i=0;i<list.size();i++)
		{
			newList.add(list.get(i).getState());
		}
		
		return newList;
		
	}

}
