package com.btrade.server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Account;

@Component
public interface AccountTypeRepository extends JpaRepository<Account, Long> {

	@Query("SELECT DISTINCT(t.acct_type) FROM AccountType t")
	public Collection<String> getAccountTypes();

}