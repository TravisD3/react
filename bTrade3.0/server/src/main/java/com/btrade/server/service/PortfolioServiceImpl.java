package com.btrade.server.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Portfolio;
import com.btrade.server.repository.PortfolioRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService{
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
	@Override
	public Collection<Portfolio> portfolios() {
		System.out.println("head111111");
		Collection<Portfolio> portfolio = portfolioRepository.findAll().stream().collect(Collectors.toList());
		System.out.println("back2222:" + portfolio);
		return portfolio;
	}
	
	@Override
	public Portfolio getPortfolio(int id) {
		
		Portfolio portfolio = portfolioRepository.getOne(id);
		
		System.out.println("PortfolioID=" + portfolio.getPortfolioid());
		//return accountRepository.getOne(id);
		return portfolio;
	}
	@Override
	public void delete(int id) {
		portfolioRepository.deleteAll();
	}
	@Override
	public void save(Portfolio portfolio) {
		portfolioRepository.save(portfolio);
	}
	
	
	
}