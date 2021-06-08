package com.btrade.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = org.hibernate.annotations.OptimisticLockType.ALL)
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "ID")
	private long id;
	@Version
	@Column(name = "VERSION")
	private int version;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	// private Timestamp version;

	public Customer() {
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		// System.out.println("INSIDE GET FIRST NAME  +++++++++= " + firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		// System.out.println("INSIDE SET FIRST NAME BUT LAST NAME= ----------"
		// + lastName + "FIRST NAME =" + firstName);
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @Version
	protected int getVersion() {
		System.out.println("get VERSION == " + version);

		return version;
	}

	protected void setVersion(int version) {
		System.out.println("set VERSION == " + version);
		this.version = version;
	}

}
