package com.x.webapp.Technical.assessment.model;

import org.springframework.stereotype.Component;

@Component
public class PriceReqDTO {

	private String productName;
	private String unitType;
	private int qty;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "PriceReqDto{" + "productName='" + productName + '\'' + ", productType='" + unitType + '\'' + ", " +
				"qty=" + qty + '}';
	}
}
