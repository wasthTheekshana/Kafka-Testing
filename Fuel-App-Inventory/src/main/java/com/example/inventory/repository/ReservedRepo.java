package com.example.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.model.Reserved;

@Repository
public interface ReservedRepo extends MongoRepository<Reserved, Integer> {

}
