package com.btrade.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Portfolio;
import com.btrade.server.service.PortfolioServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PortfolioController {
	@Autowired
	private PortfolioServiceImpl portfolioService;
	
	@Autowired(required = true)
	public PortfolioController(PortfolioServiceImpl PortfolioService) {
		this.portfolioService = PortfolioService;
	}
	
	@GetMapping("/portfolio")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Portfolio> getPortfolio() {
		return portfolioService.portfolios();
	}	

}
