package com.btrade.server.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// @Data
//@NoArgsConstructor
@Table(name = "TRADE")
public class Trade {
	@Id
	@Column(name = "TRADE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tradeId;
	
	@Column(name = "uid_no")
	private int uidNo;

	// account number from $scope(after login)
	@Column(name = "ACCT_NUM")
	private int accNumber;

	@Column(name = "TRADE_TYPE")
	private String tradeType;

	@Column(name = "STOCK_SYMBOL")
	private String tradeStockSymbol;

	@Column(name = "CURRENT_PRICE")
	private double tradeCurrentPrice;

	@Column(name = "TRADING_PRICE")
	private double tradeTradingPrice;

	@Column(name = "NUMBER_OF_SHARES")
	private int tradeNumberOfShares;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	@Column(name = "CURRENT_FUND")
	private double currentFund;

	@Column(name = "REMAINFUND")
	private Double remainFund;

	@Column(name = "TRADE_TIME")
	private String tradeTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

	@Column(name = "order_type_id")
	private Integer orderTypeId;


	public Trade() {
	}


	public Trade(Integer tradeId, int uidNo, int accNumber, String tradeType, String tradeStockSymbol,
			double tradeCurrentPrice, double tradeTradingPrice, int tradeNumberOfShares, double totalPrice,
			double currentFund, Double remainFund, String tradeTime, Integer orderTypeId) {
		super();
		this.tradeId = tradeId;
		this.uidNo = uidNo;
		this.accNumber = accNumber;
		this.tradeType = tradeType;
		this.tradeStockSymbol = tradeStockSymbol;
		this.tradeCurrentPrice = tradeCurrentPrice;
		this.tradeTradingPrice = tradeTradingPrice;
		this.tradeNumberOfShares = tradeNumberOfShares;
		this.totalPrice = totalPrice;
		this.currentFund = currentFund;
		this.remainFund = remainFund;
		this.tradeTime = tradeTime;
		this.orderTypeId = orderTypeId;
	}



	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", uidNo=" + uidNo + ", accNumber=" + accNumber + ", tradeType="
				+ tradeType + ", tradeStockSymbol=" + tradeStockSymbol + ", tradeCurrentPrice=" + tradeCurrentPrice
				+ ", tradeTradingPrice=" + tradeTradingPrice + ", tradeNumberOfShares=" + tradeNumberOfShares
				+ ", totalPrice=" + totalPrice + ", currentFund=" + currentFund + ", remainFund=" + remainFund
				+ ", tradeTime=" + tradeTime + ", orderTypeId=" + orderTypeId + "]";
	}

	public Integer getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(Integer orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	
	public int getUidNo() {
		return uidNo;
	}


	public void setUidNo(int uidNo) {
		this.uidNo = uidNo;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeStockSymbol() {
		return tradeStockSymbol;
	}

	public void setTradeStockSymbol(String tradeStockSymbol) {
		this.tradeStockSymbol = tradeStockSymbol;
	}

	public double getTradeCurrentPrice() {
		return tradeCurrentPrice;
	}

	public void setTradeCurrentPrice(double tradeCurrentPrice) {
		this.tradeCurrentPrice = tradeCurrentPrice;
	}

	public double getTradeTradingPrice() {
		return tradeTradingPrice;
	}

	public void setTradeTradingPrice(double tradeTradingPrice) {
		this.tradeTradingPrice = tradeTradingPrice;
	}

	public int getTradeNumberOfShares() {
		return tradeNumberOfShares;
	}

	public void setTradeNumberOfShares(int tradeNumberOfShares) {
		this.tradeNumberOfShares = tradeNumberOfShares;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getCurrentFund() {
		return currentFund;
	}

	public void setCurrentFund(double currentFund) {
		this.currentFund = currentFund;
	}

	public Double getRemainFund() {
		return remainFund;
	}

	public void setRemainFund(Double remainFund) {
		this.remainFund = remainFund;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

}
