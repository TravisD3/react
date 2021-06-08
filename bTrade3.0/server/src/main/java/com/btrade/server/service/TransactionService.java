package com.btrade.server.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import com.btrade.server.dao.TransactionDAO;
import com.btrade.server.model.Transaction;
import com.btrade.server.servlet.GetSpringContextServlet;

@Transactional
public class TransactionService {
	WebApplicationContext springContext;
	TransactionDAO transDAO;
	//因为在第四步读取web.xml的时候已经将web.xml中定义的servlet加载(调用其init()方法)完成-->这时候rootContext已经赋值，可以拿到容器中的bean
	public List<Transaction> getAllTransactions() {
		springContext = GetSpringContextServlet.rootContext;
		transDAO = (TransactionDAO) springContext.getBean("transactionDAO");
		//List<Transaction> list = transDAO.listTransaction();
		List<Transaction> list = transDAO.listAllTransactions();
		System.out.println("Retrieve all transaction=" + list);
		return list;

	}
	
	public List<Transaction> getTransactionsByAccountNum(String acctNum) {

		springContext = GetSpringContextServlet.rootContext;
		transDAO = (TransactionDAO) springContext.getBean("transactionDAO");
		List<Transaction> list = transDAO.getTransactionByAccountNum(acctNum);
		return list;
		
	}
	
	public List<Transaction> getTransactionsByAccountNum(String acctNum, String status) {

		springContext = GetSpringContextServlet.rootContext;
		transDAO = (TransactionDAO) springContext.getBean("transactionDAO");
		List<Transaction> list = transDAO.getTransactionByAccountNum(acctNum,status);
		return list;

	}
	
	public List<Transaction> getTransactionsByAccountNum(String acctNum, String status, Date beginDate, Date endDate) {

		springContext = GetSpringContextServlet.rootContext;
		transDAO = (TransactionDAO) springContext.getBean("transactionDAO");
		List<Transaction> list = transDAO.getTransactionByAccountNum(acctNum,status,beginDate,endDate);
		return list;

	}

}