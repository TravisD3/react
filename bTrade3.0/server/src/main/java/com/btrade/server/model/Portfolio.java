package com.btrade.server.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "portfolio")
public class Portfolio{

	@Id
	@Column(name = "PORTFOLIOID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioid;
	
	public Portfolio(){
	}
	public int getPortfolioid(){
		return portfolioid;
	}
	

	@Column(name = "ACCTNUM", nullable = false, length = 8)
	private String acctnum;

	public String getAcctnum(){
		return this.acctnum;
	}

	
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
	
	public int getQuantity() {
		return this.quantity;
	}

	
	@Column(name = "SYMBOL", nullable = false, length = 6)
	private String symbol;
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Column(name = "MARKETVALUE", nullable = false, length = 6)
	private BigDecimal marketvalue;
	public BigDecimal getMarketvalue() {
		return this.marketvalue;
	}

	public void setMarketvalue(BigDecimal marketvalue) {
		this.marketvalue = marketvalue;
	}
	

	@Column(name = "DAYSGAIN", nullable = false, precision = 10)
	private BigDecimal daysgain;
	public BigDecimal getDaysgain() {
		return this.daysgain;
	}

	public void setDaysgain(BigDecimal daysgain) {
		this.daysgain = daysgain;
	}

	@Column(name = "TOTALGAIN", nullable = false, precision = 10)
	private BigDecimal totalgain;
	public BigDecimal getTotalgain() {
		return this.totalgain;
	}

	public void setTotalgain(BigDecimal totalgain) {
		this.totalgain = totalgain;
	}
	
	@Column(name = "PERCENTGAIN", nullable = false, precision = 10)
	private BigDecimal percentgain;
	public BigDecimal getPercentgain() {
		return this.percentgain;
	}

	public void setPercentgain(BigDecimal percentgain) {
		this.percentgain = percentgain;
	}
	
	@Column(name = "LAST", nullable = false, precision = 10)
	private BigDecimal last;
	public BigDecimal getLast() {
		return this.last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
	}

	public void setPortfolioid(int portfolioid) {
		this.portfolioid = portfolioid;
	}
	public void setAcctnum(String acctnum) {
		this.acctnum = acctnum;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Portfolio [portfolioid=" + portfolioid + ", acctnum=" + acctnum + ", quantity=" + quantity + ", symbol="
				+ symbol + ", marketvalue=" + marketvalue + ", daysgain=" + daysgain + ", totalgain=" + totalgain
				+ ", percentgain=" + percentgain + ", last=" + last + "]";
	}

	

}
