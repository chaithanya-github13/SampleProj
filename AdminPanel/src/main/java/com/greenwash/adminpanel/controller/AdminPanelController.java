package com.greenwash.adminpanel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenwash.adminpanel.model.AdminPanel;
import com.greenwash.adminpanel.repository.AdminPanelRepository;

@RestController
public class AdminPanelController {
	@Autowired
	private AdminPanelRepository adminpanelrepository;
	@PostMapping("/admin")
	public String addadmin(@RequestBody AdminPanel admin) {
		adminpanelrepository.save(admin);
		return "Admin  with Id: "+admin.getAdminid()+" has been processed";
		
	}
	
	@GetMapping("/alladmins")
	public List<AdminPanel>getadmins(){
		return adminpanelrepository.findAll();
	}
	
	@GetMapping("/findadmin/{id}")
	public Optional<AdminPanel>getord(@PathVariable int id){
		return adminpanelrepository.findById(id);
	}
}
