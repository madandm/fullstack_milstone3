package com.iiht.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_stock_exchange")
public class StockExchangeEntity {
	private Integer id;
	private Integer exchangeId;
	private String exchangeName;
	private String brief;
	private String contactAddr;
	private String remarks;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="EXCHANGE_ID")
	public Integer getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}
	@Column(name="EXCHANGE_NAME")
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	@Column(name="BRIEF")
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	@Column(name="CONTACT_ADDR")
	public String getContactAddr() {
		return contactAddr;
	}
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}
	@Column(name="REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
