package CaseStudy.AdminLogin.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.AdminLogin.Model.Flight;
import CaseStudy.AdminLogin.Model.JwtRequest;
import CaseStudy.AdminLogin.Repository.FlightRepository;
import CaseStudy.AdminLogin.Utility.JWTUtility;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private FlightRepository flightRepository;
	
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String home() {
		return "Welocome Admin";
	}
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody JwtRequest jwtRequest ) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
							)
					);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtUtility.generateToken(userDetails);
		return token;
	}
	
	
	@GetMapping("/findallflights")
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flight) {
		LocalDateTime current = LocalDateTime.now();
		if(flight.getDepartureDateAndTime().isAfter(current) && flight.getArrivalDateAndTime().isAfter(
				flight.getDepartureDateAndTime())) {
		flight.setDepartureDate(flight.getDepartureDateAndTime().toLocalDate());
		flightRepository.save(flight);
		return "Added Flight : "+flight.getFlightNo()+" From "+flight.getOrigin()+" To "+flight.getDestination();}
		else { return "Invalid  Date Inputs, Flight Not Added"; }
	}
	
	@GetMapping("/findflightbyid/{_id}")
	public Optional<Flight> getflightbyid(@PathVariable String _id){
		Optional<Flight> flightbyid = flightRepository.findById(_id);
		return flightbyid;
		
	}
	@DeleteMapping("/deleteFlight/{_id}")
	public String deletebyid(@PathVariable String _id) {
		Optional<Flight> flightdata = flightRepository.findById(_id);
		if(flightdata.isPresent()) {
			flightRepository.deleteById(_id);
			return "Deleted Flight With Id:"+_id;
		}
		return "Flight Not Found";
		
	}
	
	@PutMapping("/editFlight/{_id}")
	public String editFlight(@PathVariable String _id, @RequestBody Flight flight){
		Optional<Flight> flightdata = flightRepository.findById(_id);
		if(flightdata.isPresent()) {
			Flight flightbyid = flightdata.get();
			LocalDateTime current = LocalDateTime.now();
			if(flight.getDepartureDateAndTime().isAfter(current) && flight.getArrivalDateAndTime().isAfter(
					flight.getDepartureDateAndTime())) {
				
				if (flight.getTicketPrice() != 0.0) {
					flightbyid.setTicketPrice(flight.getTicketPrice());
				}
				if (flight.getDepartureDateAndTime() != null) {
					flightbyid.setDepartureDateAndTime(flight.getDepartureDateAndTime());
					flightbyid.setDepartureDate(flight.getDepartureDateAndTime().toLocalDate());
				}
				if (flight.getArrivalDateAndTime() != null) {
					flightbyid.setArrivalDateAndTime(flight.getArrivalDateAndTime());
				}
				
				
				flightRepository.save(flightbyid);
			
				return  "Flight Updated Succeffully ";
			
			}
			return "Invalid Date Inputs";
			
							
		}
		return null;		
	}
}
