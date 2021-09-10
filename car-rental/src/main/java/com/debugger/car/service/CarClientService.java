package com.debugger.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debugger.car.domain.CarClient;
import com.debugger.car.repository.ClientsRepository;

@Service
public class CarClientService {

	ClientsRepository clientsRepository;

	@Autowired
	public CarClientService(ClientsRepository clientsRepository) {
		this.clientsRepository = clientsRepository;
	}

	public CarClient createClient(long clientID, String firstName, String lastName, String emailAddress,
			String mobileNumber) {
		return clientsRepository.findById(clientID)
				.orElse(clientsRepository.save(new CarClient(clientID, 
						firstName, lastName, emailAddress, mobileNumber)));
	}

	public Iterable<CarClient> lookup() {
		return clientsRepository.findAll();
	}

	public long total() {
		return clientsRepository.count();
	}

}
