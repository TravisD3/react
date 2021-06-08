package com.btrade.server.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
//import org.springframework.transaction.jta.JtaTransactionManager;
import com.btrade.server.model.Account;
/**
 * 在applicationContext.xml中被定义为一个bean,并且给属性sessionFactory注入
 *
 */
public class AccountDAOImpl implements AccountDAO, InitializingBean{
	
	private HibernateTemplate hibernateTemplate; // 在注入sessionFactory的时候，new了一个HibernateTemplate
	private SessionFactory sessionFactory;//从容器中注入
	//private JtaTransactionManager transactionManager;
	private HibernateTransactionManager txManager;//容器中注入
	
	public AccountDAOImpl()
	{
		System.out.println("*******************生成AccountDAOImpl的Bean");
	}

	//保存账号
	@Override
	public void saveAccount(Account account)
	{
		this.hibernateTemplate.saveOrUpdate(account);
	}
	
	//查找所有的账号
	@Override
	public List<Account> listAccount() 
	{
		@SuppressWarnings("unchecked")
		List<Account> list = this.hibernateTemplate.find("from Account");
		return list;
	}
	
	//通过account_number来查找账号
	@Override
	public Account getAccountById(int acct_num)
	{
		@SuppressWarnings("unchecked")
		List<Account> list = this.hibernateTemplate.find("from Account account where account.acct_num=?", acct_num);
		if(list.size()==0) return null;
		return list.get(0);
	}
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception 
	{
		System.out.println("inside set properties and after today ");
	}
	
	
//	public JtaTransactionManager getTransactionManager() {
//		return transactionManager;
//	}
//
//	public void setTransactionManager(JtaTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}


	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		//System.out.println("IN SET SESSION FACTORY  today " + sessionFactory);
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		//System.out.println("IN SET HIBERNATE TEMPLATE TODAY =" + this.hibernateTemplate);	
		System.out.println("***************给AccountDaoImpl注入SessionFactory*********");
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	//通过id删除账号
	@Override
	public boolean deleteAccountById(int acct_num) 
	{
		//批量更新
		int numOfRowsDel = this.hibernateTemplate.bulkUpdate("delete Account account where account.acct_num=?", acct_num);		
		if(numOfRowsDel==1)
			return true;
		else
			return false;
	}
	
	//取出特定账号
	@Override
	public List<Account> getAccountsByUid_no(int uid_no) 
	{
		@SuppressWarnings("unchecked")
		List<Account> list = this.hibernateTemplate.find("from Account account where account.uid_no=? order by account.acct_type", uid_no);
		return list;
	}

	public HibernateTransactionManager getTxManager() 
	{
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager) 
	{
		this.txManager = txManager;
		System.out.println("***************给AccountDaoImpl注入TransactionManager*********");
	}

}
