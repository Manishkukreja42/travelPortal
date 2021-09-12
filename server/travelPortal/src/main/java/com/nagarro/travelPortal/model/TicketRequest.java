package com.nagarro.travelPortal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="ticket_gen")
	@Column(nullable=false,updatable=false)
	private int id;
	private String emailId;
	private String request;
	private String priority;
	private String toCity;
	private String fromCity;
	private String startDate;
	private String endDate;
	private String passport;
	private String ProjectName;
	private String expenseBorne;
	private String approvalName;
	private String expectedDuration;
	private String upperBound;
	private String additionalDetails;
	private String ticketState;
	public TicketRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getStartDate() {
		return startDate;
	}
	
	public String getTicketState() {
		return ticketState;
	}

	public void setTicketState(String ticketState) {
		this.ticketState = ticketState;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getExpenseBorne() {
		return expenseBorne;
	}
	public void setExpenseBorne(String expenseBorne) {
		this.expenseBorne = expenseBorne;
	}
	public String getApprovalName() {
		return approvalName;
	}
	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}
	public String getExpectedDuration() {
		return expectedDuration;
	}
	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}
	public String getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	@Override
	public String toString() {
		return "TicketRequest [id=" + id + ", emailId=" + emailId + ", request=" + request + ", priority=" + priority
				+ ", toCity=" + toCity + ", fromCity=" + fromCity + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", passport=" + passport + ", ProjectName=" + ProjectName + ", expenseBorne=" + expenseBorne
				+ ", approvalName=" + approvalName + ", expectedDuration=" + expectedDuration + ", upperBound="
				+ upperBound + ", additionalDetails=" + additionalDetails + ", ticketState=" + ticketState + "]";
	}

	
	
	
	

}
