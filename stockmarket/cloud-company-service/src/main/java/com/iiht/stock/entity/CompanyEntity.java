package com.iiht.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_company")
public class CompanyEntity {
	private Integer id;
	private String companyName;
	private Integer companyCode;
	private Integer exchangeId;
	private String turnOver;
	private String ceo;
	private String boardOfDrectors;
	private Integer sectorId;
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
	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="COMPANY_CODE")
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	@Column(name="EXCHANGE_ID")
	public Integer getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}
	@Column(name="TURN_OVER")
	public String getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}
	@Column(name="CEO")
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	@Column(name="BOARD_OF_DIRECTORS")
	public String getBoardOfDrectors() {
		return boardOfDrectors;
	}
	public void setBoardOfDrectors(String boardOfDrectors) {
		this.boardOfDrectors = boardOfDrectors;
	}
	@Column(name="SECTOR_ID")
	public Integer getSectorId() {
		return sectorId;
	}
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}
	@Column(name="BRIEF")
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
