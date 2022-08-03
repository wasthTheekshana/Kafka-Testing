package com.example.inventory.service;

import com.example.inventory.model.Available;
import com.example.inventory.model.Order;
import com.example.inventory.repository.AvailableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class AvailableServiceImpl implements AvailableService {

    @Autowired
    AvailableRepo availableRepo;

    @Autowired
    private RestTemplate restTemplate ;

    @Override
    public ResponseEntity<Available> saveAvailableFuel(Available available) {
        try {
            availableRepo.save(available);

        } catch (Exception e) {

        }

        return ResponseEntity.status(HttpStatus.OK).body(available);
    }

    @Override
    public Available getCapacity(String fuelType, int fuelCapacity, int orderRefeId) {


        Available byFuelType = availableRepo.findByFuelType(fuelType);
        int capacity = byFuelType.getQty();
        if (capacity >= fuelCapacity) {

           // Order newOrder = getOrder(orderRefeId, "Allocated");
            int newCapacity = capacity - fuelCapacity;
            byFuelType.setQty(newCapacity);

            saveAvailableFuel(byFuelType);
        }

        return byFuelType;

    }

    @Override
    public void getCapacity1(String fuelType, int fuelCapacity, int orderRefeId) {
        Available byFuelType = availableRepo.findByFuelType(fuelType);
        int capacity = byFuelType.getQty();
        if (capacity >= fuelCapacity) {
            getS(orderRefeId);
			//getOrder(orderRefeId, "Allocated");
            int newCapacity = capacity - fuelCapacity;
            byFuelType.setQty(newCapacity);

            saveAvailableFuel(byFuelType);
        }
    }
    @Override
    public ResponseEntity<List<Available>> getAllOrders() {
                return ResponseEntity.status(HttpStatus.OK).body(availableRepo.findAll());
    }

    public void getS(int orderRefId){
        int id = 1002;
        restTemplate.put("http://orders/api/v1/orders/" + orderRefId, Order.class);

    }


}
