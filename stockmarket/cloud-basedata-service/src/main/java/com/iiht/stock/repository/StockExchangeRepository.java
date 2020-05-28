package com.iiht.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.StockExchangeEntity;


@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, Integer>{
	public List<StockExchangeEntity> findAll();
	
	public StockExchangeEntity findByExchangeName(String name);
}
