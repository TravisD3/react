package com.btrade.server.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Account;
import com.btrade.server.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Collection<Account> accounts() {
		return accountRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public Account getAccount(long id) {
		
		Account account = accountRepository.getOne(id);
		
		System.out.println("AcctNum=" + account.getAcct_num());
		//return accountRepository.getOne(id);
		return account;
	}
	@Override
	public void delete(Long id) {
		accountRepository.deleteById(id);
	}
	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	@Override
	public Collection<String> getAccType() {
		// TODO Auto-generated method stub
		
		Collection<String> AccType = accountRepository.getAccountType();
		//System.out.println(AccType.size());
		return AccType;
	}
	
}