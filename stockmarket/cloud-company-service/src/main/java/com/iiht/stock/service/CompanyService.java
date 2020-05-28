package com.iiht.stock.service;

import java.util.List;

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
	public List<CompanyModel> findAll(String key) {
		return companyRepository.findAll(key);
	}

	/**
	 * find all the company(for fuzzy match)
	 */
	public CompanyModel findByNameOrCode(String key) {
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
	public void deleteBatch(List<Integer> idlist) {
		companyRepository.deleteBatch(idlist);
	}

}
