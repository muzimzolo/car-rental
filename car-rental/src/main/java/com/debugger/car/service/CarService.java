package com.debugger.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;



import com.debugger.car.domain.Cars;
import com.debugger.car.model.CarsModel;
import com.debugger.car.repository.CarsRepository;

@Service
public class CarService {
	
	@Autowired
	CarsRepository carsRepository;
	
	private static final String CARS = "/cars";
	private static final String SLASH = "/";
	
	@Value("${cars.rental.service.url}")
	private String carServiceUrl;
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	public CarService(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	public Cars createCar(long carId, String model, String make, int rentalPrice, int year) {
		return carsRepository.findById(carId)
				.orElse(carsRepository.save(new Cars(carId, model, make, rentalPrice, year)));
	}

	public Iterable<Cars> lookup() {
		return carsRepository.findAll();
	}

	public long total() {
		return carsRepository.count();
	}

	public Cars add(Cars aCar) {
		Cars newCar = null;
		if (aCar.getModel() != null) {
			newCar = carsRepository.save(aCar);
		}
		return newCar;
	}
	
	// URL MAPPINGS
	
	public List<Cars> getAllCars(){
        String url = carServiceUrl + CARS;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<Cars>>() { }).getBody();
    }

    public Cars addCar(CarsModel guestModel){
        String url = carServiceUrl + CARS;
        HttpEntity<CarsModel> request = new HttpEntity<>(guestModel, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, Cars.class).getBody();
    }

    public Cars getCar(long id) {
        String url = carServiceUrl + CARS + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Cars.class).getBody();
    }

    public Cars updateCar(long id, CarsModel guestModel) {
        System.out.println(guestModel);
        String url = carServiceUrl + CARS + SLASH + id;
        HttpEntity<CarsModel> request = new HttpEntity<>(guestModel, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Cars.class).getBody();
    }
}
