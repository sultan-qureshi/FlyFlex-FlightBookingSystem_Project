package CaseStudy.UserLogin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CaseStudy.UserLogin.Model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);

}
