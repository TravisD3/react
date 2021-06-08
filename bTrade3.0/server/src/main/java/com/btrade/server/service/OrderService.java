package com.btrade.server.service;

import java.util.Collection;
import java.util.List;

import com.btrade.server.model.Order;
import com.btrade.server.model.Stock;
import com.btrade.server.model.Trade;
import com.btrade.server.model.Account;

public interface OrderService {
	
	public Collection<Order> orders();
	public Order getOrder(long id);
	public void delete(Long id);
	public void save(Order order);
	
//	public Collection<Account> getAllAccounts();
//	public double getAvailableBalance(int acctNum);
//	public List<Stock> getStockSymbol(String name);
//	public double getStockPrice(String tradeType, String symbol);
//	public Order create(Order Order);
////	public void saveOrder(Integer accNumber, String tradeType, String tradeStockSymbol, double tradeCurrentPrice, double tradeTradingPrice, Integer tradeNumberOfShares, double currentFund);

}
