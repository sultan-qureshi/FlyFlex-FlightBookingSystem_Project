package CaseStudy.UserSignup.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.UserSignup.Model.User;
import CaseStudy.UserSignup.Repository.UserRepository;

@RestController
public class SignupController {
	@Autowired
	private UserRepository repository;
	
	
	@PostMapping("/signup")
	public String addUser(@RequestBody User user) {
		repository.save(user);
		return "Added User :"+user.getUsername();
	}

}
