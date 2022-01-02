package CaseStudy.UserLogin.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserLogin.Model.Flight;
import CaseStudy.UserLogin.Model.JwtRequest;
import CaseStudy.UserLogin.Model.Ticket;
import CaseStudy.UserLogin.Model.User;
import CaseStudy.UserLogin.Repository.TicketRepository;
import CaseStudy.UserLogin.Repository.UserRepository;
import CaseStudy.UserLogin.Services.FlightServiceImp;
import CaseStudy.UserLogin.Utility.JWTUtility;

@RestController
@CrossOrigin(origins = "*")
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
    
   


	
//	public String wlcom() {
//		return "Welcome Again";
//	}
    @GetMapping("/")
	public String currentUserName(Authentication authentication) {
		return authentication.getName();
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
				//new JwtResponse(token);
	}
	
//	@PostMapping("/signup")
//	public String addUser(@RequestBody User user) {
//		userRepository.save(user);
//		return "Successfully Registered :"+user.getUsername();
//	}

	@PostMapping("/signup/{username}")
 	public String adUser(@PathVariable String username,@RequestBody User user) {
 		Optional<User> users = userRepository.findById(username);
 		if(users.isEmpty()) {
 			String email = user.getEmail();
 			List<User> userbyemail = userRepository.findByDetails(email);
 			if(userbyemail.isEmpty()) {
 			
 			userRepository.save(user);
 			
 			return "Successfully Registered :"+user.getUsername()+" Now You Can Login";
 			}
 			else {
 				return "Email Id Already Registered";
 			}
 		}
 		else {
 			return "UserName Not Available"; 
 			}
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
			return "Booked Ticket for "+ticket.getFullName() +" In "+ticket.getFlight().getFlightNo()+" "+ticket.getFlight().getOrigin()+
					" -> "+ticket.getFlight().getDestination();
		}
	}
	@GetMapping("/checkin/{ticketId}/{seatNo}")
	public String  Checkin(@PathVariable String ticketId,@PathVariable String seatNo) {
		Optional<Ticket> ticketData = ticketRepository.findById(ticketId);
		if(ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			String flightid = ticket.getFlight().get_id();
			if (ticket.isCheckinStatus()== false) {
				List<Ticket> ticketseat = ticketRepository.findByseat(seatNo);
				List<Ticket> fticket = ticketseat.stream().filter(Ticket -> Ticket.getFlight().get_id().equals(flightid))
						.collect(Collectors.toList());
				if(fticket.isEmpty()) {
				ticket.setSeatNo(seatNo);
				ticket.setCheckinStatus(true);
				ticketRepository.save(ticket);
				return " Successfully CheckedIn for " + ticket.getFullName() +
						" In " + ticket.getFlight().getFlightNo() +" with Seat No: " + ticket.getSeatNo();
				}
				else {
					return "Seat Already Occupied";
				}
			}
				
			else {
				return "Already Checked In";
				
			}
		}
		return "Not found";

		}
	@GetMapping("/allTickets/{bookedBy}")
	public List<Ticket> getallTickets(@PathVariable String bookedBy){
		LocalDateTime date = LocalDateTime.now();
		List<Ticket> ticbyuser = ticketRepository.findByUser(bookedBy);
		return  ticbyuser.stream().filter(Ticket -> Ticket.getFlight().getDepartureDateAndTime().isAfter(date))
		.collect(Collectors.toList());
		//return ticketRepository.findByUser(bookedBy);	
	}
	
	@GetMapping("/allPastTickets/{bookedBy}")
	public List<Ticket> getallpastTickets(@PathVariable String bookedBy){
		LocalDateTime date = LocalDateTime.now();
		List<Ticket> ticbyuser = ticketRepository.findByUser(bookedBy);
		return  ticbyuser.stream().filter(Ticket -> Ticket.getFlight().getDepartureDateAndTime().isBefore(date))
		.collect(Collectors.toList());	
	}
	
	@DeleteMapping("/cancelTicket/{ticketId}")
	public String cancel(@PathVariable String ticketId) {
		Optional<Ticket> ticketdata = ticketRepository.findById(ticketId);
		if(ticketdata.isPresent()) {
		ticketRepository.deleteById(ticketId);
		return "Cancelled ticket with Id "+ticketId; }
		return "Ticket Not Found!";
		
	}
	

}
