package com.debugger.car.domain;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.debugger.car.repository.CarsRepository;
import com.debugger.car.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class CarsUnitTest {

	@Mock
	private CarsRepository carsRepository;

	@Autowired
	private CarService carService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void addNewCarTest() throws Exception {

		// Create a new car to test
		Cars aCar = new Cars();
		aCar.setCarId(19);
		aCar.setModel("Mercedes CLA 200");
		aCar.setMake("Mercedes Benz");
		aCar.setRentalPrice(600);
		aCar.setYear(2015);

		Cars newCar = carService.add(aCar);

		assertNotNull(newCar);
		assertNotNull(newCar.getCarId());
		assertEquals(19, newCar.getCarId());
		assertEquals("Mercedes CLA 200", newCar.getModel());
		assertEquals("Mercedes Benz", newCar.getMake());
		assertEquals(600, newCar.getRentalPrice());
		assertEquals(2015, newCar.getYear());
	}

	@Test
	public void addNewCarMockTest() {
		Cars aMockCar = new Cars();
		aMockCar.setCarId(19);
		aMockCar.setModel("Mercedes CLA 200");
		aMockCar.setMake("Mercedes Benz");
		aMockCar.setRentalPrice(600);
		aMockCar.setYear(2015);

		when(carsRepository.save(any(Cars.class))).thenReturn(aMockCar);

		Cars newCar = carService.add(aMockCar);

		assertNotNull(newCar);
		assertNotNull(newCar.getCarId());
		assertEquals(19, newCar.getCarId());
		assertEquals("Mercedes CLA 200", newCar.getModel());
		assertEquals("Mercedes Benz", newCar.getMake());
		assertEquals(600, newCar.getRentalPrice());
		assertEquals(2015, newCar.getYear());

	}

}
