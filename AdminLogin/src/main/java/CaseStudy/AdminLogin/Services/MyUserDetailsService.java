package CaseStudy.AdminLogin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import CaseStudy.AdminLogin.Model.Admin;
import CaseStudy.AdminLogin.Repository.AdminRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	AdminRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = repository.findByUsername(username);
		if(admin==null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(admin);
	}

}
