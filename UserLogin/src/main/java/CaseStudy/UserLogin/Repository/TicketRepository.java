package CaseStudy.UserLogin.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import CaseStudy.UserLogin.Model.Ticket;
@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
	@Query("{ 'bookedBy': ?0 }")
	List<Ticket> findByUser(String bookedBy);
	
	@Query("{ 'seatNo': ?0}")
	List<Ticket> findByseat(String seatNo);
}
