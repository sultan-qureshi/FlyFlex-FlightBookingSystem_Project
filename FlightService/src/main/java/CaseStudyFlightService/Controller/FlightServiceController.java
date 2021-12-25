package CaseStudyFlightService.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
		return flightRepository.findAll();
	}
	
	@GetMapping("/find/{origin}/{destination}/{departureDate}")
	public List<Flight> getFlights(@PathVariable String origin,@PathVariable String destination,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate departureDate)
	{

		return flightRepository.findByDetails(origin,destination,departureDate);
	}
	
	@GetMapping("/findallflightbyid")
	public Optional<Flight> getflightbyid(String _id){
		Optional<Flight> flightbyid = flightRepository.findById(_id);
		return flightbyid;
		
	}
	
}
