package CaseStudy.AdminLogin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import CaseStudy.AdminLogin.Controller.AdminController;
import CaseStudy.AdminLogin.Model.Flight;
import CaseStudy.AdminLogin.Repository.FlightRepository;



@SpringBootTest
class AdminLoginApplicationTests {

	@Autowired
	private AdminController adminController;
	
	@MockBean
	private FlightRepository flightRepository;
	
	
	
	void flighfindTest() {		
		when(flightRepository.findAll()).thenReturn(Stream.of(
				new Flight("102","f12","Airindia","delhi","mumbai",
						LocalDate.of(2021, 12, 20),
						LocalDateTime.of(2021, 12, 20, 15, 00),
						LocalDateTime.of(2021, 12, 20, 17, 00),
						4500.0),
				new Flight("103","f13","Airindia","delhi","pune",
						LocalDate.of(2021, 12, 21),
						LocalDateTime.of(2021, 12, 21, 15, 00),
						LocalDateTime.of(2021, 12, 21, 17, 00),
						4800.0))
		.collect(Collectors.toList()));
		assertEquals(2, adminController.getAllFlights().size());
		
	}
	
	@Test
	void addflightTest() {
	Flight flight = new Flight("106","f13","Airindia","delhi","pune",
				LocalDate.of(2021, 12, 21),
				LocalDateTime.of(2021, 12, 21, 15, 00),
				LocalDateTime.of(2021, 12, 21, 17, 00),
				4800.0);
		assertEquals("Added Flight :106 Number: f13", adminController.saveFlight(flight));
	}

}
