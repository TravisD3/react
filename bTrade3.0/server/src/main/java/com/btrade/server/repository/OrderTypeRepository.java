package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.OrderType;

@Component
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}
