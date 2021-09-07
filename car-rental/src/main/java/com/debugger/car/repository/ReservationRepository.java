package com.debugger.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.debugger.car.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
