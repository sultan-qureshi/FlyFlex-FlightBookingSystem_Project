package CaseStudy.AdminLogin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import CaseStudy.AdminLogin.Model.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {

}
