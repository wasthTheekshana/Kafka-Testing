package com.example.order.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepo;

import lombok.extern.java.Log;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	
	@Override
	public ResponseEntity<Order> saveOrder(Order order) {
		
		Random random = new Random();
		int x  = random.nextInt(2500);
		
		try {
			
			order.setOrderRefId(x);
			orderRepo.save(order);
			
		}catch(Exception e) {
			
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
		
	}

	@Override
	public ResponseEntity<Optional<Order>> getOrder(int id) {
	
		return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findById(id));
	}

	@Override
	public ResponseEntity<List<Order>> getAllOrders() {
		
		return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findAll());
	}

	@Override
	public ResponseEntity<Order> orderReceived(int id) {
		
		Optional<Order> byId = orderRepo.findById(id);
		if(byId.isPresent()) {
			Order order = byId.get();
			order.setStatus("Completed");
			
			orderRepo.save(order);
			
			return ResponseEntity.status(HttpStatus.OK).body(order);
			
		}else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}
	

}
