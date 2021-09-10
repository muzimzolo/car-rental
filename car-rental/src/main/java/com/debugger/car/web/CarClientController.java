package com.debugger.car.web;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.debugger.car.domain.CarClient;
import com.debugger.car.repository.ClientsRepository;
import com.debugger.car.entity.CarClientDto;

@RestController
@RequestMapping
public class CarClientController {

	private ClientsRepository clientsRepository;

	public CarClientController(ClientsRepository clientsRepository) {
		this.clientsRepository = clientsRepository;
	}

	@GetMapping("/clients")
	public Iterable<CarClient> getAllClients() {
		return this.clientsRepository.findAll();
	}

	@GetMapping("/clients/{id}")
	public CarClient getClientById(@PathVariable("id") long clientId) {
		return this.clientsRepository.findById(clientId).get();
	}

        
	@PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	// double check carID
	public void createCarClient(@PathVariable(value = "clientID") long clientID, @RequestBody @Validated CarClientDto carClientDto) {
        CarClient carClients = verifyCarClient(clientID);
        clientsRepository.save(carClients);
	}
	

	private CarClient verifyCarClient(long clientID) throws NoSuchElementException {
		return clientsRepository.findById(clientID)
				.orElseThrow(() -> new NoSuchElementException("Client does not exist " + clientID));
	}
}
