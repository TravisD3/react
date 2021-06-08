package com.btrade.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Setter
	// @Getter
	private @NonNull String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}