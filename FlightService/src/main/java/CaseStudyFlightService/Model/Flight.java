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
	private double TicketPrice;
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
		TicketPrice = ticketPrice;
	}

	public String get_id() {
		return _id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public LocalDateTime getDepartureDateAndTime() {
		return departureDateAndTime;
	}

	public LocalDateTime getArrivalDateAndTime() {
		return arrivalDateAndTime;
	}

	public double getTicketPrice() {
		return TicketPrice;
	}
	
	
}
