package com.example.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.order.model.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer>  {

}
