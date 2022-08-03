package com.example.inventory.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Order {

	@JsonProperty
	private int orderRefId;
	@JsonProperty
	private String name;
	@JsonProperty
	private int id;
	@JsonProperty
	private String location;
	@JsonProperty
	private int capacity;
	@JsonProperty
	private String fuelType;
	@JsonProperty
	private String status = "Pending";
	
	
	
	public Order() {}


	public Order(int orderRefId, String name, int id, String location, int capacity, String fuelType, String status) {
		super();
		this.orderRefId = orderRefId;
		this.name = name;
		this.id = id;
		this.location = location;
		this.capacity = capacity;
		this.fuelType = fuelType;
		this.status = status;
	}


	public int getOrderRefId() {
		return orderRefId;
	}


	public void setOrderRefId(int orderRefId) {
		this.orderRefId = orderRefId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderRefId=" + orderRefId +
				", name='" + name + '\'' +
				", id=" + id +
				", location='" + location + '\'' +
				", capacity=" + capacity +
				", fuelType='" + fuelType + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
