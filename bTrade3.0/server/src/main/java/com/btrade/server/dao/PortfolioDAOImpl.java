package com.btrade.server.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.btrade.server.model.Portfolio;
/**
 * 在applicationcontext.xml中被定义为一个bean, sessionFactory, transactionManger在容器中注入
 *
 */
public class PortfolioDAOImpl implements PortfolioDAO, InitializingBean {
	private HibernateTemplate hibernateTemplate;// 在注入sessionFactory的时候new了一个HibernateTemplate
	private SessionFactory sessionFactory;//容器中注入
//	private JtaTransactionManager transactionManager;
	private HibernateTransactionManager txManager;//从容器中注入

	public PortfolioDAOImpl()
	{
		System.out.println("*******************生成PortfolioDAOImpl的Bean");
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		//System.out.println("..........................................  Portfolio from ... IN SET SESSION FACTORY  today " + sessionFactory);
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		//System.out.println("IN SET HIBERNATE TEMPLATE TODAY =" + this.hibernateTemplate);
		System.out.println("***************给ProtfolioDaoImpl注入SessionFactory*********");
	}

//	public JtaTransactionManager getTransactionManager() {
//		return transactionManager;
//	}
//
//	public void setTransactionManager(JtaTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	
	//查找所有的Portfolio
	@Override
	public List<Portfolio> listPortfolio() {
		List<Portfolio> list = this.hibernateTemplate.find("select distinct p.acctnum from Portfolio p");
		return list;
	}
    
	//根据id找出所有的list
	@Override
	public List<Portfolio> getPortfolioByAccountNum(String acctNum){
		List<Portfolio> list = this.hibernateTemplate.find("from Portfolio portfolio where portfolio.acctnum=?", acctNum);
		return list;
	}
	@Override
	public void afterPropertiesSet() throws Exception 
	{

	}


	public HibernateTransactionManager getTxManager() 
	{
		return txManager;
	}


	public void setTxManager(HibernateTransactionManager txManager) 
	{
		this.txManager = txManager;
		System.out.println("***************给ProtfolioDaoImpl注入TransactionManger*********");
	}
	
	

}
