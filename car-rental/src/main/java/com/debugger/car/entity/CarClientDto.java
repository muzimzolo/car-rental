package com.debugger.car.entity;

import com.debugger.car.domain.CarClient;

public class CarClientDto {

	private long clientID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String mobileNumber;

	public CarClientDto(CarClient carClient) {
		this(carClient.getClientID(), carClient.getFirstName(), carClient.getLastName(), 
				carClient.getEmailAddress(), carClient.getMobileNumber());
	}

	protected CarClientDto() {

	}

	private CarClientDto(long clientID, String firstName, String lastName, 
			String emailAddress, String mobileNumber) {
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

}
