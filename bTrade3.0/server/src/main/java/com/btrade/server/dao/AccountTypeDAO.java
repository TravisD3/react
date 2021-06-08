package com.btrade.server.dao;

import java.util.List;

import com.btrade.server.model.AccountType;

public interface AccountTypeDAO {
	public void saveAccountType(AccountType accountType);
	public List<AccountType> listAccountType();
	public AccountType getAccountTypeById(String acct_type);
	public boolean deleteAccountTypeById(String acct_type);
}
