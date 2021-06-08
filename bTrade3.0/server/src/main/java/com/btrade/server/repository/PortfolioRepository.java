package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Portfolio;

@Component
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
