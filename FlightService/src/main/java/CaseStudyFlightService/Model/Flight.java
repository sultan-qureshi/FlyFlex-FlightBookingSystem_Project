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

	public String getFlightNo() {
		return FlightNo;
	}

	public String getAirline() {
		return Airline;
	}

	public String getOrigin() {
		return Origin;
	}

	public String getDestination() {
		return Destination;
	}

	public LocalDate getDepartureDate() {
		return DepartureDate;
	}

	public LocalDateTime getDepartureDateAndTime() {
		return DepartureDateAndTime;
	}

	public LocalDateTime getArrivalDateAndTime() {
		return ArrivalDateAndTime;
	}

	public double getTicketPrice() {
		return TicketPrice;
	}
	
	
}
