package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Trade;

@Component
public interface TradeRepository extends JpaRepository<Trade, Integer> {
}