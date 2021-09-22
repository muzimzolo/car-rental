package com.debugger.car.web;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.debugger.car.domain.CarClient;
import com.debugger.car.domain.Reservation;
import com.debugger.car.dto.CarClientDto;
import com.debugger.car.repository.ClientsRepository;
import com.debugger.car.repository.ReservationRepository;
import com.debugger.car.service.CarClientService;

@RestController
@RequestMapping
public class CarClientController {

	private ClientsRepository clientsRepository;


	public CarClientController(ClientsRepository clientsRepository) {
		super();
		this.clientsRepository = clientsRepository;
	}

	@GetMapping("/clients")
	public Iterable<CarClient> getAllCarClients() {
		return this.clientsRepository.findAll();
	}

	// improve this with custom exception
	@GetMapping("/clients/{id}")
	public ResponseEntity<CarClient> getClientById(@PathVariable(value = "id") Long ClientID) throws Exception {
		CarClient carClient = clientsRepository.findById(ClientID)
				.orElseThrow(() -> new Exception("client for this id  " + ClientID + " not found "));
		return ResponseEntity.ok().body(carClient);
	}

	@PostMapping("/clients")
	public CarClient createClient(@RequestBody CarClient clients) {
		return clientsRepository.save(clients);

	}
	
	 @PutMapping("/employees/{id}")
	  CarClient replaceClient(@RequestBody CarClient newCarClient, @PathVariable Long clientId) {
	    
	    return clientsRepository.findById(clientId)
	    		.map(clients -> {
	    		    	  clients.setClientID(newCarClient.getClientID());
	    		    	  clients.setFirstName(newCarClient.getFirstName());
	    		    	  clients.setLastName(newCarClient.getLastName());
	    		    	  clients.setEmailAddress(newCarClient.getEmailAddress());
	    		    	  clients.setMobileNumber(newCarClient.getMobileNumber());
	    		
	    		return clientsRepository.save(newCarClient);
	      })
	    		.orElseGet(() -> {
	    			newCarClient.setClientID(clientId);
	    			return clientsRepository.save(newCarClient);
	    		});
	 }
	 

	  @DeleteMapping("/clients/{clientId}")
	  void deleteClient(@PathVariable Long clientId) {
	    clientsRepository.deleteById(clientId);
	  }
	

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}

}
