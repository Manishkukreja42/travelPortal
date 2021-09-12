package com.nagarro.travelPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class States {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="states_gen")
	@Column(nullable=false,updatable=false)
	private int id;
	private String country;
	private String state;
	public States() {
		
	}
	public States(String country, String state) {
		super();
		this.country = country;
		this.state = state;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "States [id=" + id + ", country=" + country + ", state=" + state + "]";
	}
	
	

	

}
