package com.example.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Available")
public class Available {

	@Id
	private int id;
	private String fuelType;
	private int qty;
	
	public Available() {
		
	}

	public Available(int id, String fuelType, int qty) {
		super();
		this.id = id;
		this.fuelType = fuelType;
		this.qty = qty;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Available [id=" + id + ", fuelType=" + fuelType + ", qty=" + qty + "]";
	}
	
	
	
	
	
	
}
