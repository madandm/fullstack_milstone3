package com.iiht.stock.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.CompanyEntity;


@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	public CompanyEntity findByCompanyCode(int code);
	public List<CompanyEntity> findAll();
    @Modifying
    @Transactional
    @Query(value = "delete from s_company c where c.ID in (:ids)", nativeQuery = true)
    public void deleteBatch(@Param("ids")List<String> ids);
	@Query(value = "select " + 
			"c.ID," + 
			"c.COMPANY_NAME," + 
			"c.COMPANY_CODE," + 
			"c.EXCHANGE_ID," + 
			"c.TURN_OVER," + 
			"c.CEO," + 
			"c.BOARD_OF_DIRECTORS," + 
			"c.SECTOR_ID," + 
			"c.BRIEF " + 
			"from s_company c " + 
			"where c.COMPANY_NAME = :key or c.COMPANY_CODE = :key",
			nativeQuery = true)
	public List<CompanyEntity> findByNameOrCode(@Param("key")String key);
	
	@Query(value = "select " + 
			"s.SECTOR_NAME " + 
			"from s_sector s " + 
			"where s.SECTOR_ID = :key",
			nativeQuery = true)
	public List<String> findBySecotId(@Param("key")int key);
	
	@Query(value = "select " + 
			"s.EXCHANGE_NAME " + 
			"from s_stock_exchange s " + 
			"where s.EXCHANGE_ID = :key",
			nativeQuery = true)
	public List<String> findByExchangeId(@Param("key")int key);
}
