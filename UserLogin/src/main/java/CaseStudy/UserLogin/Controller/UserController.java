package CaseStudy.UserLogin.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserLogin.Model.Flight;
import CaseStudy.UserLogin.Model.JwtRequest;
import CaseStudy.UserLogin.Model.JwtResponse;
import CaseStudy.UserLogin.Model.Ticket;
import CaseStudy.UserLogin.Model.User;
import CaseStudy.UserLogin.Repository.TicketRepository;
import CaseStudy.UserLogin.Repository.UserRepository;
import CaseStudy.UserLogin.Services.FlightServiceImp;
import CaseStudy.UserLogin.Utility.JWTUtility;

@RestController
@RequestMapping("/user")
public class UserController {
	
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
    
    @Autowired
    private TicketRepository ticketRepository;
    
   


	@GetMapping("/")
	public String currentUserName(Authentication authentication) {
		return "Welcome "+authentication.getName();
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

	
	@PostMapping("/bookflight/{_id}")
	public String booking(@PathVariable String _id,@RequestBody Ticket ticket)
	{
		List<Flight> allflights = flightServiceImp.getallflights();
		List<Flight> flightbyid = 
				allflights.stream().filter(
						Flight -> Flight.get_id()
						.equals(_id)).collect(Collectors.toList());
		if(flightbyid.isEmpty()) {
			return "not found";
		}
		else {
			ticket.setFlight(flightbyid.get(0));
			ticket.setPaymentStatus(false);
			ticket.setCheckinStatus(false);
			ticket.setSeatNo("Not CheckedIn Yet");
		//	ticket.setFullName();
			ticketRepository.save(ticket);
			return "Booked Ticket "+ticket.getTicketId()+" for "+ticket.getFullName();
		}
	}
	@GetMapping("/checkin/{ticketId}")
	public String  Checkin(@PathVariable String ticketId,@RequestParam("seatno") String seatNo) {
		Optional<Ticket> ticketData = ticketRepository.findById(ticketId);
		if(ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			if (ticket.isCheckinStatus()== false) {
				ticket.setSeatNo(seatNo);
				ticket.setCheckinStatus(true);
				ticketRepository.save(ticket);
				return "CheckedIn Ticket :" + ticket.getTicketId() + " Seat NO: " + ticket.getSeatNo() + " For  "
						+ ticket.getFullName() + " In Flight" + ticket.getFlight().getFlightNo();
			}
			else {
				return "Already Checked In";
				
			}
		}
		return "Not found";

	}

}
