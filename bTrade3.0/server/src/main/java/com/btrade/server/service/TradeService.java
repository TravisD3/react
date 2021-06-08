package com.btrade.server.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.btrade.server.model.Account;
import com.btrade.server.model.OrderType;
import com.btrade.server.model.Stock;
import com.btrade.server.model.Trade;

public interface TradeService {

	public Collection<Trade> getAllTrades();
	public Collection<Account> getAllAccounts();
	public BigDecimal getAvailableBalance(int acctNum);
	public List<Stock> getStockSymbol(String name);
	public double getStockPrice(String tradeType, String symbol);
    public Trade create(Trade trade);
    public Collection<OrderType> getAllOrderTypes();
	//public void saveTrade(Integer accNumber, String tradeType, String tradeStockSymbol, double tradeCurrentPrice, double tradeTradingPrice, Integer tradeNumberOfShares, double currentFund);

}
