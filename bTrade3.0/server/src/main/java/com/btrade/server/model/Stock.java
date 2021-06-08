package com.btrade.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "STOCK")
public class Stock 
{

	private String name;
	

	private String stockSymbol;
	
	private double stockPrice;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}


	
	
}
