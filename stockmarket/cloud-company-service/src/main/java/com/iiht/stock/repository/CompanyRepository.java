package com.iiht.stock.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.CompanyEntity;
import com.iiht.stock.vo.CompanyModel;


@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	public CompanyEntity findByCompanyCode(int code);
    @Modifying
    @Transactional
    @Query(value = "delete from s_company c where c.ID in (:ids)", nativeQuery = true)
    public void deleteBatch(@Param("ids")List<Integer> ids);
	@Query(value = "select " + 
			"c.ID," + 
			"c.COMPANY_NAME," + 
			"c.COMPANY_CODE," + 
			"e.EXCHANGE_NAME," + 
			"c.TURN_OVER," + 
			"c.CEO," + 
			"c.BOARD_OF_DIRECTORS,	" + 
			"s.SECTOR_NAME," + 
			"c.BRIEF " + 
			"from s_company c " + 
			"inner join s_sector s on c.SECTOR_ID = s.SECTOR_ID " + 
			"inner join s_stock_exchange e on c.EXCHANGE_ID = e.EXCHANGE_ID " + 
			"where c.COMPANY_NAME = :key or c.COMPANY_CODE = :key",
			nativeQuery = true)
	public CompanyModel findByNameOrCode(@Param("key")String key);
	
	@Query(value = "select " + 
			"c.ID," + 
			"c.COMPANY_NAME," + 
			"c.COMPANY_CODE," + 
			"e.EXCHANGE_NAME," + 
			"c.TURN_OVER," + 
			"c.CEO," + 
			"c.BOARD_OF_DIRECTORS,	" + 
			"s.SECTOR_NAME," + 
			"c.BRIEF " + 
			"from s_company c " + 
			"inner join s_sector s on c.SECTOR_ID = s.SECTOR_ID " + 
			"inner join s_stock_exchange e on c.EXCHANGE_ID = e.EXCHANGE_ID " + 
			"where c.COMPANY_NAME like :key or c.COMPANY_CODE like :key",
			nativeQuery = true)
	
	public List<CompanyModel> findAll(@Param("key")String name);
}
