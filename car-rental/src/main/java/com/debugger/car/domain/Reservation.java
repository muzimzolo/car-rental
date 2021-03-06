package com.debugger.car.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@Column(name = "reservation_id", unique = true)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long reservationId;

	@Column(name = "client_id")
	private long clientId;

	@Column(name = "car_id")
	private long carId;

	@Column(name = "res_date")
	private Date reservationDate;

	@OneToOne
	private Cars cars;

	@OneToOne
	private CarClient carClient;

	public Reservation() {
	}

	public Reservation(long reservationId, long clientId, long carId, Date reservationDate) {
		this.reservationId = reservationId;
		this.clientId = clientId;
		this.carId = carId;
		this.reservationDate = reservationDate;
	}

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

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public CarClient getCarClient() {
		return carClient;
	}

	public void setCarClient(CarClient carClient) {
		this.carClient = carClient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carId, clientId, reservationDate, reservationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation reservation = (Reservation) obj;
		return carId == reservation.carId && clientId == reservation.clientId
				&& Objects.equals(reservationDate, reservation.reservationDate)
				&& reservationId == reservation.reservationId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", clientId=" + clientId + ", carId=" + carId
				+ ", reservationDate=" + reservationDate + "]";
	}

}
