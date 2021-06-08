package com.btrade.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Account;
import com.btrade.server.service.AccountService;
import com.btrade.server.service.AccountServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired(required = true)
	public AccountController(AccountServiceImpl accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/accounts")
	public Collection<Account> getAccounts() {
		return accountService.accounts();
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable long id) {
		System.out.println("id=" + id);
		Account account = accountService.getAccount(id); 
		System.out.println("account Balance=" + account.getAvail_balance());
		return account;
	}
	
	@PutMapping("/accounts")
	public void save(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@PostMapping("/accounts")
	public void update(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@DeleteMapping("/accounts")
	public void delete(@PathVariable long id) {
		accountService.delete(id);
	}
	
	@GetMapping("/accounts/accounttype")
	public Collection<String> getAccountType() {
		//System.out.println("abc1");
		return accountService.getAccType();
	}
}