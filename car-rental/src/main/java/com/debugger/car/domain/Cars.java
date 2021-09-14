package com.debugger.car.domain;

import java.util.Objects;

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
	@Column(name = "car_id", unique = true)
	private long carId;
	
	@Column(name = "model")
	private String model;
	
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "rental_price")
	private int rentalPrice;
	
	@Column(name = "year")
	private int year;

	private Cars() { }
	public Cars(long carId, String model, String make, int rentalPrice, int year) {
		super();
		this.carId = carId;
		this.model = model;
		this.make = make;
		this.rentalPrice = rentalPrice;
		this.year = year;
	}

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
	@Override
	public int hashCode() {
		return Objects.hash(carId, make, model, rentalPrice, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		return carId == other.carId && Objects.equals(make, other.make) && Objects.equals(model, other.model)
				&& rentalPrice == other.rentalPrice && year == other.year;
	}
	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", model=" + model + ", make=" + make + ", rentalPrice=" + rentalPrice
				+ ", year=" + year + "]";
	}

	

}
