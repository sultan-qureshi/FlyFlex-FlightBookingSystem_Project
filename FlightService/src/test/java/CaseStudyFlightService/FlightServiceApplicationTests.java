package CaseStudyFlightService;

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

import CaseStudyFlightService.Controller.FlightServiceController;
import CaseStudyFlightService.Model.Flight;
import CaseStudyFlightService.Repository.FlightRepository;

@SpringBootTest
class FlightServiceApplicationTests {
	
	@Autowired
	private FlightServiceController flightServiceController;
	
	@MockBean
	private FlightRepository flightRepository;
	

	
	@Test
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
		assertEquals(2, flightServiceController.getAllFlights().size());
		
	}
	@Test
	void flighSearchTest() {
		String origin = "delhi";
		String dest = "pune";
		LocalDate date = LocalDate.of(2021, 12, 21);
		when(flightServiceController.getFlights(origin,dest,date)
				).thenReturn(Stream.of(
						new Flight("103","f13","Airindia","delhi","pune",
						LocalDate.of(2021, 12, 21),
						LocalDateTime.of(2021, 12, 21, 15, 00),
						LocalDateTime.of(2021, 12, 21, 17, 00),
						4800.0))
						.collect(Collectors.toList()));
		assertEquals(1, flightServiceController.getFlights(origin, dest, date).size());
				
	}
	

}
