package com.example.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.order.model.Order;

public interface OrderService {
	
	public ResponseEntity<Order> saveOrder(Order order);
	public ResponseEntity<List<Order>> getOrder(int shedId);
	public ResponseEntity<List<Order>> getAllOrders();
	public ResponseEntity<Order> orderReceived(int id);

	

}
