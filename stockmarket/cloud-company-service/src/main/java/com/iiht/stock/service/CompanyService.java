package com.iiht.stock.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.CompanyEntity;
import com.iiht.stock.repository.CompanyRepository;
import com.iiht.stock.vo.CompanyModel;
@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;


	/**
	 * find all the company(for fuzzy match)
	 */
	public List<CompanyEntity> findByNameOrCode(String key) {
		return companyRepository.findByNameOrCode(key);
	}
	
	/**
	 * find by code
	 */
	public CompanyEntity findByCompanyCode(int code) {
		return companyRepository.findByCompanyCode(code);
	}
	/**
	 * updateCompany
	 */
	public CompanyEntity updatecompany(CompanyEntity company) {
		return companyRepository.save(company);
	}

	/**
	 * delete
	 */
	public void deleteBatch(List<String> idlist) {
		companyRepository.deleteBatch(idlist);
	}
	
	/**
	 * find the SecotName by SecotId
	 */
	public List<String> findBySecotId(int key) {
		return companyRepository.findBySecotId(key);
	}
	
	/**
	 * find the ExchangeName by ExchangeId
	 */
	public List<String> findByExchangeId(int key) {
		return companyRepository.findByExchangeId(key);
	}
	
	public List<CompanyEntity> findAll() {
		return companyRepository.findAll();
	}

}
