package com.debugger.car.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.*;
import org.springframework.data.rest.core.annotation.RestResource;
import com.debugger.car.domain.CarClient;

public interface ClientsRepository extends CrudRepository<CarClient, Long> {
	
	@Override
    @RestResource(exported = false)
    <S extends CarClient> S save(S s);
	
	@Override
    @RestResource(exported = false)
    <S extends CarClient> Iterable<S> saveAll(Iterable<S> iterable);

}
