package com.greenwash.adminpanel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.greenwash.adminpanel.model.AdminPanel;

public interface AdminPanelRepository extends MongoRepository<AdminPanel,Integer> {


	
}
