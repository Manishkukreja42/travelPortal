package com.nagarro.travelPortal.repo;

import java.util.List;

import org.apache.poi.hssf.record.chart.TickRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelPortal.model.TicketRequest;
import com.nagarro.travelPortal.model.User;

public interface TicketRepo extends JpaRepository<TicketRequest, Integer>{
	public  List<TicketRequest> findByEmailId(String email);
	public  List<TicketRequest> findByPriorityAndTicketState(String priority,String ticketState);
	public  List<TicketRequest> findByTicketState(String ticketState);
	
	
	public List<TicketRequest> findByEmailIdAndPriority(String email,String priority);

}
