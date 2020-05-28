package com.iiht.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.IpoPlanedEntity;


@Repository
public interface IpoRepository extends JpaRepository<IpoPlanedEntity, Integer>{
	public IpoPlanedEntity findById(int id);
}
