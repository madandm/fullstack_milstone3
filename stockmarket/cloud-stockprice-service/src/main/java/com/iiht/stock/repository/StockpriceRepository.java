package com.iiht.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.StockpriceEntity;


@Repository
public interface StockpriceRepository extends JpaRepository<StockpriceEntity, Integer>{
	@Query(value = "select s.ID, s.COMPANY_CODE, s.COMPANY_NAME, s.CURRENT_PRICE, s.OPEN_PRICE, s.HIGH_PRICE, s.LOW_PRICE, date_format(s.PRICE_DATE, '%Y-%m-%d') as PRICE_DATE, DAYOFWEEK(s.PRICE_DATE) as week from s_stock_price s where (s.COMPANY_CODE = :key or s.COMPANY_NAME = :key) and if(:from!=null or :from!='',s.PRICE_DATE between :from and :end,1=1)", nativeQuery = true)
	public List<StockpriceEntity> findStockPrice(@Param("key")String key, @Param("from")String from, @Param("end")String end);
	
	@Query(value = "select date_format(MAX(s.PRICE_DATE), '%Y-%m-%d') from stockmarket.s_stock_price s where s.COMPANY_CODE = :key or s.COMPANY_NAME = :key group by date_format((s.PRICE_DATE), '%m')", nativeQuery = true)
	public List<String> findMaxDayofMonth(@Param("key")String key);
}
