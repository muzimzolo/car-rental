package com.debugger.car.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "clients")
public class CarClient {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id", unique = true)
	private long clientID;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address", unique = true, nullable = false)
	private String emailAddress;

	@Column(name = "mobile_number", unique = true, nullable = false)
	private String mobileNumber;

	// ==========  RELATIONSHIP REQUIRED ============
	
	
// One client can book many rental cars to drive on the same or different dates
//	@ManyToOne
//	private Cars cars;

	public CarClient() {
	}

	public CarClient(long clientID, String firstName, String lastName, String emailAddress, String mobileNumber) {
		this.clientID = clientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

//	public Cars getCars() {
//		return cars;
//	}
//
//	public void setCars(Cars cars) {
//		this.cars = cars;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(clientID, emailAddress, firstName, lastName, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarClient clients = (CarClient) obj;
		return clientID == clients.clientID && Objects.equals(emailAddress, clients.emailAddress)
				&& Objects.equals(firstName, clients.firstName) && Objects.equals(lastName, clients.lastName)
				&& Objects.equals(mobileNumber, clients.mobileNumber);
	}

	@Override
	public String toString() {
		return "CarClient [clientID=" + clientID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + "]";
	}

}
