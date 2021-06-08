package com.btrade.server.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Account;
import com.btrade.server.model.Portfolio;
import com.btrade.server.repository.AccountRepository;

public interface PortfolioService {
	
	public Collection<Portfolio> portfolios();
		
	public Portfolio getPortfolio(int id);
		
	public void delete(int id);
		
	public void save(Portfolio portfolio);
		
}