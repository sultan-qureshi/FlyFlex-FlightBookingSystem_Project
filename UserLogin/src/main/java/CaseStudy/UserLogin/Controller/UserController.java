package CaseStudy.UserLogin.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserLogin.Model.Flight;
import CaseStudy.UserLogin.Model.Ticket;
import CaseStudy.UserLogin.Repository.FlightRepository;
import CaseStudy.UserLogin.Repository.TicketRepository;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
//	public String currentUserName(Authentication authentication) {
//		return authentication.getName();
//	}
	
	@GetMapping("/findallflights")
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	@GetMapping("/find/{origin}/{destination}/{departureDate}")
	public List<Flight> getFlights(@PathVariable String origin,@PathVariable String destination,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate departureDate)
	{
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		formatter = formatter.withLocale(Locale.ENGLISH);
//		LocalDate dpDate = LocalDate.parse(departureDate, formatter);

		return flightRepository.findByDetails(origin,destination,departureDate);
	}
	@GetMapping("find/{_id}")
	public Optional<Flight> getbyid(@PathVariable String _id){
		return flightRepository.findById(_id);
	}
	
	@PostMapping("/bookflight/{_id}")
	public String booking(@PathVariable String _id,@RequestBody Ticket ticket)
	{
		
		Optional<Flight> flightData = flightRepository.findById(_id);
		if (flightData.isPresent()) {
			Flight flite = flightData.get();
			ticket.setFlightNo(flite.getFlightNo());
			ticket.setOrigin(flite.getOrigin());
			ticket.setDestination(flite.getDestination());
			ticket.setDepartureDateAndTime(flite.getDepartureDateAndTime());
			ticket.setArrivalDateAndTime(flite.getArrivalDateAndTime());
			ticket.setTicketPrice(flite.getTicketPrice());
		//	ticket.setBookedBy(currentUserName());
			ticketRepository.save(ticket);
		
			return "Booked Flight>> FlightNo:"+ticket.getFlightNo()+" Name "+ticket.getFullName();			
		}
		else {
			return "Flight NOT FOUND";
		}
		
	}

}
