package CaseStudy.UserLogin.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import CaseStudy.UserLogin.Model.Flight;

@Service
public class FlightServiceImp {
	
	 @Autowired
	 private RestTemplate restTemplate;
	
	public List<Flight> getallflights(){
		String url ="http://flight-service/findallflights";
		Flight[] flight = restTemplate.getForObject(url, Flight[].class);
		return Arrays.asList(flight);
	}


}
