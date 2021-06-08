package com.btrade.server.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	@Column(name = "ACCT_NUM", nullable = false, length = 8)
	private String acctNum;

	@Column(name = "TRADE_DATE", nullable = false, length = 10)
	private Date tradeDate;

	@Column(name = "CRET_DTM", nullable = false, length = 19)
	private Date cretDtm;

	@Column(name = "BUY_SELL", nullable = false, length = 1)
	private String buySell;

	@Column(name = "QUANTITY", nullable = false)
	private int quantity;

	@Column(name = "SYMBOL", nullable = false, length = 6)
	private String symbol;

	@Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(name = "TOTAL", nullable = false, precision = 10, scale = 2)
	private BigDecimal total;

	@Column(name = "STATUS", nullable = false, length = 1)
	private String status;

	public Transaction() {
	}

	public Transaction(Long transactionId, String acctNum, Date tradeDate, Date cretDtm, String buySell, int quantity,
			String symbol, BigDecimal price, BigDecimal total, String status) {
		super();
		this.transactionId = transactionId;
		this.acctNum = acctNum;
		this.tradeDate = tradeDate;
		this.cretDtm = cretDtm;
		this.buySell = buySell;
		this.quantity = quantity;
		this.symbol = symbol;
		this.price = price;
		this.total = total;
		this.status = status;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getCretDtm() {
		return cretDtm;
	}

	public void setCretDtm(Date cretDtm) {
		this.cretDtm = cretDtm;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Transaction = [ " + "Account Num : " + this.getAcctNum() + " Buy Sell: " + this.buySell + " Quantity : "
				+ this.getQuantity() + " Status : " + this.getStatus() + " Symbol : " + this.getSymbol()
				+ " Transaction ID : " + this.getTransactionId() + " Create Date : " + this.getCretDtm() + " Price"
				+ this.getPrice() + " Total : " + this.getTotal() + " Trade Date : " + this.getTradeDate() + " ]";
	}

}
