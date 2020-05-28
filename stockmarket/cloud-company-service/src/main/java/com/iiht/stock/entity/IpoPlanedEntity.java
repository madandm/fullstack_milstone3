package com.iiht.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_ipo_planed")
public class IpoPlanedEntity {
	private Integer id;
	private String companyName;
	private Integer exchangeId;
	private String prePrice;
	private String totalNum;
	private String openDate;
	private String expression;
	
	@Id
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
	@Column(name="EXCHANGE_ID")
	public Integer getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}
	@Column(name="PRE_PRICE")
	public String getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(String prePrice) {
		this.prePrice = prePrice;
	}
	@Column(name="TOTAL_NUM")
	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	@Column(name="OPEN_DATE")
	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	@Column(name="EXPRESSION")
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}


	
}
