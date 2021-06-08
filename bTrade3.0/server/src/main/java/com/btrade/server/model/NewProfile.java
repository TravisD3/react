package com.btrade.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NoArgsConstructor
public class NewProfile {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ACTIVE", columnDefinition = "char default 'N'")
	private char active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActive() {
		return Character.toString(active);
	}

	public void setActive(String input) {
		if(input != null && input.length() != 0) {
			this.active = input.charAt(0);
		}
	}

	

}