package com.btrade.server.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Transaction;
import com.btrade.server.service.TransactionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TransactionController 
{

	TransactionService transactionservice = new TransactionService();

	@RequestMapping(value = "/Transaction", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Transaction> getAllTransactions() 
	{
		System.out.println("In getAllTransaction!!!!!!!!!!!!!!!!!!!!!");
		List<Transaction> transactions = transactionservice.getAllTransactions();
		//System.out.println("size == " + transactions.size());
		System.out.println("Get all transaction=" + transactions);
		return transactions;

	}
	
	@RequestMapping(value = "/transaction/transactions", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Transaction> getAllTransaction() 
	{
		List<Transaction> transactions = transactionservice.getAllTransactions();
		System.out.println("Get transaction2=" + transactions);
		return transactions;

	}

	@RequestMapping(value = "/transaction/{uid_no}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Transaction> getTransactionByAccountNum(@PathVariable String uid_no)
	{
		System.out.println("Get transaction uid======================" + uid_no);
		List<Transaction> transactions = transactionservice.getTransactionsByAccountNum(uid_no);
		//EntityExample entityExample = new EntityExample();
		//System.out.println("Get transaction3=" + transactions);
		for (Transaction t : transactions)
		{
			System.out.println(t);
		}
		//System.out.println("The json data is: " + entityExample.getHello()+"  "+entityExample.getGoodbye());
		return transactions;
	}
	
	@RequestMapping(value = "/transaction/{acctNum}/{status}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Transaction> getTransactionByAccountNum(@PathVariable String acctNum, @PathVariable String status)
	{
		System.out.println("In Transaction  getTransactionByAccountNum!!!!!!!!!!!!!!!!!!!!!!!");
		List<Transaction> transactions = transactionservice.getTransactionsByAccountNum(acctNum,status);
		System.out.println("Get transaction4=" + transactions);
		return transactions;
	}
	
	@RequestMapping(value = "/transaction/{acctNum}/{status}/{beginDate}/{endDate}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Transaction> getTransactionByAccountNum(@PathVariable String acctNum, @PathVariable String status , @PathVariable String beginDate, @PathVariable String endDate) throws ParseException
	{
		System.out.println("In Transaction  getTransactionByAccountNum with start date and end date!!!!!!!!!!!!!!!!!!!!!!!");
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date beginD = dateFormat.parse(beginDate);
		Date endD = dateFormat.parse(endDate);
		List<Transaction> transactions = transactionservice.getTransactionsByAccountNum(acctNum,status,beginD,endD);
		System.out.println("Get transaction5=" + transactions);
		return transactions;
	}
}