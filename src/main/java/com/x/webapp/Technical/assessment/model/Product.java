package com.x.webapp.Technical.assessment.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product", schema = "99x")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int Id;

	private String name;
	private double cartonPrice;
	private int cartonSize;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCartonPrice() {
		return cartonPrice;
	}

	public void setCartonPrice(double cartonPrice) {
		this.cartonPrice = cartonPrice;
	}

	public int getCartonSize() {
		return cartonSize;
	}

	public void setCartonSize(int cartonSize) {
		this.cartonSize = cartonSize;
	}
}
