package rajesh.boot.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rajesh.boot.rest.dal.CustomerRepository;
import rajesh.boot.rest.dal.entity.Customer;

@RestController
public class DatabaseController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value = "/database/customer/{id}", method = RequestMethod.GET)
	public @ResponseBody Customer showMessage(@PathVariable long id) {
		
		Customer c = customerRepository.findById(id);
		System.out.println("" + c);
		return c;
	}
	
	@RequestMapping(value = "/database/customer", method = RequestMethod.POST,	consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Customer showMessage(@RequestBody Customer c) {
		
		System.out.println("DatabaseController req - " + c);
		Customer saved = customerRepository.save(c);
		System.out.println("DatabaseController save - " + saved);
		return saved;
	}
}
