package CaseStudy.AdminLogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.AdminLogin.Model.Flight;
import CaseStudy.AdminLogin.Repository.FlightRepository;
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/findallflights")
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flight) {
		flightRepository.save(flight);
		return "Added Flight :"+flight.get_id()+" Number: "+flight.getFlightNo();
	}

}
