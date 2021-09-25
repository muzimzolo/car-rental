package com.debugger.car.model;

import com.debugger.car.domain.Cars;

public class CarsModel {
	
	private long carId;
	private String model;
	private String make;
	private int rentalPrice;
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
	
	Cars translateModelToCar() {
		Cars car = new Cars();
		car.setCarId(this.carId);
		car.setModel(model);
		car.setMake(make);
		car.setRentalPrice(rentalPrice);
		car.setYear(year);
		return car;
	}

}
