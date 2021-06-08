package com.btrade.server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Account;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT t FROM Account t where t.acct_num = :acct_num")
	public Account getAvailableBalance(@Param("acct_num") int acct_num);

	@Query("SELECT DISTINCT(t.acct_type) FROM Account t")
	public Collection<String> getAccountType();

}