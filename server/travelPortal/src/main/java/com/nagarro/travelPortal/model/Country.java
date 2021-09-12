package com.nagarro.travelPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="country_gen")
	@Column(nullable=false,updatable=false)
	private int id;
	private String country;
	
	
	
	
	public Country() {
		super();
	}
	public Country(String country) {
		super();
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + "]";
	}
	
	
	
	

}
