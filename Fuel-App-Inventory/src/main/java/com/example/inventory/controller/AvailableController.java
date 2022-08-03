package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.model.Available;
import com.example.inventory.service.AvailableService;

import java.util.List;

@RestController
public class AvailableController {
	
	@Autowired
	AvailableService availableService;


	@PostMapping("/saveavailable")
	public ResponseEntity<Available> saveAvailableFuel(@RequestBody Available available) {
		return availableService.saveAvailableFuel(available);
	}

	@GetMapping
	public ResponseEntity<List<Available>> getAllOrders(){
		return availableService.getAllOrders();
	}
	
//	@PutMapping("/updateavailable")
//	public ResponseEntity<Available> updateAvailableFuel(@PathVariable String fuelType){
//		
//	}
}
