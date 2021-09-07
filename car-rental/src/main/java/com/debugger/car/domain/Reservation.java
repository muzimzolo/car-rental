package com.debugger.car.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    
    @Column(name="client_id")
    private long clientId;

    
    @Column(name="car_id")
    private long carId;
    

    @Column(name="res_date")
    private Date reservationDate;


	public long getReservationId() {
		return reservationId;
	}


	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}


	public long getClientId() {
		return clientId;
	}


	public void setClientId(long clientId) {
		this.clientId = clientId;
	}


	public long getCarId() {
		return carId;
	}


	public void setCarId(long carId) {
		this.carId = carId;
	}


	public Date getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
    
    

}
