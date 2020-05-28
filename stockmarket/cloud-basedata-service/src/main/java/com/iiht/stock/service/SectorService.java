package com.iiht.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.SectorEntity;
import com.iiht.stock.repository.SectorRepository;
@Service
public class SectorService {
	@Autowired
	private SectorRepository sectorRepository;

	/**
	 * find all the sector for the sectorList
	 * 
	 */
	public List<SectorEntity> findAll() {
		return sectorRepository.findAll();
	}
}
