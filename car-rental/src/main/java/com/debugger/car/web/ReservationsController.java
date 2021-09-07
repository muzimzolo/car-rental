package com.debugger.car.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.Reservation;
import com.debugger.car.repository.ReservationRepository;

@RestController
@RequestMapping
public class ReservationsController {

	private ReservationRepository reservationRepository;
		
		public ReservationsController(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

		@GetMapping("/reservations")
		public Iterable<Reservation> getAllClients() {
			return this.reservationRepository.findAll();
		}
		
//		@GetMapping("/{id}")
//		public Reservation getReservationById(@PathVariable("id") long resId) {
//			return this.reservationRepository.findById(resId).get();
//			
//		}

	}
	