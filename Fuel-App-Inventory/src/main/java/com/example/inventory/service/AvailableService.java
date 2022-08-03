package com.example.inventory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.inventory.model.Available;
import com.example.inventory.model.Order;

public interface AvailableService {

	public ResponseEntity<Available> saveAvailableFuel(Available available);
	//public ResponseEntity<Available> updateAvailableFuel(@PathVariable String fuelType);
	public Available getCapacity( String fuelType, int fuelCapacity,int orderRefeId);
	public void getCapacity1( String fuelType, int fuelCapacity,int orderRefeId);
	public ResponseEntity<List<Available>> getAllOrders();
}
