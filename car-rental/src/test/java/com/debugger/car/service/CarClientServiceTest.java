package com.debugger.car.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.debugger.car.domain.CarClient;
import com.debugger.car.repository.ClientsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class CarClientServiceTest {

	@Mock
	private ClientsRepository clientsRepository;

	@Autowired
	private CarClientService carClientService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addNewClientTest() throws Exception {

		// create a new client
		CarClient aClient = new CarClient();
		aClient.setClientID(14);
		aClient.setFirstName("Tom");
		aClient.setLastName("Jerry");
		aClient.setEmailAddress("tom&jerry@gmail.com");
		aClient.setMobileNumber("0645386492");

		CarClient newClient = carClientService.add(aClient);

		assertNotNull(newClient);
		assertNotNull(newClient.getClientID());
		assertEquals("Tom", newClient.getFirstName());
	}

	@Test
	public void addNewClientMockTest() {
		CarClient aMockClient = new CarClient();
		aMockClient.setClientID(13);
		aMockClient.setFirstName("Jerry");
		aMockClient.setLastName("Springer");
		aMockClient.setEmailAddress("jspringer@gmail.com");
		aMockClient.setMobileNumber("0656367464");

		when(clientsRepository.save(any(CarClient.class))).thenReturn(aMockClient);

		// save the client
		CarClient newClient = carClientService.add(aMockClient);

		// verify the save
		assertNotNull(newClient);
		assertNotNull(newClient.getClientID());
		assertEquals("Jerry", newClient.getFirstName());
		assertEquals("Springer", newClient.getLastName());
		assertEquals("jspringer@gmail.com", newClient.getEmailAddress());
		assertEquals("0656367464", newClient.getMobileNumber());

	}
}
