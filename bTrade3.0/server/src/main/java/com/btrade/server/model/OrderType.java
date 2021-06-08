package com.btrade.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
@Table(name = "order_type")
public class OrderType {
	@Id
	@Column(name = "order_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderTypeId;
	
	@Column(name = "order_type")
	private String orderType;
	
	public Integer getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(Integer orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	public OrderType() {
		super();
	}

	public OrderType(Integer orderTypeId, String orderType) {
		super();
		this.orderTypeId = orderTypeId;
		this.orderType = orderType;
	}
}
