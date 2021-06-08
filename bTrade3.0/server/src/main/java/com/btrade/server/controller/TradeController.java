package com.btrade.server.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Account;
import com.btrade.server.model.OrderType;
import com.btrade.server.model.Stock;
import com.btrade.server.model.Trade;
import com.btrade.server.service.TradeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/trading" })
class TradeController {

	@Autowired
	private TradeService tradeService;

	@Autowired(required = true)
	public TradeController(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	// public CoolCarController(CarRepository repository) {
	// this.repository = repository;
	// }
	@PostMapping
	public Trade create(@RequestBody Trade trade) {
		System.out.println("In create: " + trade.toString());
		return tradeService.create(trade);
	}

	// ------ get account id ---------
	@GetMapping(path = { "/account" })
	public Collection<Account> getAllAccounts() {
		return tradeService.getAllAccounts();
	}

	// --------------
	@GetMapping
	public Collection<Trade> getAllTrades() {
		return tradeService.getAllTrades();
	}

	@GetMapping(path = { "/account/{acct_num}" })
	public BigDecimal findbalance(@PathVariable("acct_num") String acct_num) {
		return tradeService.getAvailableBalance(Integer.parseInt(acct_num));
	}

	@GetMapping(path = { "/stockSymbol/{stock_symbol}" })
	public List<Stock> getStockSymbol(@PathVariable("stock_symbol") String stock_symbol) {
		
		return tradeService.getStockSymbol(stock_symbol);
	}

	@GetMapping(path = { "/stockPrice/{tradeType}/{stock_symbol}" })
	public double getStockPrice(@PathVariable("tradeType") String tradeType,
			@PathVariable("stock_symbol") String stock_symbol) {
		return tradeService.getStockPrice(tradeType, stock_symbol);
	}
	
	@GetMapping(path = { "/orderTypes" })
	public Collection<OrderType> getAllOrderTypes(){
		
		return tradeService.getAllOrderTypes();
	}

}