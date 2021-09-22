package com.debugger.car.web;

import java.sql.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.CarClient;
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
		public Iterable<Reservation> getAllReservations() {
			return this.reservationRepository.findAll();
		}
		@GetMapping("/reservations/{id}")
		public Reservation getReservationById(@PathVariable("id") long resId) {
			return this.reservationRepository.findById(resId).get();
			
		}
		
		@PostMapping("/reservations")
		public Reservation createReservation(@RequestBody Reservation reservations) {
			return reservationRepository.save(reservations);

		}
		
		 @PutMapping("/reservations/{reservationid}")
		  Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable Long reservationId) {
		    
		    return reservationRepository.findById(reservationId)
		    		.map(reservations -> {
		    			reservation.setReservationId(reservation.getReservationId());
		    			reservation.setClientId(reservation.getClientId());
		    			reservation.setCarId(reservation.getCarId());
		    			reservation.setReservationDate(reservation.getReservationDate());
		    			
		    			// long reservationId, long clientId, long carId, Date reservationDate
		    		
		    		return reservationRepository.save(reservation);
		      })
		    		.orElseGet(() -> {
		    			reservation.setReservationId(reservationId);
		    			return reservationRepository.save(reservation);
		    		});
		 }
		 

		  @DeleteMapping("/reservations/{reservationId}")
		  void deleteClient(@PathVariable Long reservationId) {
			  reservationRepository.deleteById(reservationId);
		  }
		

		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(NoSuchElementException.class)
		public String return400(NoSuchElementException ex) {
			return ex.getMessage();

		}


	}
	