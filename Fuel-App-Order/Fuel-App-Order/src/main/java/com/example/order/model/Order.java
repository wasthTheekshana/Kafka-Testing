package com.example.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Document(collection = "Order")
public class Order {
	
	
	private int orderRefId;
	private String name;
	@Id
	private int id;
	private String location;
	private int capacity;
	private String fuelType;
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
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("name='").append(name).append('\'');
		sb.append(", id='").append(id).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
