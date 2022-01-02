package CaseStudy.UserLogin.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import CaseStudy.UserLogin.Model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
	
	
	
	@Query("{'email': ?0}")
	List<User> findByDetails(String email);

}
