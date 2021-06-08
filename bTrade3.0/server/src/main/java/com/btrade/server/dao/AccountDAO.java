package com.btrade.server.dao;

import java.util.List;
import com.btrade.server.model.Account;

public interface AccountDAO {
	public void saveAccount(Account account);
	public List<Account> listAccount();
	public List<Account> getAccountsByUid_no(int uid_no);
	public Account getAccountById(int acct_id);
	public boolean deleteAccountById(int acct_id);
}
