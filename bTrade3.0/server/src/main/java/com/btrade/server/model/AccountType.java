package com.btrade.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCT_TYPE")
public class AccountType {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ACCT_TYPE", nullable = false)
	private String acct_type;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	public AccountType() {
	}

	public String getAcct_type() {
		return acct_type;
	}

	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountType(String acct_type, String description) {
		super();
		this.acct_type = acct_type;
		this.description = description;
	}

}
