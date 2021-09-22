package com.debugger.car.web;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.CarClient;
import com.debugger.car.domain.Cars;
import com.debugger.car.repository.CarsRepository;

@RestController
@RequestMapping
public class CarsController {

	private CarsRepository carsRepository;

	public CarsController(CarsRepository carsRepository) {
		super();
		this.carsRepository = carsRepository;
	}

	@GetMapping("/cars")
	public Iterable<Cars> getAllCars() {
		return this.carsRepository.findAll();
	}

	@GetMapping("/cars/{id}")
	public Cars getCarById(@PathVariable("id") long carId) {
		return this.carsRepository.findById(carId).get();
	}

	@PostMapping("/cars")
	public Cars createNewCar(@RequestBody Cars cars) {
		if (cars != null) {
	  }
		return carsRepository.save(cars);
	}

	@PutMapping("/cars/{carId}")
	Cars removeCar(@RequestBody Cars newCar, @PathVariable Long carId) {

		return carsRepository.findById(carId).map(cars -> {
			cars.setCarId(newCar.getCarId());
			cars.setModel(newCar.getModel());
			cars.setMake(newCar.getMake());
			cars.setRentalPrice(newCar.getRentalPrice());
			cars.setYear(newCar.getYear());

			return carsRepository.save(newCar);
		}).orElseGet(() -> {
			newCar.setCarId(carId);
			return carsRepository.save(newCar);

		});

	}

	@DeleteMapping("/cars/{carId}")
	void deleteClient(@PathVariable Long carId) {
		carsRepository.deleteById(carId);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}

}