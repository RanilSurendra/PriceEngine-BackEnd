package com.x.webapp.Technical.assessment.model;

import org.springframework.stereotype.Component;

@Component
public class PriceListDTO {

	private int noOfUnits;
	private double pricePenguinEars;
	private double priceHorseShoe;

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public double getPricePenguinEars() {
		return pricePenguinEars;
	}

	public void setPricePenguinEars(double pricePenguinEars) {
		this.pricePenguinEars = pricePenguinEars;
	}

	public double getPriceHorseShoe() {
		return priceHorseShoe;
	}

	public void setPriceHorseShoe(double priceHorseShoe) {
		this.priceHorseShoe = priceHorseShoe;
	}
}
