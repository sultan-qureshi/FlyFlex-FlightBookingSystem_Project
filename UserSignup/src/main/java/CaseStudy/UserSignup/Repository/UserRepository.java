package CaseStudy.UserSignup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CaseStudy.UserSignup.Model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
