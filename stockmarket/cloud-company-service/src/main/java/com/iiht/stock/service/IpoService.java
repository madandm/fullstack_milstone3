package com.iiht.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.IpoPlanedEntity;
import com.iiht.stock.repository.IpoRepository;
@Service
public class IpoService {
	@Autowired
	private IpoRepository ipoRepository;

	/**
	 * findById
	 */
	public IpoPlanedEntity findById(int id) {
		return ipoRepository.findById(id);
	}
	
	/**
	 * updateIpo
	 */
	public IpoPlanedEntity updateIpo(IpoPlanedEntity ipo) {
		return ipoRepository.save(ipo);
	}

}
