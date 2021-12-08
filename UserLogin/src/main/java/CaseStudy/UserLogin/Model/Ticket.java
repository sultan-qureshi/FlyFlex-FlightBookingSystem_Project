package CaseStudy.UserLogin.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Tickets")
public class Ticket {
	@Id
	private String ticketId;
	@Field
	private String fullName;
	@Field
	private String email;
	@Field
	private String phoneNo;
	@Field
	private String seatNo;
	@Field
	private boolean checkinStatus;
	@Field
	private boolean paymentStatus;
	@Field
	private Flight flight;

	
	public Ticket() {
		
	}


	public Ticket(String ticketId, String fullName, String email, String phoneNo, String seatNo, boolean checkinStatus,
			boolean paymentStatus, Flight flight) {
		super();
		this.ticketId = ticketId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.seatNo = seatNo;
		this.checkinStatus = checkinStatus;
		this.paymentStatus = paymentStatus;
		this.flight = flight;
	}


	public String getTicketId() {
		return ticketId;
	}


	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	public boolean isCheckinStatus() {
		return checkinStatus;
	}


	public void setCheckinStatus(boolean checkinStatus) {
		this.checkinStatus = checkinStatus;
	}


	public boolean isPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	

}
