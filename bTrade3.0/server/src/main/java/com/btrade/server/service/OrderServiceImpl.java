package com.btrade.server.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Order;
import com.btrade.server.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Collection<Order> orders() {
		System.out.println("OrderServiceImpl");
		Collection<Order> collection = orderRepository.findAll().stream().collect(Collectors.toList());
		System.out.println("OrderServiceCollection=" + collection);
		return collection;
	}
	
	@Override
	public Order getOrder(long id) {
		
		Order order = orderRepository.getOne(id);
		
		System.out.println("OrderNum=" + order.getTrade_ID());
		//return orderRepository.getOne(id);
		return order;
	}
	
	@Override
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}
	
	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}



}