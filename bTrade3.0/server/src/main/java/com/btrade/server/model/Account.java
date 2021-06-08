package com.btrade.server.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
//@NoArgsConstructor
@Table(name = "ACCOUNT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account {

	@Id
	@Column(name = "ACCT_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long acct_Id;

	@Column(name = "ACCT_NUM", nullable = false)
	private int acct_num;

	@Column(name = "ACCT_TYPE", nullable = false)
	private String acct_type;

	@Column(name = "SUB_TYPE", nullable = false)
	private String sub_type;

	@Column(name = "BALANCE", precision = 10, scale=2)
	private BigDecimal balance;

	@Column(name = "AVAIL_BALANCE", precision = 10, scale=2)
	private BigDecimal avail_balance;

	@Column(name = "UID_NO", nullable = false)
	private int uid_no;

	public Account() {
	}

	public Long getAcct_Id() {
		return acct_Id;
	}

	public void setAcct_Id(Long acct_Id) {
		this.acct_Id = acct_Id;
	}

	public int getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public String getAcct_type() {
		return acct_type;
	}

	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getAvail_balance() {
		return avail_balance;
	}

	public void setAvail_balance(BigDecimal avail_balance) {
		this.avail_balance = avail_balance;
	}

	public int getUid_no() {
		return uid_no;
	}

	public void setUid_no(int uid_no) {
		this.uid_no = uid_no;
	}

	public Account(int acct_num, String acct_type, String sub_type, BigDecimal precision, BigDecimal avail_balance,
			int uid_no) {
		super();
		this.acct_num = acct_num;
		this.acct_type = acct_type;
		this.sub_type = sub_type;
		this.balance = precision;
		this.avail_balance = avail_balance;
		this.uid_no = uid_no;
	}

	@Override
	public String toString() {
		return "Account [acct_Id=" + acct_Id + ", acct_num=" + acct_num + ", acct_type=" + acct_type + ", sub_type="
				+ sub_type + ", precision=" + balance + ", avail_balance=" + avail_balance + ", uid_no=" + uid_no
				+ "]";
	}

}
