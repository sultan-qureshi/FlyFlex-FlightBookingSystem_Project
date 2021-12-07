package CaseStudy.UserLogin.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserLogin.Model.Flight;
import CaseStudy.UserLogin.Model.JwtRequest;
import CaseStudy.UserLogin.Model.JwtResponse;
import CaseStudy.UserLogin.Model.User;
import CaseStudy.UserLogin.Repository.UserRepository;
import CaseStudy.UserLogin.Services.FlightServiceImp;
import CaseStudy.UserLogin.Utility.JWTUtility;
@RestController
@RequestMapping("/user")
public class UserController {
	
	
//	@Autowired
//	private TicketRepository ticketRepository;
	
//	public String currentUserName(Authentication authentication) {
//		return authentication.getName();
//	}
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private FlightServiceImp flightServiceImp;
	
	@GetMapping("/")
	public String home() {
		return "Welocome USER";
	}
	
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest ) throws Exception {
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
		return new JwtResponse(token);
	}
	
	@PostMapping("/signup")
	public String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "Added User :"+user.getUsername();
	}
	
	
	
	@GetMapping("/allflights")
	public List<Flight> getall(){
		List<Flight> flight = flightServiceImp.getallflights();
		return flight;
	
	}
	
	@GetMapping("/find/{origin}/{destination}/{departureDate}")
	public List<Flight> getflight(@PathVariable String origin,@PathVariable String destination,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate departureDate){
		List<Flight> list = flightServiceImp.getallflights();
		return list.stream()
				.filter(Flight -> Flight.getOrigin().equals(origin)
						&& Flight.getDestination().equals(destination)
						&& Flight.getDepartureDate().equals(departureDate)) 
				.collect(Collectors.toList());
	}
	
//	@GetMapping("find/{_id}")
//	public Optional<Flight> getbyid(@PathVariable String _id){
//		return flightRepository.findById(_id);
//	}
	
	
	
//	@PostMapping("/bookflight/{_id}")
//	public String booking(@PathVariable String _id,@RequestBody Ticket ticket)
//	{
//		
//		Optional<Flight> flightData = flightRepository.findById(_id);
//		if (flightData.isPresent()) {
//			Flight flite = flightData.get();
//			ticket.setFlightNo(flite.getFlightNo());
//			ticket.setOrigin(flite.getOrigin());
//			ticket.setDestination(flite.getDestination());
//			ticket.setDepartureDateAndTime(flite.getDepartureDateAndTime());
//			ticket.setArrivalDateAndTime(flite.getArrivalDateAndTime());
//			ticket.setTicketPrice(flite.getTicketPrice());
//		//	ticket.setBookedBy(currentUserName());
//			ticketRepository.save(ticket);
//		
//			return "Booked Flight>> FlightNo:"+ticket.getFlightNo()+" Name "+ticket.getFullName();			
//		}
//		else {
//			return "Flight NOT FOUND";
//		}
//		
//	}

}
