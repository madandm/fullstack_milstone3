package com.iiht.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.SectorEntity;


@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Integer>{
	public List<SectorEntity> findAll();
}
