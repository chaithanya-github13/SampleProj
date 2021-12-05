package com.greenWash.carWasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greenWash.carWasher.Model.CarWasher;
@Repository
public interface CarWasherRepository extends MongoRepository<CarWasher, Integer> {

}
