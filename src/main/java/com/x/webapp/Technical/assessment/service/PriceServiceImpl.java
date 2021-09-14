package com.x.webapp.Technical.assessment.service;

import com.x.webapp.Technical.assessment.model.*;
import com.x.webapp.Technical.assessment.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	PriceListDTO priceListDTO;

	@Autowired
	PriceListResultDTO priceListResultDTO;

	@Autowired
	PriceResDTO priceResDTO;

	@Override
	public PriceListResultDTO priceList() {

		Map<Integer, Double> productPriceMap = new TreeMap<>();
		List<PriceListDTO> lst = new ArrayList<>();

		List<Product> productValues = priceRepository.findAll();

		for (int i = 0; i < productValues.size(); i++) {
			Map<Integer, Double> pricesMap = getPricesOfCartonSizes(productValues.get(i).getCartonPrice(),
					productValues.get(i).getCartonSize(), 50, productPriceMap);

			Map<Integer, Double> resultMap = getProductPrices(productValues.get(i).getCartonPrice(),
					productValues.get(i).getCartonSize(), 50, pricesMap);

			for (int j = 1; j <= 50; j++) {
				priceListDTO = new PriceListDTO();
				if (productValues.get(i).getName().equalsIgnoreCase("penguin-ears")) {
					priceListDTO.setNoOfUnits(j);
					priceListDTO.setPricePenguinEars(resultMap.get(j));
					lst.add(priceListDTO);
				}
				if (productValues.get(i).getName().equalsIgnoreCase("horse-shoe")) {

					lst.get(j - 1).setPriceHorseShoe(resultMap.get(j));

				}

			}
		}
		priceListResultDTO.setPriceList(lst);

		return priceListResultDTO;
	}

	/**
	 * This method calculates the prices of products according to the given inputs.
	 * @param priceReqDTO
	 * @return PriceResDTO
	 */
	@Override
	public PriceResDTO priceCalculator(PriceReqDTO priceReqDTO) {

		List<Product> productValues = priceRepository.findAll();
		priceResDTO = new PriceResDTO();

		for (int i = 0; i < productValues.size(); i++) {

			if (productValues.get(i).getName().equalsIgnoreCase(priceReqDTO.getProductName()) && priceReqDTO
					.getProductName().equalsIgnoreCase("penguin-ears")) {

				double penguinCartonPrice = productValues.get(i).getCartonPrice();

				if (priceReqDTO.getUnitType().equalsIgnoreCase("single")) {

					priceResDTO
							.setPrice(priceList().getPriceList().get(priceReqDTO.getQty() - 1).getPricePenguinEars());

				} else if (priceReqDTO.getUnitType().equalsIgnoreCase("carton")) {
					double price = priceReqDTO.getQty() * penguinCartonPrice;
					priceResDTO.setPrice(price);
				}

			} else if (productValues.get(i).getName().equalsIgnoreCase(priceReqDTO.getProductName()) && priceReqDTO
					.getProductName().equalsIgnoreCase("horse-shoe")) {

				double horseCartonPrice = productValues.get(i).getCartonPrice();

				if (priceReqDTO.getUnitType().equalsIgnoreCase("single")) {

					priceResDTO.setPrice(priceList().getPriceList().get(priceReqDTO.getQty() - 1).getPriceHorseShoe());

				} else if (priceReqDTO.getUnitType().equalsIgnoreCase("carton")) {
					double price = priceReqDTO.getQty() * horseCartonPrice;
					priceResDTO.setPrice(price);
				}

			}
		}

		return priceResDTO;
	}

	/**
	 * This method calculate the unit prices of the products.
	 * @param cartonPrice
	 * @param cartonSize
	 * @param noOfItems
	 * @param pricesMap
	 * @return prices of unit and carton wise as a Map
	 */
	public Map<Integer, Double> getProductPrices(double cartonPrice, int cartonSize, int noOfItems, Map pricesMap) {
		double price = 0;
		boolean flag = false;

		for (int i = 1; i <= noOfItems; i++) {

			if (i % cartonSize == 0) {
					flag = true;
					continue;
				}
				if (!flag) {
					price = (i) * cartonPrice * 1.3;
				} else {

					price = Double.sum(cartonPrice, (Double) pricesMap.get(i - cartonSize));
				}
			pricesMap.put(i, price);
		}
		return pricesMap;
	}

	/**
	 *This method calculate the carton size prices.
	 * @param cartonPrice
	 * @param cartonSize
	 * @param noOfItems
	 * @param productPriceMap
	 * @return Map
	 */
	public Map<Integer, Double> getPricesOfCartonSizes(double cartonPrice, int cartonSize, int noOfItems,
			Map productPriceMap) {
		int count = 0;

		for (int i = cartonSize; i <= noOfItems; i += cartonSize) {
			count = count + 1;
			productPriceMap.put(cartonSize * count, cartonPrice * count);
		}
		return productPriceMap;
	}
}
