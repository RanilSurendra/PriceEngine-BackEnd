package com.x.webapp.Technical.assessment.service;

import com.x.webapp.Technical.assessment.model.PriceListResultDTO;
import com.x.webapp.Technical.assessment.model.PriceReqDTO;
import com.x.webapp.Technical.assessment.model.PriceResDTO;

public interface PriceService {

	public PriceListResultDTO priceList();

	public PriceResDTO priceCalculator(PriceReqDTO priceReqDTO);
}
