package com.example.inventory.service;

import com.example.inventory.model.Available;
import org.springframework.http.ResponseEntity;


public interface AvailableService {

    public ResponseEntity<Available> saveAvailableFuel(Available available);

    public Available getCapacity(String fuelType,int qty);
    //public ResponseEntity<Available> updateAvailableFuel(@PathVariable String fuelType);
}
