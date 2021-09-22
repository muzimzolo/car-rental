package com.debugger.car.repository;


import org.hamcrest.Matcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.debugger.car.domain.CarClient;
import com.debugger.car.domain.Cars;

public interface CarsRepository extends CrudRepository<Cars, Long> {

	Cars save(Matcher<Cars> any);
	

//    @Override
//    @RestResource(exported = false)
//    <S extends Cars> S save(S s);
//    
//     Cars save(Matcher<Cars> any);

}
