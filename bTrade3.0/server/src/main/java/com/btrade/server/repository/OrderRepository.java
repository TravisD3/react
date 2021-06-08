package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Order;

@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

//	@Query("SELECT t FROM Account t where t.acct_num = :acct_num")
//	public Account getAvailableBalance(@Param("acct_num") int acct_num);

}
