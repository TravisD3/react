package com.btrade.server.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Car;
import com.btrade.server.repository.CarRepository;

@Service
public class CoolCarServiceImpl implements CoolCarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public Collection<Car> coolCars() {
		return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}

	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") && !car.getName().equals("Triumph Stag")
				&& !car.getName().equals("Ford Pinto") && !car.getName().equals("Yugo GV");
	}
}
