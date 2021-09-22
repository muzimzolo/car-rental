package com.debugger.car.repository;

import org.hamcrest.Matcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.*;
import com.debugger.car.domain.CarClient;

public interface ClientsRepository extends CrudRepository<CarClient, Long> {

	CarClient save(Matcher<CarClient> any);
	
//	@Override
//    @RestResource(exported = false)
//    <S extends CarClient> S save(S s);
	
//	@Override
//    @RestResource(exported = false)
//    <S extends CarClient> Iterable<S> saveAll(Iterable<S> iterable);

	//CarClient save(Matcher<CarClient> any);

}
