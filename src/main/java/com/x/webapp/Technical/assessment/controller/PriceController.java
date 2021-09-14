package com.x.webapp.Technical.assessment.controller;

import com.x.webapp.Technical.assessment.model.PriceListResultDTO;
import com.x.webapp.Technical.assessment.model.PriceReqDTO;
import com.x.webapp.Technical.assessment.model.PriceResDTO;
import com.x.webapp.Technical.assessment.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("price")
@CrossOrigin
public class PriceController {

	@Autowired
	PriceReqDTO priceReqDto;

	@Autowired
	PriceService priceService;

	/**
	 * This method is used to calculate the price of the given inputs.
	 * @param productName name of the product
	 * @param type whether single or by carton
	 * @param qty
	 * @return PriceResDTO
	 */
	@GetMapping(path = "/{productName}/{type}/{qty}", produces = "application/json")
	public PriceResDTO price(@PathVariable String productName,@PathVariable String type,@PathVariable int qty){

		priceReqDto.setProductName(productName);
		priceReqDto.setUnitType(type);
		priceReqDto.setQty(qty);

		PriceResDTO priceResDTO = priceService.priceCalculator(priceReqDto);

		return priceResDTO;
	}

	/**
	 * This method is used to get all the prices of the products of 50 items
	 * @return PriceListResultDTO
	 */
	@GetMapping(path = "/list",produces = "application/json")
	public PriceListResultDTO priceList(){
		return priceService.priceList();
	}
}
