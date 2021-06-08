package com.btrade.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Order;
import com.btrade.server.service.OrderServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired(required = true)
	public OrderController(OrderServiceImpl OrderService) {
		this.orderService = OrderService;
	}
	
	@GetMapping("/order")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Order> getOrders() {
		System.out.println("OrderController");

		Collection<Order> collection = orderService.orders();
		System.out.println("OrderControllerCollection=" + collection);
		return collection;
	}
	
	@GetMapping("/order/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Order getOrder(@PathVariable long id) {
		System.out.println("id=" + id);
		Order order = orderService.getOrder(id); 
		System.out.println("trade_id=" + order.getTrade_ID());
		return order;
	}
	
//	@PutMapping("/order")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public void save(@RequestBody Order order) {
//		orderService.save(order);
//	}
	
//	@PostMapping("/accounts")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public void update(@RequestBody Order order) {
//		orderService.save(order);
//	}
	
//	@DeleteMapping("/accounts")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public void delete(@PathVariable long id) {
//		orderService.delete(id);
//	}

}
