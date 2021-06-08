package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Transaction;

@Component
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}