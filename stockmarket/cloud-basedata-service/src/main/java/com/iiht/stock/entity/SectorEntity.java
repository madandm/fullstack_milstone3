package com.iiht.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_sector")
public class SectorEntity {
	private Integer id;
	private Integer sectorId;
	private String sectorName;
	private String brief;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="SECTOR_ID")
	public Integer getSectorId() {
		return sectorId;
	}
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}
	@Column(name="SECTOR_NAME")
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	@Column(name="BRIEF")
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
}
