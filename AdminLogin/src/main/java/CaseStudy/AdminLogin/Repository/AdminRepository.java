package CaseStudy.AdminLogin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import CaseStudy.AdminLogin.Model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	Admin findByUsername(String username);

}
