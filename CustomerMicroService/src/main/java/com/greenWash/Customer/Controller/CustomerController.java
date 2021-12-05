package com.greenWash.Customer.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.greenWash.Customer.Model.CarWasher;
import com.greenWash.Customer.Model.Customer;
import com.greenWash.Customer.Repository.CustomerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
private RestTemplate restTemplate;
	@GetMapping("/allcarwashers")
	@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getCarWashers(){
		return  this.restTemplate.getForObject("http://localhost:8081/allcarwashers", List.class);
	}
	public List<?> getFallbackCarwasher(){
		return Arrays.asList(new CarWasher(0,"No",0,00000000,"No service"));
	}
	@PostMapping("/customer")
	public String addorder(@RequestBody Customer ord) {
		customerrepository.save(ord);
		return "Customer  with Id: "+ord.getCustomerid()+" has been processed";
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody Customer ord) {
		customerrepository.save(ord);
	}
	
	@GetMapping("/allcustomers")
	public List<Customer>getords(){
		return customerrepository.findAll();
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletebook(@PathVariable int id) {
		customerrepository.deleteById(id);
		return "Order Deleted with id :"+id;	
	}
	
	@GetMapping("/findord/{id}")
	public Optional<Customer>getord(@PathVariable int id){
		return customerrepository.findById(id);
	}
}