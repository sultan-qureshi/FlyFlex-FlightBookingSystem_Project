package CaseStudy.UserLogin.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserLogin.Model.Flight;
import CaseStudy.UserLogin.Repository.FlightRepository;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/findallflights")
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	@GetMapping("/find/{origin}/{destination}/{departureDate}")
	public List<Flight> getFlights(@PathVariable String origin,@PathVariable String destination,@PathVariable String departureDate)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.ENGLISH);
		LocalDate dpDate = LocalDate.parse(departureDate, formatter);

		return flightRepository.findByDetails(origin,destination,dpDate);
	}

}
