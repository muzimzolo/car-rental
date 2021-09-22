package com.debugger.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debugger.car.domain.Cars;
import com.debugger.car.repository.CarsRepository;

@Service
public class CarService {
	
	@Autowired
	CarsRepository carsRepository;

	@Autowired
	public CarService(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	public Cars createCar(long carId, String model, String make, int rentalPrice, int year) {
		return carsRepository.findById(carId)
				.orElse(carsRepository.save(new Cars(carId, model, make, rentalPrice, year)));
	}

	public Iterable<Cars> lookup() {
		return carsRepository.findAll();
	}

	public long total() {
		return carsRepository.count();
	}

	public Cars add(Cars aCar) {
		Cars newCar = null;
		if (aCar.getModel() != null) {
			newCar = carsRepository.save(aCar);
		}
		return newCar;
	}

}
