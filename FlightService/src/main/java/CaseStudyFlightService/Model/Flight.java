package CaseStudyFlightService.Model;

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
	private String FlightNo;
	@Field
	private String Airline;
	@Field
	private String Origin;
	@Field
	private String Destination;
	@Field
	private LocalDate DepartureDate;
	@Field
	private LocalDateTime DepartureDateAndTime;
	@Field
	private LocalDateTime ArrivalDateAndTime;
	@Field
	private double TicketPrice;
	public Flight() {
		
	}
	
	public Flight(String _id, String flightNo, String airline, String origin, String destination,
			LocalDate departureDate, LocalDateTime departureDateAndTime, LocalDateTime arrivalDateAndTime,
			double ticketPrice) {
		super();
		this._id = _id;
		FlightNo = flightNo;
		Airline = airline;
		Origin = origin;
		Destination = destination;
		DepartureDate = departureDate;
		DepartureDateAndTime = departureDateAndTime;
		ArrivalDateAndTime = arrivalDateAndTime;
		TicketPrice = ticketPrice;
	}




	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String getFlightNo() {
		return FlightNo;
	}


	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}


	public String getAirline() {
		return Airline;
	}


	public void setAirline(String airline) {
		Airline = airline;
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


	public LocalDate getDepartureDate() {
		return DepartureDate;
	}


	public void setDepartureDate(LocalDate departureDate) {
		
		DepartureDate = departureDate;
	}


	public LocalDateTime getArrivalDateAndTime() {
		return ArrivalDateAndTime;
	}


	public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
		ArrivalDateAndTime = arrivalDateAndTime;
	}


	public double getTicketPrice() {
		return TicketPrice;
	}


	public void setTicketPrice(double ticketPrice) {
		TicketPrice = ticketPrice;
	}
	
}
