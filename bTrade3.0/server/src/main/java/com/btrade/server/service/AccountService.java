package com.btrade.server.service;

import java.util.Collection;

import com.btrade.server.model.Account;

public interface AccountService {

	public Collection<Account> accounts();

	public Collection<String> getAccType();

	public Account getAccount(long id);

	public void delete(Long id);

	public void save(Account account);

}