package com.x.webapp.Technical.assessment.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceListResultDTO {

	private List<PriceListDTO> priceList;

	public List<PriceListDTO> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PriceListDTO> priceList) {
		this.priceList = priceList;
	}
}
