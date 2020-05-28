package com.iiht.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.StockExchangeEntity;
import com.iiht.stock.repository.StockExchangeRepository;
@Service
public class StockExchangeService {
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	/**
	 * find all the company(for fuzzy match)
	 */
	public List<StockExchangeEntity> findAll() {
		return stockExchangeRepository.findAll();
	}
	/**
	 * findByExchangeName
	 */
	public StockExchangeEntity findByExchangeName(String key) {
		return stockExchangeRepository.findByExchangeName(key);
	}
	/**
	 * updateStockExchange
	 */
	public StockExchangeEntity updateStockExchange(StockExchangeEntity stock) {
		return stockExchangeRepository.save(stock);
	}
}
