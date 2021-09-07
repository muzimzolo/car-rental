package com.debugger.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.debugger.car.domain.Cars;

public interface CarsRepository extends CrudRepository<Cars, Long> {

}
