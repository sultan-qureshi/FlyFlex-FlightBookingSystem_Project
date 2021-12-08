package CaseStudy.AdminLogin.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import CaseStudy.AdminLogin.Model.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {
	@Query("{'Origin': ?0,'Destination': ?1,'DepartureDate' :?2}")
	List<Flight> findByDetails(String origin,String destination,LocalDate departureDate);
}
