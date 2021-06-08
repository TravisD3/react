package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.btrade.server.model.Car;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
@Component
public interface CarRepository extends JpaRepository<Car, Long> {
}