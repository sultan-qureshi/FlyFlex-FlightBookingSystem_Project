package CaseStudy.AdminLogin.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection= "Flight")
public class Flight {
	
	@Id
	private String _id; 	 
	@Field
	private String flightNo;
	@Field
	private String airline;
	@Field
	private String origin;
	@Field
	private String destination;
	@Field
	private LocalDate departureDate;
	@Field
	private LocalDateTime departureDateAndTime;
	@Field
	private LocalDateTime arrivalDateAndTime;
	@Field
	private double ticketPrice;
	
	
	public Flight() {
		
	}
	public Flight(String _id, String flightNo, String airline, String origin, String destination,
			LocalDate departureDate, LocalDateTime departureDateAndTime, LocalDateTime arrivalDateAndTime,
			double ticketPrice) {
		super();
		this._id = _id;
		this.flightNo = flightNo;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureDateAndTime = departureDateAndTime;
		this.arrivalDateAndTime = arrivalDateAndTime;
		this.ticketPrice = ticketPrice;
	}




	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public LocalDateTime getDepartureDateAndTime() {
		return departureDateAndTime;
	}


	public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
		this.departureDateAndTime = departureDateAndTime;
	}


	public LocalDate getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(LocalDate departureDate) {
		
		this.departureDate = departureDate;
	}


	public LocalDateTime getArrivalDateAndTime() {
		return arrivalDateAndTime;
	}


	public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
		this.arrivalDateAndTime = arrivalDateAndTime;
	}


	public double getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
}
