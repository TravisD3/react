package com.btrade.server.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Account;
import com.btrade.server.model.OrderType;
import com.btrade.server.model.Stock;
import com.btrade.server.model.Trade;
import com.btrade.server.repository.AccountRepository;
import com.btrade.server.repository.OrderTypeRepository;
import com.btrade.server.repository.TradeRepository;
import com.btrade.server.ws.LookUpStock;


@Service
public class TradeServiceImpl implements TradeService{
	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OrderTypeRepository orderTypeRepository;

	@Override
	public Collection<Trade> getAllTrades() {
		return tradeRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public Collection<Account> getAllAccounts(){
		return accountRepository.findAll().stream().collect(Collectors.toList());
	}
	
    @Override
    public Trade create(Trade trade) {
        return tradeRepository.save(trade);
    }
    
    @Override
    public Collection<OrderType> getAllOrderTypes(){
    	return orderTypeRepository.findAll().stream().collect(Collectors.toList());
    }
    

	//因为在第四步读取web.xml的时候已经将web.xml中定义的servlet加载(调用其init()方法)完成-->这时候rootContext已经赋值，可以拿到容器中的bean
//	public List<Trade> getAllTrades() {
//
//		WebApplicationContext springContext = GetSpringContextServlet.rootContext;
//
//		// test2
//		//System.out.println("springContext: " + springContext);
//		TradeDAO tradeDAO = (TradeDAO) springContext.getBean("myTradeDAO");
//		List<Trade> list = tradeDAO.listTrade();
//		return list;
//
//	}
//	

	public BigDecimal getAvailableBalance(int acctNum) {	
		return accountRepository.getAvailableBalance(acctNum).getBalance();
	}
	
	
	public List<Stock> getStockSymbol(String name){
		
		return  LookUpStock.getStockSymbol(name);
	}
	
	
	public double getStockPrice(String tradeType, String symbol){
		
		return  LookUpStock.getStockPrice(tradeType, symbol);
		
	}
//	public void saveTrade(Integer accNumber, String tradeType, String tradeStockSymbol, double tradeCurrentPrice, double tradeTradingPrice, Integer tradeNumberOfShares, double currentFund) {
//		System.out.println("spring context0"+tradeType);
//		WebApplicationContext springContext = GetSpringContextServlet.rootContext;
//		System.out.println("spring context"+springContext);
//		TradeDAO tradeDAO = (TradeDAO) springContext.getBean("myTradeDAO");
//		System.out.println("tradeDao"+tradeDAO);
//		 tradeDAO.saveTrade(accNumber,tradeType,  tradeStockSymbol, tradeCurrentPrice, tradeTradingPrice, tradeNumberOfShares,  currentFund);
//	}	
}