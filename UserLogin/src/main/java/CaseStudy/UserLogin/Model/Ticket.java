package CaseStudy.UserLogin.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Tickets")
public class Ticket {
	@Id
	private String TicketId;
	@Field
	private String FlightNo;
	@Field
	private String FullName;
	@Field
	private String Email;
	@Field
	private String PhoneNo;
	@Field
	private String Origin;
	@Field
	private String Destination;
	@Field
	private LocalDateTime DepartureDateAndTime;
	@Field
	private LocalDateTime ArrivalDateAndTime;
	@Field
	private String SeatNo;
	@Field
	private double TicketPrice;
	@Field
	private String BookedBy;
	
	
	public Ticket(String ticketId, String flightNo, String fullName, String email, String phoneNo, String origin,
			String destination, LocalDateTime departureDateAndTime, LocalDateTime arrivalDateAndTime, String seatNo,
			double ticketPrice, String bookedBy) {
		super();
		TicketId = ticketId;
		FlightNo = flightNo;
		FullName = fullName;
		Email = email;
		PhoneNo = phoneNo;
		Origin = origin;
		Destination = destination;
		DepartureDateAndTime = departureDateAndTime;
		ArrivalDateAndTime = arrivalDateAndTime;
		SeatNo = seatNo;
		TicketPrice = ticketPrice;
		BookedBy = bookedBy;
	}
	public String getTicketId() {
		return TicketId;
	}
	public void setTicketId(String ticketId) {
		TicketId = ticketId;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public LocalDateTime getDepartureDateAndTime() {
		return DepartureDateAndTime;
	}
	public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
		DepartureDateAndTime = departureDateAndTime;
	}
	public LocalDateTime getArrivalDateAndTime() {
		return ArrivalDateAndTime;
	}
	public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
		ArrivalDateAndTime = arrivalDateAndTime;
	}
	public String getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}
	public double getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		TicketPrice = ticketPrice;
	}
	public String getFlightNo() {
		return FlightNo;
	}
	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}
	public String getBookedBy() {
		return BookedBy;
	}
	public void setBookedBy(String bookedBy) {
		BookedBy = bookedBy;
	}
	

}
