package com.btrade.server.model;

import javax.persistence.Entity;

//@Entity
public class EntityExample {
	private String hello;
	private String goodbye;
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public String getGoodbye() {
		return goodbye;
	}
	public void setGoodbye(String goodbye) {
		this.goodbye = goodbye;
	}
	
}
