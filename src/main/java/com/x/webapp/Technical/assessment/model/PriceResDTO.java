package com.x.webapp.Technical.assessment.model;

import org.springframework.stereotype.Component;

@Component
public class PriceResDTO {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
