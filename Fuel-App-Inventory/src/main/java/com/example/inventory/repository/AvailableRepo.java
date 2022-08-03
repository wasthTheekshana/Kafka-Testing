package com.example.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.model.Available;

@Repository
public interface AvailableRepo extends MongoRepository<Available, Integer> {
	Available findByFuelType(String type);
}
