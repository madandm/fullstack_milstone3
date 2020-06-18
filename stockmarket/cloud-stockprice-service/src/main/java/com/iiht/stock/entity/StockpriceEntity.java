package com.iiht.stock.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="s_stock_price")
public class StockpriceEntity {
	private Integer id;
	private int companyCode;
	private String companyName;
	private BigDecimal currentPrice;
	private BigDecimal openPrice;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private String priceDate;
	@Transient
	private int week;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="COMPANY_CODE")
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	@Column(name="CURRENT_PRICE")
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	@Column(name="PRICE_DATE")
	public String getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}
	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="OPEN_PRICE")
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	@Column(name="HIGH_PRICE")
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	@Column(name="LOW_PRICE")
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
}
