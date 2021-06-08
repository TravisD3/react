package com.btrade.server.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.btrade.server.model.AccountType;
/**
 *在applicationContext.xml中被定义为一个bean,并且给属性sessionFactory注入sessionFactory, transactionManager注入transaction
 */
public class AccountTypeDAOImpl implements AccountTypeDAO, InitializingBean{
	
	private HibernateTemplate hibernateTemplate;// 在注入sessionFactory的时候，new了一个HibernateTemplate
	private SessionFactory sessionFactory; //从容器中注入
//	private JtaTransactionManager transactionManager;
	private HibernateTransactionManager txManager;
	
	public AccountTypeDAOImpl()
	{
		System.out.println("*******************生成AccountTypeDAOImpl的Bean");
	}
	
	
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX IN SET SESSION FACTORY  today " + sessionFactory);
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		//System.out.println("IN SET HIBERNATE TEMPLATE TODAY =" + this.hibernateTemplate);
		System.out.println("***************给AccountDaoTypeImpl注入SessionFactory*********");
	}

//	public JtaTransactionManager getTransactionManager() {
//		return transactionManager;
//	}
//
//	public void setTransactionManager(JtaTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//添加
	@Override
	public void saveAccountType(AccountType accountType) {
		this.hibernateTemplate.save(accountType);
	}
	
	//查找所有的accountType
	@Override
	public List<AccountType> listAccountType() {
		List<AccountType> list = this.hibernateTemplate.find("from AccountType");
		return list;
	}
	
	//根据id找出accountType
	@Override
	public AccountType getAccountTypeById(String acct_type) {
		List<AccountType> list = this.hibernateTemplate.find("from AccountType accounttype where accounttype.acct_type=?", acct_type);
		if(list.size()==0) return null;
		return list.get(0);
	}
	
	//根据id删除accountType
	@Override
	public boolean deleteAccountTypeById(String acct_type) {
		int numOfRowsDel = this.hibernateTemplate.bulkUpdate("delete AccountType accounttype where accounttype.acct_type=?", acct_type);		
		if(numOfRowsDel==1)
			return true;
		else
			return false;
	}


	public HibernateTransactionManager getTxManager() 
	{
		return txManager;
	}


	public void setTxManager(HibernateTransactionManager txManager)
	{
		this.txManager = txManager;
		System.out.println("***************给AccountDaoTypeImpl注入SessionFactory*********");
	}

}
