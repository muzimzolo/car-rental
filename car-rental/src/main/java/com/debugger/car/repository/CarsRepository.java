package com.debugger.car.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.debugger.car.domain.Cars;

public interface CarsRepository extends CrudRepository<Cars, Long> {
	

    @Override
    @RestResource(exported = false)
    <S extends Cars> S save(S s);

}
