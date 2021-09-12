package com.nagarro.travelPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelPortal.model.Cities;

public interface CityRepo extends JpaRepository<Cities, Integer> {

}
