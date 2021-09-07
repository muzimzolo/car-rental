package com.debugger.car.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id")
	private long carId;
	
	@Column(name = "model")
	private String model;
	
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "rental_price")
	private int rentalPrice;
	
	@Column(name = "year")
	private int year;

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

}
