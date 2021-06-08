package com.btrade.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Car;
import com.btrade.server.service.CoolCarService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
class CoolCarController {

	@Autowired
	private CoolCarService coolCarService;

	@Autowired(required = true)
	public CoolCarController(CoolCarService coolCarService) {
		this.coolCarService = coolCarService;
	}

	// public CoolCarController(CarRepository repository) {
	// this.repository = repository;
	// }

	@GetMapping("/cool-cars")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> coolCars() {
		return coolCarService.coolCars();
	}

}