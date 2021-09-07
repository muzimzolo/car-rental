package com.debugger.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.debugger.car.domain.CarClient;

public interface ClientsRepository extends CrudRepository<CarClient, Long> {

}
