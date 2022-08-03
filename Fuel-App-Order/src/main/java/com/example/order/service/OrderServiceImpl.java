package com.example.order.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.order.config.KafkaTopicConfig;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepo;




@Service
public class OrderServiceImpl implements OrderService {
	
	//static int refId = 1000;

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	KafkaTemplate<String, Order> kafkaTemplate;
	
	
	@Override
	public ResponseEntity<Order> saveOrder(Order order) {
		
		Random random = new Random();
		int refId  = random.nextInt(2500);
		
		
		 //refId = refId+1;
		
		try {
			
			order.setOrderRefId(refId);
			kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC, order);
			orderRepo.save(order);
			
		}catch(Exception e) {
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
		
	}

	@Override
	public ResponseEntity<List<Order>> getOrder(int shedId) {
	
		return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findByShedId(shedId));
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
			order.setStatus("Finished");
			
			orderRepo.save(order);
			
			return ResponseEntity.status(HttpStatus.OK).body(order);
			
		}else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}
	

}
