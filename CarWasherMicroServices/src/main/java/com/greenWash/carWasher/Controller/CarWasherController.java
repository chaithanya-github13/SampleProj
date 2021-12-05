package com.greenWash.carWasher.Controller;

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

import com.greenWash.carWasher.Model.CarWasher;
import com.greenWash.carWasher.Repository.CarWasherRepository;


@RestController
@RequestMapping("/chay")
public class CarWasherController {

	@Autowired
	private CarWasherRepository carwasherrepository;
	@PostMapping("/carwasher")
	public String addorder(@RequestBody CarWasher ord) {
		carwasherrepository.save(ord);
		return "CarWahser  with Id: "+ord.getCarwasherid()+" has been availed";
	}
	
	@RequestMapping(value="/carwasher/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody CarWasher ord) {
		carwasherrepository.save(ord);
	}
	
	@GetMapping("/allcarwashers")
	public List<CarWasher>getords(){
		return carwasherrepository.findAll();
	}
	
	@DeleteMapping("/deletecarwasher/{id}")
	public String deletebook(@PathVariable int id) {
		carwasherrepository.deleteById(id);
		return "Order Deleted with id :"+id;	
	}
	
	@GetMapping("/findord/{id}")
	public Optional<CarWasher>getord(@PathVariable int id){
		return carwasherrepository.findById(id);
	}
}