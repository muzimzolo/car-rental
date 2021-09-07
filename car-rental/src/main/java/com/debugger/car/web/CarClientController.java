package com.debugger.car.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.CarClient;
import com.debugger.car.repository.ClientsRepository;

@RestController
@RequestMapping
public class CarClientController {
	
	private ClientsRepository clientsRepository;

	public CarClientController(ClientsRepository clientsRepository) {
		super();
		this.clientsRepository = clientsRepository;
	}
	
	@GetMapping("/clients")
	public Iterable<CarClient> getAllClients() {
		return this.clientsRepository.findAll();
	}
	
//	@GetMapping("/{id}")
//	public CarClient getClientById(@PathVariable("id") long clientId) {
//		return this.clientsRepository.findById(clientId).get();
//	}

}
