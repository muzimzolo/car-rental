package com.debugger.car.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.Cars;
import com.debugger.car.repository.CarsRepository;

@RestController
@RequestMapping
public class CarsController {
	
	CarsRepository carsRepository;

	public CarsController(CarsRepository carsRepository) {
		super();
		this.carsRepository = carsRepository;
	}
	@GetMapping("/cars")
	public Iterable<Cars> getAllCars() {
		return this.carsRepository.findAll();
	}
	
	@GetMapping("/cars/{id}")
	public Cars getCar(@PathVariable("id") long carId) {
		return this.carsRepository.findById(carId).get();
	}

}
