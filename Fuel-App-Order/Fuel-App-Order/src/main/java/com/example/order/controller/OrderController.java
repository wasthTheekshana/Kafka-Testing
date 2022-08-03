package com.example.order.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.Order;
import com.example.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@Autowired
	private KafkaTemplate<String,Order> kafkaTemplate;

	@PostMapping("/placeorder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

		kafkaTemplate.send("order_topic",order);
		return orderService.saveOrder(order);
	}
	
	
	@GetMapping("/getorder/{id}")
	public ResponseEntity<Optional<Order>> getOrder(@PathVariable int id){
		return orderService.getOrder(id);
	}
	
	@PutMapping("/orderreceived/{id}")
	public ResponseEntity<Order> orderReceived(@PathVariable int id) {
		return orderService.orderReceived(id);
	}
	
	@GetMapping("/getallorders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	
}
