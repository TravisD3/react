package com.btrade.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
@Table(name = "trade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order {

	@Id
	@Column(name = "TRADE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trade_ID;

	@Column(name = "ACCT_NUM", nullable = false)
	private Integer acct_num;

	@Column(name = "CURRENT_FUND", nullable = false)
	private Double current_fund;

	@Column(name = "REMAINFUND", nullable = false)
	private Double remainfund;

	@Column(name = "TOTAL_PRICE")
	private Double total_price;

	@Column(name = "CURRENT_PRICE")
	private Double current_price;
	
	@Column(name = "NUMBER_OF_SHARES")
	private Integer number_of_shares;
	
	@Column(name = "STOCK_SYMBOL")
	private String stock_symbol;
	
	@Column(name = "TRADE_TIME")
	private String trade_time;
	
	@Column(name = "TRADING_PRICE")
	private Double trading_price;
	
	@Column(name = "TRADE_TYPE")
	private String trade_type;

	@Column(name = "UID_NO", nullable = false)
	private Integer uid_no;

	@Column(name = "CURRENT")
	private Double current;
	
	@Column(name = "STOCK")
	private String stock;
	
	public Order() {
	}

	

	public Integer getTrade_ID() {
		return trade_ID;
	}



	public void setTrade_ID(Integer trade_ID) {
		this.trade_ID = trade_ID;
	}



	public Integer getAcct_num() {
		return acct_num;
	}



	public void setAcct_num(Integer acct_num) {
		this.acct_num = acct_num;
	}



	public Double getCurrent_fund() {
		return current_fund;
	}



	public void setCurrent_fund(Double current_fund) {
		this.current_fund = current_fund;
	}



	public Double getRemainfund() {
		return remainfund;
	}



	public void setRemainfund(Double remainfund) {
		this.remainfund = remainfund;
	}



	public Double getTotal_price() {
		return total_price;
	}



	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}



	public Double getCurrent_price() {
		return current_price;
	}



	public void setCurrent_price(Double current_price) {
		this.current_price = current_price;
	}



	public Integer getNumber_of_shares() {
		return number_of_shares;
	}



	public void setNumber_of_shares(Integer number_of_shares) {
		this.number_of_shares = number_of_shares;
	}



	public String getStock_symbol() {
		return stock_symbol;
	}



	public void setStock_symbol(String stock_symbol) {
		this.stock_symbol = stock_symbol;
	}



	public String getTrade_time() {
		return trade_time;
	}



	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}



	public Double getTrading_price() {
		return trading_price;
	}



	public void setTrading_price(Double trading_price) {
		this.trading_price = trading_price;
	}



	public String getTrade_type() {
		return trade_type;
	}



	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}



	public Integer getUid_no() {
		return uid_no;
	}



	public void setUid_no(Integer uid_no) {
		this.uid_no = uid_no;
	}



	public Double getCurrent() {
		return current;
	}



	public void setCurrent(Double current) {
		this.current = current;
	}



	public String getStock() {
		return stock;
	}



	public void setStock(String stock) {
		this.stock = stock;
	}

	
	
	
	public Order(Integer trade_ID, Integer acct_num, Double current_fund, Double remainfund, Double total_price,
			Double current_price, Integer number_of_shares, String stock_symbol, String trade_time,
			Double trading_price, String trade_type, Integer uid_no, Double current, String stock) {
		super();
		this.trade_ID = trade_ID;
		this.acct_num = acct_num;
		this.current_fund = current_fund;
		this.remainfund = remainfund;
		this.total_price = total_price;
		this.current_price = current_price;
		this.number_of_shares = number_of_shares;
		this.stock_symbol = stock_symbol;
		this.trade_time = trade_time;
		this.trading_price = trading_price;
		this.trade_type = trade_type;
		this.uid_no = uid_no;
		this.current = current;
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Order [trade_ID=" + trade_ID + ", acct_num=" + acct_num + ", current_fund=" + current_fund
				+ ", remainfund=" + remainfund + ", total_price=" + total_price + ", current_price=" + current_price
				+ ", number_of_shares=" + number_of_shares + ", stock_symbol=" + stock_symbol + ", trade_time="
				+ trade_time + ", trading_price=" + trading_price + ", trade_type=" + trade_type + ", uid_no=" + uid_no
				+ ", current=" + current + ", stock=" + stock + "]";
	}




}
