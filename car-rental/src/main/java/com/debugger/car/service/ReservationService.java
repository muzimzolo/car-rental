package com.debugger.car.service;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debugger.car.domain.Reservation;
import com.debugger.car.repository.ReservationRepository;

@Service
public class ReservationService {
	ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public Reservation createReservation(long reservationId, long clientId, long carId, Date reservationDate) {
		return reservationRepository.findById(reservationId)
				.orElse(reservationRepository.save(new Reservation(reservationId, clientId, carId, reservationDate)));
	}

	public Iterable<Reservation> lookup() {
		return reservationRepository.findAll();
	}

	public long total() {
		return reservationRepository.count();
	}
}
