package com.btrade.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Stock;
import com.btrade.server.ws.LookUpStock;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StockController
{

	
	@RequestMapping(value = "/stock/trade/{tradeType}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getTradeType(@PathVariable String tradeType) 
	{
		return tradeType;
		
	}
	
	@RequestMapping(value = "/stock/{companyName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Stock> getTradeStockSymbol(@PathVariable String companyName) 
	{
		//url:'http://localhost:8080/bTradeServer/stock/'+$scope.companyName,
		System.out.println("In Stock Controller getTradeStockSymbol companyName " + companyName);
		return LookUpStock.getStockSymbol(companyName);
		
	}
	
	/**
	 * 注意: 若@Pathvariable 中参数若带有 '.'的话会直接被截断，例如 url是FB-USD.SW，但是接收的时候会被截断成FB-USD	造成数据丢失
	 * 解决方法一: 在接收变量后面加一小段静态字符段，这个静态字符段没有意思，例如：/{stockSymbol/lll}
	 * 解决方法二：在接收变量后面使用SpEL表示，例如{/stockSymbol:.+}
	 */
	@RequestMapping(value = "/stock/trade/price/{tradeType}/{stockSymbol:.+}", method = RequestMethod.GET, headers = "Accept=application/json")
	public double getTradePrice(@PathVariable String tradeType, @PathVariable String stockSymbol)
	{
		//url:'http://localhost:8080/bTradeServer/stock/trade/price/'+$scope.tradeType+'/'+$scope.stockSymbol,
		System.out.println("In stock controller getTradePrice........ tradeType = " + tradeType + " stockSymbol " + stockSymbol);
		return LookUpStock.getStockPrice(tradeType, stockSymbol);
		
	}
}
