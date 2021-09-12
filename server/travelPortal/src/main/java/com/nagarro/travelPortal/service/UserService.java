package com.nagarro.travelPortal.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nagarro.travelPortal.model.TicketRequest;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Header;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
import com.nagarro.travelPortal.model.User;
import com.nagarro.travelPortal.model.Cities;
import com.nagarro.travelPortal.repo.CityRepo;
import com.nagarro.travelPortal.repo.TicketRepo;
import com.nagarro.travelPortal.repo.UserRepo;
//import com.sun.el.stream.Stream;

@Service
public class UserService {
	
	UserRepo repo;
	
	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	CityRepo cityRepo;

	@Autowired
	public UserService(UserRepo user)
	{
		this.repo=user;
	}
	
	public User saveUser(User user)
	{
		User userCreated=repo.save(user);
		return userCreated;
		
	}
	public User fetchUserByEmailAndPass(String email,String pass)
	{
		return repo.findByEmailAndPassword(email, pass);
	}
	@Autowired
	private JavaMailSender mailSender;
	public void sendmail(String toEmail,String body,String subject) {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setFrom("springtests001@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("Mail send");
	}
	
	public User fetchUserByEmail(String email) {
		
		return repo.findByEmail(email);
	}
//	
	public TicketRequest generateTicket(TicketRequest ticket)
	{
		
		if(ticket.getTicketState().equals("Rejected")||ticket.getTicketState().equals("Accepted"))
			ticket.setTicketState("Resubmitted");
		else
		ticket.setTicketState("Submitted");
		TicketRequest newTicket= ticketRepo.save(ticket);
		return newTicket;
	}
	
	public TicketRequest acceptTicket(TicketRequest ticket)
	{
		ticket.setTicketState("Accepted");
		TicketRequest newTicket= ticketRepo.save(ticket);
		return newTicket;
	}
	public TicketRequest rejectTicket(TicketRequest ticket)
	{
		ticket.setTicketState("Rejected");
		TicketRequest newTicket= ticketRepo.save(ticket);
		return newTicket;
	}
	
	public TicketRequest resubmitTicket(TicketRequest ticket)
	{
		if(ticket.getTicketState().equals("Submitted"))
			return ticket;
		
		ticket.setTicketState("ReSubmitted");
		TicketRequest newTicket= ticketRepo.save(ticket);
		return newTicket;
	}
	
	public List<TicketRequest> findTicket(TicketRequest ticket)
	{
		List<TicketRequest> newTicket= ticketRepo.findByEmailId(ticket.getEmailId());
		return newTicket;
	}
	public List<TicketRequest> findTicketByPriority()
	{
		List<TicketRequest> urgentTicket= ticketRepo.findByPriorityAndTicketState("Urgent","Submitted");
		List<TicketRequest> immediateTicket=ticketRepo.findByPriorityAndTicketState("Immediate","Submitted");
		List<TicketRequest> NormalTicket=ticketRepo.findByPriorityAndTicketState("Normal","Submitted");
		List<TicketRequest> ResubmittedTicket=ticketRepo.findByTicketState("ReSubmitted");
		urgentTicket.addAll(immediateTicket);
		urgentTicket.addAll(NormalTicket);
		urgentTicket.addAll(ResubmittedTicket);
		return urgentTicket;
	} 
	public List<Cities> findCities(){
		return cityRepo.findAll();
	}
	
	
//	public ByteArrayInputStream pdfCreation(User user) throws FileNotFoundException
//	{
//		Document document=new Document();
//		ByteArrayOutputStream out=new ByteArrayOutputStream();
//		try {
//			PdfWriter.getInstance(document,out);
//			document.open();
//			
////			add text to pdf
//			com.itextpdf.text.Font font=FontFactory.getFont(FontFactory.COURIER,14,BaseColor.BLACK);
//			Paragraph para=new Paragraph("User Registration details",font);
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			document.add(Chunk.NEWLINE);
//			PdfPTable table= new PdfPTable(2);
//			Stream.of("Title","Description").forEach(headerTitle -> {
//				PdfPCell header= new PdfPCell();
//				com.itextpdf.text.Font headerFont=FontFactory.getFont(FontFactory.COURIER,14,BaseColor.BLACK);
//				header.setHorizontalAlignment(Element.ALIGN_CENTER);
//				header.setBorderWidth(1);
//				header.setPhrase(new Phrase(headerTitle,headerFont));
//				table.addCell(header);
//			});
//			
//			PdfPCell titleCell=new PdfPCell(new Phrase(user.getEmail()));
//			titleCell.setPaddingLeft(1);
//			titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			table.addCell(titleCell);
//			
//			PdfPCell descCell=new PdfPCell(new Phrase(user.getEmail()));
//			descCell.setPaddingLeft(1);
//			descCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			table.addCell(descCell);
//			
//			document.add(table);
//			document.close();
//		
//			
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			return new ByteArrayInputStream(out.toByteArray());
//
////		String filepath="C:\\Users\\manishkukreja01\\Desktop\\PdfFiles\\simple.pdf";
////	
//////	PdfWriter writer=new PdfWriter(filepath);
//////		
//////		
//////		PdfDocument pdfDoc=new PdfDocument(writer);
//////		pdfDoc.addNewPage();
//////		
//////		Document document=new Document(pdfDoc);
//////		
//////		document.close();
//		
//		
//	}
		
}
