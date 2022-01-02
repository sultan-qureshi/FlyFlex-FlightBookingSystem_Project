package CaseStudyFlightService.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudyFlightService.Model.Flight;
import CaseStudyFlightService.Repository.FlightRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/flights")
public class FlightServiceController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welocome to Flight Service";
	}
	@GetMapping("/findallflights")
	public List<Flight> getAllFlights(){
		LocalDateTime date = LocalDateTime.now();
		List<Flight> allflights = flightRepository.findAll();
		return allflights.stream().filter(Flight -> Flight.getDepartureDateAndTime().isAfter(date))
		.collect(Collectors.toList());
	}
	
	@GetMapping("/find/{origin}/{destination}/{departureDate}")
	public List<Flight> getFlights(@PathVariable String origin,@PathVariable String destination,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate departureDate)
	{
		LocalDateTime date = LocalDateTime.now();

		List<Flight> allflights = flightRepository.findByDetails(origin,destination,departureDate);
		return allflights.stream().filter(Flight -> Flight.getDepartureDateAndTime().isAfter(date))
		.collect(Collectors.toList());
		
	}
	
	@GetMapping("/findallflightbyid/{_id}")
	public Optional<Flight> getflightbyid(@PathVariable String _id){
		Optional<Flight> flightbyid = flightRepository.findById(_id);
		return flightbyid;
		
	}
	
}
