package com.iiht.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.StockpriceEntity;
import com.iiht.stock.repository.StockpriceRepository;
@Service
public class StockpriceService {
	@Autowired
	private StockpriceRepository stockpriceRepository;


	/**
	 * find the stockprice and period for compare
	 * @param key:company name or code
	 * @param from:period from
	 * @param end:period end
	 * @return List<StockpriceEntity>
	 */
	public List<StockpriceEntity> findStockPrice(String key, String from, String end) {
		return stockpriceRepository.findStockPrice(key, from, end);
	}
	
	/**
	 * find the maxday of month for the month display
	 * @param key:company name or code
	 * @return List<String>
	 */
	public List<String> findMaxDayofMonth(String key) {
		return stockpriceRepository.findMaxDayofMonth(key);
	}
	
}
