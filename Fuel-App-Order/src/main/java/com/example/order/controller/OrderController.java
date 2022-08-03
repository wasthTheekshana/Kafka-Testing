package com.example.order.controller;


import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.config.KafkaTopicConfig;
import com.example.order.model.Order;
import com.example.order.service.OrderService;

@RestController

@RequestMapping("api/v1/orders")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class OrderController {
	
	@Autowired
	OrderService orderService;


	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/{shedId}")
	public ResponseEntity<List<Order>> getOrder(@PathVariable int shedId){
		return orderService.getOrder(shedId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> orderReceived(@PathVariable int id) {
		return orderService.orderReceived(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	
}
