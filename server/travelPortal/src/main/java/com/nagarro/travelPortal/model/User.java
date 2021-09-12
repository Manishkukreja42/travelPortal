package com.nagarro.travelPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false,updatable=false)
	private int id;
	
	private String firstName;
	private String lastName;
	private String businessUnit;
	private String title;
	private String telephone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	private String country;
	private String email;
	private String password;
	
	
//	public User(String firstName, String lastName, String businessUnit, String title, String telephone, String address1,
//			String address2, String city, String state, int zip, String country,String email,String password) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.businessUnit = businessUnit;
//		this.title = title;
//		this.telephone = telephone;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
//		this.country = country;
//		this.email=email;
//		this.password=password;
//	}
	
	
//	public User(String firstName, String lastName, String businessUnit, String title, String telephone, String address1,
//			String city, String state, int zip, String country,String email,String password) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.businessUnit = businessUnit;
//		this.title = title;
//		this.telephone = telephone;
//		this.address1 = address1;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
//		this.country = country;
//		this.email=email;
//		this.password=password;
//	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", businessUnit="
				+ businessUnit + ", title=" + title + ", telephone=" + telephone + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + ", email=" + email + ", password=" + password + "]";
	}


	
	
	
	
	
	
	

}
