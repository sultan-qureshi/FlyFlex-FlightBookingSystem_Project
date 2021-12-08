package CaseStudy.UserLogin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CaseStudy.UserLogin.Model.Ticket;
@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

}
