package CaseStudy.UserLogin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import CaseStudy.UserLogin.Model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

}
